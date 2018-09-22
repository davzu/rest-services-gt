package pe.edu.galaxy.training.ws.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.apache.commons.beanutils.BeanUtils;
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
import pe.edu.galaxy.training.ws.rest.bean.VehiculoBean;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.service.inf.VehiculoService;
import static pe.edu.galaxy.training.ws.rest.sid.CodigosHttpConstantes.*;
import pe.edu.galaxy.training.ws.rest.sid.SidSingleton;
import pe.edu.galaxy.training.ws.rest.util.ValidadorVehiculo;

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
        VehiculoBean vehiculoBean = null;

        try {
            responseEntity = validarUsuario(auth);
            if (responseEntity != null) {
                return responseEntity;
            }
            responseEntity = new ResponseEntity();

            vehiculoBean = getVehiculoBeanFromVehiculo(vehiculoService.listarPorPlaca(placa));
            responseEntity.setData(vehiculoBean);
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
            responseEntity.setRespuestaHttp(entryResponse);
        } catch (Exception e) {
            responseEntity = new ResponseEntity();
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_500);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/listarPorAno", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity listarPorAno(@RequestHeader("Authorization") String auth, @RequestParam("ano") int ano) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;
        List<VehiculoBean> lstVehiculoBean = null;

        try {
            responseEntity = validarUsuario(auth);
            if (responseEntity != null) {
                return responseEntity;
            }
            responseEntity = new ResponseEntity();

            lstVehiculoBean = getVehiculosBeanFromVehiculos(vehiculoService.listarPorAno(ano));
            responseEntity.setData(lstVehiculoBean);
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
            responseEntity.setRespuestaHttp(entryResponse);
        } catch (Exception e) {
            responseEntity = new ResponseEntity();
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_500);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity insertar(@RequestHeader("Authorization") String auth, @RequestBody VehiculoBean vehiculoBean) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;
        Vehiculo vehiculo = null;

        try {
            responseEntity = validarUsuario(auth);
            if (responseEntity != null) {
                return responseEntity;
            }
            responseEntity = new ResponseEntity();
            vehiculo = getVehiculoFromVehiculoBean(vehiculoBean);

            if (vehiculoService.existePlaca(vehiculo)) {
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_0102);
                responseEntity.setRespuestaHttp(entryResponse);
            } else if (!ValidadorVehiculo.formatoPlacaValido(vehiculo.getPlaca())) {
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_0101);
                responseEntity.setRespuestaHttp(entryResponse);
            } else {
                boolean transaccionOK = vehiculoService.insertar(vehiculo);

                if (transaccionOK) {
                    entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
                    responseEntity.setRespuestaHttp(entryResponse);
                } else {
                    entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_5050);
                    responseEntity.setRespuestaHttp(entryResponse);
                }
            }
        } catch (Exception e) {
            responseEntity = new ResponseEntity();
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_500);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity actualizar(@RequestHeader("Authorization") String auth, @RequestBody VehiculoBean vehiculoBean) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;
        Vehiculo vehiculo = null;

        try {
            responseEntity = validarUsuario(auth);
            if (responseEntity != null) {
                return responseEntity;
            }
            responseEntity = new ResponseEntity();
            vehiculo = getVehiculoFromVehiculoBean(vehiculoBean);

            if (vehiculoService.existePlaca(vehiculo)) {
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_0102);
                responseEntity.setRespuestaHttp(entryResponse);
            } else if (!ValidadorVehiculo.formatoPlacaValido(vehiculo.getPlaca())) {
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_0101);
                responseEntity.setRespuestaHttp(entryResponse);
            } else {
                boolean transaccionOK = vehiculoService.actualizar(vehiculo);

                if (transaccionOK) {
                    entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
                    responseEntity.setRespuestaHttp(entryResponse);
                } else {
                    entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_5051);
                    responseEntity.setRespuestaHttp(entryResponse);
                }
            }
        } catch (Exception e) {
            responseEntity = new ResponseEntity();
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_500);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity eliminar(@RequestHeader("Authorization") String auth, @RequestBody VehiculoBean vehiculoBean) {
        ResponseEntity responseEntity = null;
        Entry<String, String> entryResponse;
        Vehiculo vehiculo = null;

        try {
            responseEntity = validarUsuario(auth);
            if (responseEntity != null) {
                return responseEntity;
            }
            responseEntity = new ResponseEntity();
            vehiculo = getVehiculoFromVehiculoBean(vehiculoBean);

            boolean transaccionOK = vehiculoService.eliminar(vehiculo);

            if (transaccionOK) {
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
                responseEntity.setRespuestaHttp(entryResponse);
            } else {
                entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_5052);
                responseEntity.setRespuestaHttp(entryResponse);
            }
        } catch (Exception e) {
            responseEntity = new ResponseEntity();
            entryResponse = sidSingleton.getEntryRespuestaHttp(HTTP_COD_500);
            responseEntity.setRespuestaHttp(entryResponse);
        }

        return responseEntity;
    }

    private List<VehiculoBean> getVehiculosBeanFromVehiculos(List<Vehiculo> lstVehiculo) throws Exception {
        List<VehiculoBean> lstVehiculoBean = new ArrayList<VehiculoBean>();
        for (Vehiculo vehiculo : lstVehiculo) {
            VehiculoBean vehiculoBean = new VehiculoBean();
            BeanUtils.copyProperties(vehiculoBean, vehiculo);
            lstVehiculoBean.add(vehiculoBean);
        }
        return lstVehiculoBean;
    }

    private VehiculoBean getVehiculoBeanFromVehiculo(Vehiculo vehiculo) throws Exception {
        VehiculoBean vehiculoBean = new VehiculoBean();
        BeanUtils.copyProperties(vehiculoBean, vehiculo);

        return vehiculoBean;
    }

    private Vehiculo getVehiculoFromVehiculoBean(VehiculoBean vehiculoBean) throws Exception {
        Vehiculo vehiculo = new Vehiculo();
        BeanUtils.copyProperties(vehiculo, vehiculoBean);

        return vehiculo;
    }

}
