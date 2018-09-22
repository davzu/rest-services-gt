package pe.edu.galaxy.training.ws.rest.service.inf;

import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;

public interface UsuarioService {

    public boolean credencialesValida(Usuario usuario) throws ServiceException;

}
