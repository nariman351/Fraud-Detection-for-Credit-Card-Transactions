package ca.uwo.cs9864.service;

import java.util.ArrayList;

// Business Logic - Security
public class SecurityLogic {

	// Login List
	ArrayList<String> authenticatedUsers = new ArrayList<String>();
	
	// Constructor
	public SecurityLogic() {
		
	}
	
	// Method: Login user
	public void login(String username) {
		
		this.authenticatedUsers.add(username);
	}
	
	// Method: Logout user
	public void logout(String username) {
		
		this.authenticatedUsers.remove(username);
	}
	
	// Method: Check if user is logged in
	public boolean isUserLoggedIn(String username) {
		
		if (this.authenticatedUsers.contains(username)) {
			
			return true;
		}
		
		return false;
	}
}
