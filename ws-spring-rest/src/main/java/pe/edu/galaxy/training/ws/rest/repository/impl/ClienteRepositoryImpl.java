package pe.edu.galaxy.training.ws.rest.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.ClienteRepository;

@Transactional
@Repository("clienteRepository")
public class ClienteRepositoryImpl implements ClienteRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean insert(Cliente cliente) throws RepositoryException {
        boolean sw = false;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.insert");

            spq.setParameter("P_RAZON_SOCIAL", cliente.getRazonSocial());
            spq.setParameter("P_RUC", cliente.getRuc());
            spq.setParameter("P_DIRECCION", cliente.getDireccion());
            spq.execute();
            Object id = spq.getOutputParameterValue(1);// P_ID_CLIENTE
            if (id != null) {
                cliente.setIdCliente(Integer.valueOf(id.toString()));
                sw = true;
            }

        } catch (Exception e) {
            sw = false;
            throw new RepositoryException(e);
        }
        return sw;
    }

    @Override
    public boolean update(Cliente cliente) throws RepositoryException {
        boolean sw = false;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.update");

            spq.setParameter("P_ID_CLIENTE", cliente.getIdCliente());
            spq.setParameter("P_RAZON_SOCIAL", cliente.getRazonSocial());
            spq.setParameter("P_RUC", cliente.getRuc());
            spq.setParameter("P_DIRECCION", cliente.getDireccion());
            spq.execute();
            sw = true;
        } catch (Exception e) {
            sw = false;
            throw new RepositoryException(e);
        }
        return sw;
    }

    @Override
    public boolean delete(Cliente cliente) throws RepositoryException {
        boolean sw = false;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.delete");

            spq.setParameter("P_ID_CLIENTE", cliente.getIdCliente());
            spq.execute();
            sw = true;
        } catch (Exception e) {
            sw = false;
            throw new RepositoryException(e);
        }
        return sw;
    }

    @Override
    public Cliente findByObject(Cliente prmObject) throws RepositoryException {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findByLikeObject(Cliente cliente)
            throws RepositoryException {
        List<Cliente> lstCliente = null;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.listar");

            if (spq.execute()) {
                lstCliente = (List<Cliente>) spq
                        .getOutputParameterValue("P_C_CURSOR");
            }
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RepositoryException(e);
        }
        return lstCliente;
    }

    @Override
    public Cliente findByRUC(String ruc) throws RepositoryException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Cliente> findByLikeRZ(String rz) throws RepositoryException {
        List<Cliente> lstCliente = null;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.findByLikeRZ");
            spq.setParameter("P_RAZON_SOCIAL", rz);
            if (spq.execute()) {
                lstCliente = (List<Cliente>) spq
                        .getOutputParameterValue("P_C_CURSOR");

            }
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RepositoryException(e);
        }
        return lstCliente;
    }

    @Override
    public boolean validarRazonSocial(Cliente cliente) throws RepositoryException {
        boolean sw = false;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.validar.razon.social");
            spq.setParameter("P_ID_CLIENTE", cliente.getIdCliente());
            spq.setParameter("P_RAZON_SOCIAL", cliente.getRazonSocial());
            spq.execute();
            Object ret = spq.getOutputParameterValue(1);
            if (ret != null) {
                if (Integer.valueOf(ret.toString()) == 0) {
                    sw = true;
                }
            }

            em.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RepositoryException(e);
        }
        return sw;
    }

    @Override
    public boolean validarRuc(Cliente cliente) throws RepositoryException {
        boolean sw = false;
        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("cliente.validar.ruc");
            spq.setParameter("P_ID_CLIENTE", cliente.getIdCliente());
            spq.setParameter("P_RUC", cliente.getRuc());
            spq.execute();
            Object ret = spq.getOutputParameterValue(1);
            if (ret != null) {
                if (Integer.valueOf(ret.toString()) == 0) {
                    sw = true;
                }
            }

            em.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RepositoryException(e);
        }
        return sw;
    }

}
