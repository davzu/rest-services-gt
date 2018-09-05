package pe.edu.galaxy.training.rest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import sun.misc.BASE64Encoder;

public class UtilREST {

	public static String getREST(String uri){
				
		try {
			URL url = new URL(uri);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.connect();
			
			return reader(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String getREST(String uri,String user, String psw){
		
		try {
			URL url = new URL(uri);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			String aut=user+":"+psw;
			String autEnc = new BASE64Encoder().encode(aut.getBytes());
			System.out.println(aut);
			
			connection.setRequestProperty("Authorization", "Basic "+autEnc);

			connection.connect();
			
			return reader(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private static String reader(HttpURLConnection connection) throws Exception{
		int responseCode = connection.getResponseCode();
		
		if(responseCode == 200){
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			return response.toString();
		}
		return null;
	}
	
	public static String postREST(String uri,String rest) throws IOException {

		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
	
		OutputStream os = connection.getOutputStream();
		
		os.write(rest.getBytes());
		os.flush();

		if (connection.getResponseCode() != 200) {
			throw new RuntimeException("Error : HTTP error code : "	+ connection.getResponseCode() 
					+ " "+ connection.getResponseMessage());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

		StringBuffer sb=new StringBuffer("");
	    String data="";
		while ((data = br.readLine()) != null) {
			sb.append(data);
		}
		connection.disconnect();
			
		return sb.toString();
	}
	
	
}
