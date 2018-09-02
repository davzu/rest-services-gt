package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import pe.edu.galaxy.training.ws.rest.bean.TallerBean;
import pe.edu.galaxy.training.ws.rest.entity.Taller;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.TallerService;

@Path("/tallerService/v1")
public class TallerWS extends SpringBeanAutowiringSupport {

	@Autowired
	private TallerService tallerService;

	public TallerWS() {
	}

	@GET
	@Path("/listar/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TallerBean> listar(@PathParam("nombre") String nombre) {
		List<TallerBean> lst = new ArrayList<>();
		TallerBean tallerBean;
		System.out.println("param nombre ::: " + nombre);

		try {
			Taller taller = new Taller();
			taller.setNombre(nombre);
			List<Taller> lstE = this.tallerService.findByLikeObject(taller);

			for (Taller oTaller : lstE) {
				tallerBean = new TallerBean();
				BeanUtils.copyProperties(tallerBean, oTaller);
				lst.add(tallerBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lst;
	}

	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertar(TallerBean tallerBean) {
		Taller taller = new Taller();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(taller, tallerBean);
			sw = tallerService.insert(taller);

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret = (sw) ? "\"Exito\"" : "\"Error\"";
		String restultdo = "{\"retultado\":" + ret + "}";
		System.out.println(restultdo);
		return restultdo;
	}
	
	@PUT
	@Path("/actualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object actualizar(TallerBean tallerBean) {
		Taller taller = new Taller();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(taller, tallerBean);
			sw = tallerService.update(taller);
		}catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret = (sw) ? "\"Exito\"" : "\"Error\"";
		String restultdo = "{\"retultado\":" + ret + "}";
		System.out.println(restultdo);
		return restultdo;
	}
	
	@DELETE
	@Path("/eliminar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Object eliminar(TallerBean tallerBean) {
		Taller taller = new Taller();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(taller, tallerBean);
			sw = tallerService.delete(taller);
		}catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ret = (sw) ? "\"Exito\"" : "\"Error\"";
		String restultdo = "{\"retultado\":" + ret + "}";
		System.out.println(restultdo);
		return restultdo;
	}

	public TallerService getTallerService() {
		return tallerService;
	}

	public void setTallerService(TallerService tallerService) {
		this.tallerService = tallerService;
	}

}
