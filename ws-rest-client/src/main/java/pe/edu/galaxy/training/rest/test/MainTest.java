package pe.edu.galaxy.training.rest.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import pe.edu.galaxy.training.rest.bean.Post;
import pe.edu.galaxy.training.rest.util.UtilREST;

import com.google.gson.Gson;

public class MainTest {

	public static void main(String[] args) {
		
		String uri="https://jsonplaceholder.typicode.com/posts";
		/*
		try {
			
			URL url = new URL(uri);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.connect();
			
			int responseCode = connection.getResponseCode();
			
			if(responseCode == 200){
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				String ret=response.toString();
				
				System.out.println("data "+ret);
			
				Gson gson= new Gson();
				
				Post[] posts= gson.fromJson(ret, Post[].class);
				
				if (posts!=null) {
					
					for (Post post : posts) {
						System.out.println(post);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}*/
		
		Gson gson= new Gson();
		
		Post[] posts= gson.fromJson(UtilREST.getREST(uri), Post[].class);
		
		if (posts!=null) {
			
			for (Post post : posts) {
				System.out.println(post);
			}
		}

	}

}
