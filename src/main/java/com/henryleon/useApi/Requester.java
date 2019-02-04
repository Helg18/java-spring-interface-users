package com.henryleon.useApi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class Requester {

	public static String getUsers() throws Exception {
	     String url = "http://localhost:8080/api/usuario";
	     
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     
	     // optional default is GET
	     con.setRequestMethod("GET");
	     
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     
	     return response.toString();

	   }
	
	public static String getUserByUsername(String request) throws IOException {


		String url = "http://localhost:8080/api/usuario/username";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Content-Type", "application/json");

		String urlParameters = request; 
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

		return "Request terminado";
    }
	
	public static String createUser(String[] request) throws IOException {
		
		JSONObject urlParameters =new JSONObject();
		urlParameters.put("nombres",       request[1]);
		urlParameters.put("apellidos",     request[2]);
		urlParameters.put("email",         request[3]);
		urlParameters.put("telefono",      request[4]);
		urlParameters.put("username",      request[5]);
		urlParameters.put("password",      request[6]);
		urlParameters.put("fechaCreacion", request[7]);
		urlParameters.put("activo",        Boolean.parseBoolean(request[8]));
		urlParameters.put("rolId",         request[9]);
		
		System.out.println(urlParameters.toString());

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, urlParameters.toString());
		Request builder = new Request.Builder()
		  .url("http://localhost:8080/api/usuario")
		  .post(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .build();

		Response response = client.newCall(builder).execute();
		
		System.out.println(response);
		return "Request terminado";
	}

	public static String updateUser(String[] request) throws IOException {

		JSONObject urlParameters =new JSONObject();
		urlParameters.put("id",            request[1]);
		urlParameters.put("nombres",       request[2]);
		urlParameters.put("apellidos",     request[3]);
		urlParameters.put("email",         request[4]);
		urlParameters.put("telefono",      request[5]);
		urlParameters.put("username",      request[6]);
		urlParameters.put("password",      request[7]);
		urlParameters.put("fechaCreacion", request[8]);
		urlParameters.put("activo",        Boolean.parseBoolean(request[9]));
		urlParameters.put("rolId",         request[10]);
		
		System.out.println(urlParameters.toString());

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, urlParameters.toString());
		Request queryBuilder = new Request.Builder()
		  .url("http://localhost:8080/api/usuario")
		  .put(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .build();

		Response response = client.newCall(queryBuilder).execute();
		
		System.out.println(response);
		return "Request terminado";
	}

	public static String deleteUser(String[] request) throws IOException {

		JSONObject urlParameters =new JSONObject();
		urlParameters.put("id", request[1]);

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, urlParameters.toString());
		Request queryBuilder = new Request.Builder()
		  .url("http://localhost:8080/api/usuario")
		  .delete(body)
		  .addHeader("content-type", "application/json")
		  .addHeader("cache-control", "no-cache")
		  .build();

		Response response = client.newCall(queryBuilder).execute();
		
		System.out.println(response.toString());
		return "Request terminado";
	}

	public static String getUsersByDate() throws IOException {
		String url = "http://localhost:8080/api/usuarios/orderdate";
		URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     
	     // optional default is GET
	     con.setRequestMethod("GET");
	     
	     //add request header
	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     
	     System.out.println(response.toString());

		return "Request terminado";
	}

}


