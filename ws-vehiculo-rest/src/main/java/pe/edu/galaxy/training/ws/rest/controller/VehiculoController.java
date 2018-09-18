package pe.edu.galaxy.training.ws.rest.controller;

import java.util.List;
import java.util.Map.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.galaxy.training.ws.rest.bean.ResponseEntity;
import pe.edu.galaxy.training.ws.rest.entity.Usuario;
import pe.edu.galaxy.training.ws.rest.entity.Vehiculo;
import pe.edu.galaxy.training.ws.rest.service.inf.UsuarioService;
import pe.edu.galaxy.training.ws.rest.service.inf.VehiculoService;
import static pe.edu.galaxy.training.ws.rest.sid.CodigosHttpConstantes.*;
import pe.edu.galaxy.training.ws.rest.sid.SidSingleton;

@RequestMapping("/vehiculoService/v1")
@Controller
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private SidSingleton sidSingleton;

    @RequestMapping(value = "/listarPorPlaca/{placa}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    ResponseEntity listarPorPlaca(@PathVariable("placa") String placa) {
        Usuario usuario = new Usuario();
        usuario.setId("cgomez");
        usuario.setClave("1234ABCD");
        boolean usuarioValido = usuarioService.credencialesValida(usuario);
        System.out.println("*****DZ usuarioValido ::: " + usuarioValido);

        ResponseEntity responseEntity = new ResponseEntity();
        Entry<String, String> entry = sidSingleton.getEntryRespuestaHttp(HTTP_COD_200);
        responseEntity.setRespuestaHttp(entry);
        responseEntity.setData(vehiculoService.listarPorPlaca(placa));

        return responseEntity;
    }

    @RequestMapping(value = "/listarPorAno", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public @ResponseBody
    List<Vehiculo> listarPorAno(@RequestParam("ano") int ano) {
        return vehiculoService.listarPorAno(ano);
    }

    @RequestMapping(value = "/insertar", method = RequestMethod.POST, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    boolean insertar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.insertar(vehiculo);
    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.PUT, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    boolean actualizar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.actualizar(vehiculo);
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8", consumes = "application/json; charset=utf-8")
    public @ResponseBody
    boolean eliminar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.eliminar(vehiculo);
    }

}
