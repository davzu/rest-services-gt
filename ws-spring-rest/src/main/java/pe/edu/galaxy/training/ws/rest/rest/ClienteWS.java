package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.persistence.internal.libraries.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.bean.CodigoException;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.ClienteService;
import pe.edu.galaxy.training.ws.rest.util.Authorization;
import pe.edu.galaxy.training.ws.rest.util.RucValidator;

@Controller
// @Path(/clienteService/v1)
@RequestMapping("/clienteService/v1")
public class ClienteWS {

	@Autowired
	private ClienteService clienteService;

	public ClienteWS() {

	}

	/*
	 * @GET
	 * 
	 * @Path("/listar")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */

	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<ClienteBean> listar() {
		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		Cliente cliente = new Cliente();
		try {
			List<Cliente> lstCliente = this.getClienteService()
					.findByLikeObject(cliente);
			lstClienteBean = this.getClientesBean(lstCliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstClienteBean;
	}

	@RequestMapping(value = "/listarAuth", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object listarAuth(@RequestHeader("Authorization") String auth) {
		String[] ret = Authorization.validarAutorizacion(auth);
		String usuario = ret[0];
		String clave = ret[1];

		if (!(ret[0].equals("Admin") && ret[1].equals("123456"))) {
			String restultdo = "{\"retultado\":\"Acceso no autorizado\"}";
			return restultdo;
		}

		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		Cliente cliente = new Cliente();
		try {
			List<Cliente> lstCliente = this.getClienteService()
					.findByLikeObject(cliente);
			lstClienteBean = this.getClientesBean(lstCliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstClienteBean;
	}

	/*
	 * @GET
	 * 
	 * @Path("/listar/{rz}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/listar/{rz}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody List<ClienteBean> listarPathParam(
			@PathVariable("rz") String rz) {
		System.out.println("/listar/{rz} " + rz);
		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		/*
		 * System.out.println("rz : "+rz); try { List<Cliente>
		 * lstCliente=this.getClienteService().findByLikeRZ(rz);
		 * lstClienteBean=this.getClientesBean(lstCliente); } catch
		 * (ServiceException e) { e.printStackTrace(); }
		 */
		return lstClienteBean;
	}

	/*
	 * @GET
	 * 
	 * @Path("/listarParam")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/listarParam", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody List<ClienteBean> listarParam(
			@RequestParam("rz") String rz) {
		System.out.println("listarParam " + rz);
		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		/*
		 * System.out.println("rzlistarParam : "+rz); try { List<Cliente>
		 * lstCliente=this.getClienteService().findByLikeRZ(rz);
		 * lstClienteBean=this.getClientesBean(lstCliente); } catch
		 * (ServiceException e) { e.printStackTrace(); }
		 */
		return lstClienteBean;
	}

	/*
	 * @POST
	 * 
	 * @Path("/insertar")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/insertar", method = RequestMethod.POST, consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
	public @ResponseBody Object insertar(@RequestBody ClienteBean clienteBean) {
		Cliente cliente = new Cliente();
		boolean sw = false;

		// validar RUC
		if (!RucValidator.validar(clienteBean.getRuc())) {
			return new CodigoException("cus.code.0101");
		}

		try {
			BeanUtils.copyProperties(cliente, clienteBean);

			// validar raz�n social existente
			if (!clienteService.validarRuc(cliente)) {
				return new CodigoException("cus.code.0102");
			}

			// validar raz�n social existente
			if (!clienteService.validarRazonSocial(cliente)) {
				return new CodigoException("cus.code.0103");
			}

			sw = this.getClienteService().insert(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (sw) {
			return new CodigoException("cus.code.0200");
		} else {
			return new CodigoException("http.code.5050");
		}

	}

	/*
	 * @PUT
	 * 
	 * @Path("/actualizar")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
	public @ResponseBody Object actualizar(@RequestBody ClienteBean clienteBean) {
		Cliente cliente = new Cliente();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(cliente, clienteBean);

			// validar raz�n social existente
			if (!clienteService.validarRuc(cliente)) {
				return new CodigoException("cus.code.0102");
			}

			// validar raz�n social existente
			if (!clienteService.validarRazonSocial(cliente)) {
				return new CodigoException("cus.code.0103");
			}

			sw = this.getClienteService().update(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (sw) {
			return new CodigoException("cus.code.0200");
		} else {
			return new CodigoException("http.code.5051");
		}
	}

	/*
	 * @DELETE
	 * 
	 * @Path("/eliminar")
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON)
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 */
	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE, consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
	public @ResponseBody Object eliminar(@RequestBody ClienteBean clienteBean) {
		Cliente cliente = new Cliente();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			sw = this.getClienteService().delete(cliente);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret = (sw) ? "\"Exito\"" : "\"Error\"";
		String restultdo = "{\"retultado\":" + ret + "}";
		return restultdo;
	}

	private List<ClienteBean> getClientesBean(List<Cliente> lstCliente) {

		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		for (Cliente oCliente : lstCliente) {
			ClienteBean clienteBean = new ClienteBean();
			try {
				BeanUtils.copyProperties(clienteBean, oCliente);
				lstClienteBean.add(clienteBean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lstClienteBean;
	}

	public ClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
}
