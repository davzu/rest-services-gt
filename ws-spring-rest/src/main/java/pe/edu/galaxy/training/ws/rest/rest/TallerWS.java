package pe.edu.galaxy.training.ws.rest.rest;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.galaxy.training.ws.rest.bean.TallerBean;
import pe.edu.galaxy.training.ws.rest.entity.Taller;
import pe.edu.galaxy.training.ws.rest.service.exception.ServiceException;
import pe.edu.galaxy.training.ws.rest.service.inf.TallerService;

@Controller
@RequestMapping("/tallerService/v1")
public class TallerWS {

	@Autowired
	private TallerService tallerService;

	public TallerWS() {
	}

	@RequestMapping(value = "/listar/{nombre}", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public  List<TallerBean> listar(@PathVariable("nombre") String nombre) {
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
	
	@RequestMapping(value = "/listarParam", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	@ResponseBody
	public  List<TallerBean> listarParam(@RequestParam("nombre") String nombre) {
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

	@RequestMapping(value = "/insertar", method = RequestMethod.POST, 
			consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	public @ResponseBody Object insertar(@RequestBody TallerBean tallerBean) {
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

	@RequestMapping(value = "/actualizar", method = RequestMethod.PUT, 
			consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	public @ResponseBody Object actualizar(@RequestBody TallerBean tallerBean) {
		Taller taller = new Taller();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(taller, tallerBean);
			sw = tallerService.update(taller);
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

	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE,  
			consumes = "application/json; charset=utf-8",
			produces = "application/json; charset=utf-8")
	public @ResponseBody Object eliminar(@RequestBody TallerBean tallerBean) {
		Taller taller = new Taller();
		boolean sw = false;
		try {
			BeanUtils.copyProperties(taller, tallerBean);
			sw = tallerService.delete(taller);
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

	public TallerService getTallerService() {
		return tallerService;
	}

	public void setTallerService(TallerService tallerService) {
		this.tallerService = tallerService;
	}

}
