package pe.edu.galaxy.training.ws.rest.repository.inf;

import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;

public interface UsuarioRepository {

    public boolean credencialesValida(Usuario usuario) throws RepositoryException;

}
