package pe.edu.galaxy.training.ws.rest.controller;

import java.util.List;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.galaxy.training.ws.rest.bean.ResponseEntity;
import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.service.inf.VehiculoService;
import static pe.edu.galaxy.training.ws.rest.sid.CodigosHttpConstantes.*;
import pe.edu.galaxy.training.ws.rest.sid.SidSingleton;
import pe.edu.galaxy.training.ws.rest.util.Authorization;

@RequestMapping("/vehiculoService/v1")
@Controller
public class VehiculoController extends SeguridadRest {

    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private SidSingleton sidSingleton;

    @RequestMapping(value = "/listarPorPlaca/{placa}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity listarPorPlaca(@RequestHeader("Authorization") String auth, @PathVariable("placa") String placa) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;

        responseEntity = validarUsuario(auth);
        if (responseEntity != null) {
            return responseEntity;
        }
        responseEntity = new ResponseEntity();

        responseEntity.setData(vehiculoService.listarPorPlaca(placa));
        entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
        responseEntity.setRespuestaHttp(entryResponse);

        return responseEntity;
    }

    @RequestMapping(value = "/listarPorAno", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity listarPorAno(@RequestHeader("Authorization") String auth, @RequestParam("ano") int ano) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;

        responseEntity = validarUsuario(auth);
        if (responseEntity != null) {
            return responseEntity;
        }
        responseEntity = new ResponseEntity();

        responseEntity.setData(vehiculoService.listarPorAno(ano));
        entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
        responseEntity.setRespuestaHttp(entryResponse);

        return responseEntity;
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity insertar(@RequestHeader("Authorization") String auth, @RequestBody Vehiculo vehiculo) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;

        responseEntity = validarUsuario(auth);
        if (responseEntity != null) {
            return responseEntity;
        }
        responseEntity = new ResponseEntity();

        boolean transaccionOK = vehiculoService.insertar(vehiculo);

        if (transaccionOK) {
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
            responseEntity.setRespuestaHttp(entryResponse);
        } else {
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_5050);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity actualizar(@RequestHeader("Authorization") String auth, @RequestBody Vehiculo vehiculo) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;

        responseEntity = validarUsuario(auth);
        if (responseEntity != null) {
            return responseEntity;
        }
        responseEntity = new ResponseEntity();

        boolean transaccionOK = vehiculoService.actualizar(vehiculo);

        if (transaccionOK) {
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
            responseEntity.setRespuestaHttp(entryResponse);
        } else {
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_5051);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity eliminar(@RequestHeader("Authorization") String auth, @RequestBody Vehiculo vehiculo) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;

        responseEntity = validarUsuario(auth);
        if (responseEntity != null) {
            return responseEntity;
        }
        responseEntity = new ResponseEntity();

        boolean transaccionOK = vehiculoService.eliminar(vehiculo);

        if (transaccionOK) {
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
            responseEntity.setRespuestaHttp(entryResponse);
        } else {
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_5052);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

}
