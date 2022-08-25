package ca.uwo.cs9864.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

// User Logic class
public class UserLogic {

	// Construction
	public UserLogic() {
		
	}
	
	
	// Method: Register new user credentials with Security Manager
	public boolean registerUserCredentials(String username, String password) {
		
		String url = "http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5001/SecurityManager/addUserCredential";
		String httpMethod = "POST";
		Boolean result;
		
		// Create JSON 
		JSONObject customJSON = new JSONObject();
		customJSON.put("username", username);
		customJSON.put("password", password);
		
		// Initially, user would be granted access
		// to the system (Innocent until proven guilty)
		customJSON.put("status", true);
		
		// Register user
		result = (boolean) this.httpRequest(url, customJSON, httpMethod);
		
		if (result instanceof Boolean) {
			
			return result;
		}
		
		return false;
	}

	// Method: Update user credentials with Security Manager
	public boolean updateUserCredentials(String username, String password) {

		String url;
		String httpMethod = "PUT";
		Boolean result;
		
		// If username and password are not empty
		if (username != "" && password != "") {
			
			url = "http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5001/SecurityManager/updateUserPassword/" + username;
			
			// Create JSON 
			JSONObject customJSON = new JSONObject();
			customJSON.put("username", username);
			customJSON.put("password", password);
			
			// access to the system (Innocent until proven guilty)
			customJSON.put("status", true);
			
			// Register user
			result = (boolean) this.httpRequest(url, customJSON, httpMethod);
			
			if (result instanceof Boolean) {
				
				return result;
			}
		}
		
		return false;
	}

	// Method: Delete user credentials with Security Manager
	public boolean DeleteUserCredentials(String username) {
		
		String url = "http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5001/SecurityManager/deleteUserCredential/" + username;
		String httpMethod = "DELETE";
		Boolean result = false;
		
		// Delete user credential
		if (username != "") {
			
			result = (boolean) this.httpRequest(url, username, httpMethod);
		}
		
		if (result instanceof Boolean) {
			
			return result;
		}
		
		return false;
	}
	
	// Method: HTTP handler
	private Object httpRequest(String epURL, JSONObject customJSON, String httpMethod) {
	
		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL(epURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(httpMethod);
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = customJSON.toString().getBytes("utf-8");
			    os.write(input, 0, input.length);			
			}
			

			// Reading response
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			// Disconnect connections and buffer readers
			in.close();
			con.disconnect();
		
			// Verify the expected response type
			if (Boolean.valueOf(content.toString()) instanceof Boolean) {
				
				// returning response
				return Boolean.valueOf(content.toString());
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return null; 
	}
	
	// Overloaded Method: HTTP handler
	private Object httpRequest(String epURL, String username, String httpMethod) {
	
		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL(epURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod(httpMethod);

			// Reading response
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			// Disconnect connections and buffer readers
			in.close();
			con.disconnect();
		
			// Verify the expected response type
			if (Boolean.valueOf(content.toString()) instanceof Boolean) {
				
				// returning response
				return Boolean.valueOf(content.toString());
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return null; 
	}

}
