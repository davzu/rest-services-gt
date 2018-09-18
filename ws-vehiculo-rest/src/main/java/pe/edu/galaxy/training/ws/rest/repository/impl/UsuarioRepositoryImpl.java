package pe.edu.galaxy.training.ws.rest.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.repository.inf.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean credencialesValida(Usuario usuario) {
        boolean result = false;
        int num = 0;

        try {
            StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.validar.credenciales");
            spq.setParameter("P_ID_USUARIO", usuario.getId());
            spq.setParameter("P_CLAVE", usuario.getClave());

            spq.execute();
            num = (Integer) spq.getOutputParameterValue(1);
            if (num > 0) {
                result = true;
            }
        } finally {
            em.close();
        }

        return result;
    }

}
