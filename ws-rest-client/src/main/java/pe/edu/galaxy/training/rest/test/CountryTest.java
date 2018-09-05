package pe.edu.galaxy.training.rest.test;

import pe.edu.galaxy.training.rest.bean.Country;
import pe.edu.galaxy.training.rest.bean.Data;
import pe.edu.galaxy.training.rest.util.UtilREST;
import com.google.gson.Gson;

public class CountryTest {

	public static void main(String[] args) {

		String uri = "http://services.groupkt.com/country/get/all";

		Gson gson = new Gson();

		Data data = gson.fromJson(UtilREST.getREST(uri), Data.class);

		if (data != null) {
			System.out.println(data.getRestResponse().getMessages()[0]);
			for (Country country : data.getRestResponse().getResult()) {
				System.out.println(country);
			}
		}
	}

}
