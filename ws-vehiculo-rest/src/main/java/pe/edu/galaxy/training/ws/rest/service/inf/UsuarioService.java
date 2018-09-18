package pe.edu.galaxy.training.ws.rest.service.inf;

import pe.edu.galaxy.training.ws.rest.entity.Usuario;

public interface UsuarioService {
    
    public boolean credencialesValida(Usuario usuario);
    
}
