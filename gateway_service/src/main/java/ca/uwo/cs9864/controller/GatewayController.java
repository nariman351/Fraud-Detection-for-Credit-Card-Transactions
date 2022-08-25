package ca.uwo.cs9864.controller;

import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.uwo.cs9864.service.GatewayLogic;

@RestController
@RequestMapping("/")
public class GatewayController {

	// Gateway logic attribute
	GatewayLogic businessLogic = new GatewayLogic();

	/* *********************
	 *  UI Exposed Endpoints
	 **********************/

	// Login user
	@GetMapping("/loginUser/{username},{password}")
	public ResponseEntity<String> loginUser(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password) {		

		Object result = this.businessLogic.loginUser(username, password);
		
		if ( (result != null) && (result instanceof Boolean) ) {
			
			// If the user has been successfully login
			if ((boolean) result) {
			
		        return new ResponseEntity<>(
		                "User Login Successful", 
		                HttpStatus.ACCEPTED);
			}
			// User login failed
			else if (!(boolean) result) {
				
		        return new ResponseEntity<>(
		                "User Login Failed", 
		                HttpStatus.FORBIDDEN);
			}
	
		}
		
		// Send generic error by default
        return new ResponseEntity<>(
                "Error! Contact System Developer", 
                HttpStatus.BAD_REQUEST);
	}
	
	// Logout user
	@GetMapping("/logoutUser/{username}")
	public ResponseEntity<String> logoutUser(@PathVariable(value = "username") String username) {		

		Object result = this.businessLogic.logoutUser(username);
		
		if ( (result != null) && (result instanceof Boolean) ) {
			
			// If the user has been successfully logged out
			if ((boolean) result) {
			
		        return new ResponseEntity<>(
		                "User logged out", 
		                HttpStatus.ACCEPTED);
			}
			// User login failed
			else if (!(boolean) result) {
				
		        return new ResponseEntity<>(
		                "User Logout Failed", 
		                HttpStatus.FORBIDDEN);
			}
	
		}
		
		// Send generic error by default
        return new ResponseEntity<>(
                "Error! Contact System Developer", 
                HttpStatus.BAD_REQUEST);
	}
	
	// Register a new user
	@PostMapping("/registerUser")
	public ResponseEntity<String> registerUser(@RequestBody String user) {
		
		Object result = this.businessLogic.registerUser(user);
		
		if (result instanceof Boolean) {
			
			// If the user has been successfully registered
			if ((boolean) result) {
				
		        return new ResponseEntity<>(
		                "User registration Successful", 
		                HttpStatus.ACCEPTED);
			}
			// If user registration failed
			else if (!(boolean) result) {
				
		        return new ResponseEntity<>(
		                "User registration failed. User may already exists in the system", 
		                HttpStatus.FORBIDDEN);
			}
		}
		 
		// Send generic error by default
        return new ResponseEntity<>(
                "Error! Contact System Developer", 
                HttpStatus.BAD_REQUEST);
	}
	
	// Process transaction
	@PostMapping("/processTransaction")
	public ResponseEntity<String> processTransaction(@RequestBody String tran) {
		
		String username = null;
		Object result = null;
		
		// Convert transaction string into JSON
		JSONTokener tokener = new JSONTokener(tran);
		JSONObject tranJSON = new JSONObject(tokener);
		
		// Check if the user is logged-in
		username = (String) tranJSON.get("username");
		
		// Transaction can only be processed if user is logged in
		if (this.userLoginStatus(username)) {
			
			result = this.businessLogic.processTransaction(tranJSON);
			
			if (result instanceof Boolean) {
				
				// Result is true
				if ((boolean) result) {
					
			        return new ResponseEntity<>(
			                "Transaction Successful", 
			                HttpStatus.ACCEPTED);
				}
				// If result is false
				else if (!(boolean) result) {
					
			        return new ResponseEntity<>(
			                "Transaction Rejected", 
			                HttpStatus.FORBIDDEN);
				}
			}
		}
		// If user is not logged in
		else if (!this.userLoginStatus(username)){
			
	        return new ResponseEntity<>(
	                "User \'" + username + "\' is not logged in", 
	                HttpStatus.UNAUTHORIZED);
		}
		
		// Send generic error by default
        return new ResponseEntity<>(
                "Error! Contact System Developer", 
                HttpStatus.BAD_REQUEST);
	}
	
	/* ******************
	 *  Unexposed Endpoints
	 ********************/
	
	// User login status 
	@GetMapping("/userLoginStatus/{username}")
	public boolean userLoginStatus(@PathVariable(value = "username") String username) {		

		Object result = this.businessLogic.userLoginStatus(username);
		
		if (result instanceof Boolean) {
			
			// Result is true
			if ((boolean) result) {
				
				return true;
			}
			// If result is false
			else if (!(boolean) result) {
				
		        return false;
			}
		}
		
		return false;
	}
}