package ca.uwo.cs9864.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.json.JSONTokener;

// Gateway Business Logic class
public class GatewayLogic {

	// Constructor
	public GatewayLogic() {

	}

	// Method: Authentication user and send login result back
	// Successful: true
	// Unsuccessful: false
	public Object loginUser(String username, String password) {

		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5001/SecurityManager/authenticateUser/" + username + "," + password);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

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
		
		// Default result
		return null;
	}
	
	// Method: Logout User
	// Successful: true
	// Unsuccessful: false
	public Object logoutUser(String username) {

		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5001/SecurityManager/logoutUser/" + username);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			// Reading response
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			in.close();
			con.disconnect();
			
			if (Boolean.valueOf(content.toString()) instanceof Boolean) {
				
				// returning response
				return Boolean.valueOf(content.toString());
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		// Default result
		return null;
	}
	
	// Method: Return user login status
	// Logged in: true
	// Logged out: false
	public Object userLoginStatus(String username) {

		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5001/SecurityManager/userLoginStatus/" + username);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			// Reading response
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			
			in.close();
			con.disconnect();
			
			if (Boolean.valueOf(content.toString()) instanceof Boolean) {
				
				// returning response
				return Boolean.valueOf(content.toString());
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		// Default result
		return null;
	}

	// Method: Register a  user
	// successful: true
	// unsuccessful: false
	public Object registerUser(String user) {
		
		// Convert user info into json
		JSONTokener tokener = new JSONTokener(user);
		JSONObject json = new JSONObject(tokener);
		
		// HTTP Operation related variables
		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5003/UserManager/registerUser");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = json.toString().getBytes("utf-8");
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

	// Method: Process Transaction
	// successful: true
	// unsuccessful: false
	public Object processTransaction(JSONObject tranJSON) {
		
		// HTTP Operation related variables
		URL url;
		HttpURLConnection con = null;
		BufferedReader in;
		String inputLine;
		StringBuffer content = new StringBuffer();
		
		try {

			// Sending request
			url = new URL("http://ec2-35-182-145-79.ca-central-1.compute.amazonaws.com:5002/TransactionManager/processTransaction");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			
			try(OutputStream os = con.getOutputStream()) {
			    byte[] input = tranJSON.toString().getBytes("utf-8");
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
}
