package pe.edu.galaxy.training.ws.rest.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.entity.Taller;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.TallerRepository;

@Transactional
@Repository("tallerRepository")
public class TallerRepositoryImpl implements TallerRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean insert(Taller taller) throws RepositoryException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("taller.insert");

			spq.setParameter("P_NOMBRE", taller.getNombre());
			spq.setParameter("P_DESCRIPCION", taller.getDescripcion());
			spq.execute();
			Object id = spq.getOutputParameterValue(1);
			if (id != null) {
				taller.setId(Integer.valueOf(id.toString()));
				sw = true;
			}

		} catch (Exception e) {
			sw = false;
			throw new RepositoryException(e);
		}
		return sw;
	}

	@Override
	public boolean update(Taller taller) throws RepositoryException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("taller.update");
			spq.setParameter("P_ID_TALLER", taller.getId());
			spq.setParameter("P_NOMBRE", taller.getNombre());
			spq.setParameter("P_DESCRIPCION", taller.getDescripcion());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			throw new RepositoryException(e);
		}

		return sw;
	}

	@Override
	public boolean delete(Taller taller) throws RepositoryException {
		boolean sw = false;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("taller.delete");
			spq.setParameter("P_ID_TALLER", taller.getId());
			spq.execute();
			sw = true;
		} catch (Exception e) {
			throw new RepositoryException(e);
		}

		return sw;
	}

	@Override
	public Taller findByObject(Taller taller) throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Taller> findByLikeObject(Taller taller)
			throws RepositoryException {

		List<Taller> lstTaller = null;
		try {
			StoredProcedureQuery spq = em
					.createNamedStoredProcedureQuery("taller.listar");
			spq.setParameter("P_NOMBRE", taller.getNombre());

			if (spq.execute()) {
				lstTaller = (List<Taller>) spq
						.getOutputParameterValue("P_C_CURSOR");
			}
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException(e);
		}
		return lstTaller;

	}

}
