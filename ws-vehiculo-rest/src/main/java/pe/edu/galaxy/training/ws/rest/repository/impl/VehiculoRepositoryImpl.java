package pe.edu.galaxy.training.ws.rest.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.VehiculoRepository;

@Repository
public class VehiculoRepositoryImpl implements VehiculoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Vehiculo listarPorPlaca(String placa) throws RepositoryException {
        Vehiculo vehiculo = null;
        List<Vehiculo> lstVehiculo = null;

        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("vehiculo.listar.por.placa");
            spq.setParameter("P_PLACA", placa);

            if (spq.execute()) {
                lstVehiculo = (List<Vehiculo>) spq.getOutputParameterValue("P_C_CURSOR");
                if (lstVehiculo != null && !lstVehiculo.isEmpty()) {
                    vehiculo = lstVehiculo.get(0);
                }
            }
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            em.close();
        }

        return vehiculo;
    }

    @Override
    public List<Vehiculo> listarPorAno(int ano) throws RepositoryException {
        List<Vehiculo> lstVehiculo = null;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("vehiculo.listar.por.ano");
            spq.setParameter("P_ANO", ano);

            if (spq.execute()) {
                lstVehiculo = (List<Vehiculo>) spq.getOutputParameterValue("P_C_CURSOR");
            }
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            em.close();
        }

        return lstVehiculo;
    }

    @Override
    public boolean insertar(Vehiculo vehiculo) throws RepositoryException {
        boolean result = false;

        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("vehiculo.insertar");
            spq.setParameter("P_PLACA", vehiculo.getPlaca());
            spq.setParameter("P_MARCA", vehiculo.getMarca());
            spq.setParameter("P_MODELO", vehiculo.getModelo());
            spq.setParameter("P_ANO", vehiculo.getAno());
            spq.execute();
            Object codigo = spq.getOutputParameterValue(1);
            if (codigo != null) {
                vehiculo.setCodigo(Integer.valueOf(codigo.toString()));
                result = true;
            }
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public boolean actualizar(Vehiculo vehiculo) throws RepositoryException {
        boolean result = false;

        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("vehiculo.actualizar");
            spq.setParameter("P_CODIGO", vehiculo.getCodigo());
            spq.setParameter("P_PLACA", vehiculo.getPlaca());
            spq.setParameter("P_MARCA", vehiculo.getMarca());
            spq.setParameter("P_MODELO", vehiculo.getModelo());
            spq.setParameter("P_ANO", vehiculo.getAno());
            spq.execute();
            result = true;
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public boolean eliminar(Vehiculo vehiculo) throws RepositoryException {
        boolean result = false;

        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("vehiculo.eliminar");
            spq.setParameter("P_CODIGO", vehiculo.getCodigo());
            spq.execute();
            result = true;
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            em.close();
        }

        return result;
    }

    @Override
    public boolean existePlaca(Vehiculo vehiculo) throws RepositoryException {
        boolean result = false;
        int num = 0;

        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("vehiculo.validar.placa");
            spq.setParameter("P_CODIGO", vehiculo.getCodigo());
            spq.setParameter("P_PLACA", vehiculo.getPlaca());

            spq.execute();
            num = (Integer) spq.getOutputParameterValue(1);
            if (num > 0) {
                result = true;
            }
        } catch (Exception e) {
            throw new RepositoryException(e);
        } finally {
            em.close();
        }

        return result;
    }
}
