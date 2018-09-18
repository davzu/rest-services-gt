package pe.edu.galaxy.training.ws.rest.repository.inf;

import pe.edu.galaxy.training.ws.rest.entity.Usuario;

public interface UsuarioRepository {

    public boolean credencialesValida(Usuario usuario);

}
