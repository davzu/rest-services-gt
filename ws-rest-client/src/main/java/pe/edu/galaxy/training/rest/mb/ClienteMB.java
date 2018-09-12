package pe.edu.galaxy.training.rest.mb;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import pe.edu.galaxy.training.rest.bean.ClienteBean;
import pe.edu.galaxy.training.rest.util.UtilREST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@ManagedBean(name = "clienteMB")
public class ClienteMB {

	String uriInsertar = "http://localhost:8085/WSSpringREST/clienteService/v1/insertar";

	private ClienteBean cliente;

	@PostConstruct
	public void init() {
		cliente = new ClienteBean();
	}

	// public void listar() {
	// try {
	// Gson gson = new Gson();
	// posts = gson.fromJson(UtilREST.getREST(uri), Post[].class);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// }

	public void insertar() {
		Gson gson = new Gson();
		String strRequest = gson.toJson(cliente);
		System.out.println(strRequest);
		String response;
		
		try {
			response = UtilREST.postREST(uriInsertar, strRequest);
			System.out.println(response);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ClienteBean getCliente() {
		return cliente;
	}

	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

}
