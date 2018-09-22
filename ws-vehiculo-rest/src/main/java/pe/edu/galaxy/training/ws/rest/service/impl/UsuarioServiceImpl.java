package pe.edu.galaxy.training.ws.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.repository.exception.RepositoryException;
import pe.edu.galaxy.training.ws.rest.repository.inf.UsuarioRepository;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean credencialesValida(Usuario usuario) throws ServiceException {
        try {
            return usuarioRepository.credencialesValida(usuario);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

}
