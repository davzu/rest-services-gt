package pe.edu.galaxy.training.rest.test;

import java.io.IOException;

import com.google.gson.Gson;

import pe.edu.galaxy.training.rest.bean.ClienteBean;
import pe.edu.galaxy.training.rest.util.UtilREST;

public class ClientePOSTTest {

	public static void main(String[] args) throws IOException {
		
		String uriInsertar = "http://localhost:8081/WSSpringRESTDemoFinal/clienteService/v1/insertar";
		
		String json ="{\"razonSocial\":\"empresa 06\",\"direccion\":\"direccion 06\",\"ruc\":\"22222222222\"}";
		
		ClienteBean cliente = new ClienteBean();
		cliente.setRazonSocial("empresa 14");
		cliente.setRuc("14");
		cliente.setDireccion("direccion 14");
		
		Gson gson = new Gson();
		String strRequest = gson.toJson(cliente);
		System.out.println(strRequest);
		
		String response = UtilREST.postREST(uriInsertar, strRequest);
		
		System.out.println(response);
		
		
		

	}

}
