package ca.uwo.cs9864.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

// Class: Handles all REST calls to other services
public class HTTPHandler {

	// Data Layer Manager Endpoint
	private String dataLayerManagerURL;
	
	// User manager
	private String userManagerURL;

	// Constructor
	public HTTPHandler() {
		
		// Endpoint: Data Layer Manager 
		this.setDataLayerManagerURL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5004/DataLayerManager/ProcessAnalytics");
		
		// Endpoint: User Layer Manager
		this.setUserManagerURL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5003/UserManager/searchUser/");
	}
	
	
	// Method: HTTP Send
	public Object httpSendRequest(JSONObject customJSON, String httpMethod) {
	
		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL(this.getDataLayerManagerURL());
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
		
			// Verify the expected response type - Boolean (returned by Diya)
			if (Boolean.valueOf(content.toString()) instanceof Boolean) {
				
				// returning response
				return Boolean.valueOf(content.toString());
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return null; 
	}
	
	// Method: HTTP GET Request
	public Object httpGETRequest(String username, String httpMethod) {
		
		String endpoint = this.getUserManagerURL() + username;
		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL(endpoint);
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
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		JSONObject rcvdJSON = null;
		
		// Convert received result into JSON
		if (content != null) {
			
			//System.out.println(content);
			//System.out.println(content.toString());
			
			JSONTokener tokener = new JSONTokener(content.toString());
			rcvdJSON = new JSONObject(tokener);
		}
		
		return rcvdJSON;
	}
	
	
	/////////////////////////
	//	Getters and Setters
	/////////////////////////
	
	private String getDataLayerManagerURL() {
		return dataLayerManagerURL;
	}


	private void setDataLayerManagerURL(String epURL) {
		this.dataLayerManagerURL = epURL;
	}
	
	private String getUserManagerURL() {
		return userManagerURL;
	}


	private void setUserManagerURL(String userManagerURL) {
		this.userManagerURL = userManagerURL;
	}
	
}
