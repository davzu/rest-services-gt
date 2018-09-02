package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.edu.galaxy.training.ws.rest.bean.ClienteBean;
import pe.edu.galaxy.training.ws.rest.entity.Cliente;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.ClienteService;

@Path("/clienteService/v1")
public class ClienteWS  extends SpringBeanAutowiringSupport {

   @Autowired
   private ClienteService clienteService;
	
	public ClienteWS() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteBean> listar() {
		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		Cliente cliente=new Cliente();
		try {
			List<Cliente> lstCliente=this.getClienteService().findByLikeObject(cliente);
			lstClienteBean=this.getClientesBean(lstCliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstClienteBean;
	}
	
	@GET
	@Path("/listar/{rz}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteBean> listarPathParam(@PathParam("rz") String rz) {
		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		System.out.println("rz : "+rz);
		try {
			List<Cliente> lstCliente=this.getClienteService().findByLikeRZ(rz);
			lstClienteBean=this.getClientesBean(lstCliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstClienteBean;
	}
	@GET
	@Path("/listarParam")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteBean> listarParam(@QueryParam("rz") String rz) {
		List<ClienteBean> lstClienteBean = new ArrayList<ClienteBean>();
		System.out.println("rzlistarParam : "+rz);
		try {
			List<Cliente> lstCliente=this.getClienteService().findByLikeRZ(rz);
			lstClienteBean=this.getClientesBean(lstCliente);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return lstClienteBean;
	}
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertar(ClienteBean clienteBean) {
		Cliente cliente = new Cliente();
		boolean sw=false;
		try {
			BeanUtils.copyProperties(cliente, clienteBean);
			sw=this.getClienteService().insert(cliente);
		
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret=(sw)?"\"Exito\"":"\"Error\"";
		String restultdo="{\"retultado\":"+ret+"}";
		System.out.println(restultdo);
		return restultdo;
	}
	
	private List<ClienteBean> getClientesBean(List<Cliente> lstCliente){
		
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
