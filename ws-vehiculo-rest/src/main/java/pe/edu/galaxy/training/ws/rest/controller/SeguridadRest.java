package pe.edu.galaxy.training.ws.rest.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.galaxy.training.ws.rest.bean.ResponseEntity;
import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.UsuarioService;
import static pe.edu.galaxy.training.ws.rest.sid.CodigosHttpConstantes.HTTP_COD_401;
import pe.edu.galaxy.training.ws.rest.sid.SidSingleton;
import pe.edu.galaxy.training.ws.rest.util.Authorization;

@Component
public class SeguridadRest {
    
    @Autowired
    private SidSingleton sidSingleton;
    @Autowired
    private UsuarioService usuarioService;
    
    public ResponseEntity validarUsuario(String auth) throws ServiceException {
        ResponseEntity responseEntity = null;
        Map.Entry<String, String> entryResponse;
        boolean usuarioValido = false;
        Usuario usuario = Authorization.getUsuarioFromBasicAuth(auth);

        if (usuario == null) {
            responseEntity = new ResponseEntity();
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_401);
            responseEntity.setRespuestaHttp(entryResponse);
        } else {
            usuarioValido = usuarioService.credencialesValida(usuario);
            if (!usuarioValido) {
                responseEntity = new ResponseEntity();
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_401);
                responseEntity.setRespuestaHttp(entryResponse);
            }
        }
        
        return responseEntity;
    }
    
}
