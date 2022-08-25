package ca.uwo.cs9864.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.uwo.cs9864.entity.User;
import ca.uwo.cs9864.exceptions.ResourceNotFoundException;
import ca.uwo.cs9864.repository.UserRepository;
import ca.uwo.cs9864.service.UserLogic;

// Controller class for users
@RestController
@RequestMapping("/UserManager")
public class UserController {

	// Business Logic
	UserLogic userLogic = new UserLogic();

	// Repository
	@Autowired
	private UserRepository userRepository;
	

	/////////////
	// Endpoints
	/////////////
	
	// Search User
	@GetMapping("/searchUser/{username}")
	public User getUser(@PathVariable(value = "username") String username) {

		return this.userRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));
	}

	// Register a new user
	@PostMapping("/registerUser")
	public boolean addUser(@RequestBody User user) {

		// If the username already exists in the DB, don't add the user
		if (this.userRepository.existsById(user.getUsername())) {

			User existingUser = this.userRepository.findById(user.getUsername()).get();

			if (existingUser != null) {

				return false;
			}
		}
		else {
			
			// Inform Security Manager to register new user credentials
			if (this.userLogic.registerUserCredentials(user.getUsername(), user.getPassword())) {
				
				// Add user into user database
				this.userRepository.save(user);
			
				return true;
			}
		}
		
		return false;
	}

	// Update user
	@PutMapping("/updateUser/{username}")
	public boolean updateUser(@RequestBody User newUser, @PathVariable(value = "username") String username) {

		// Get the existing user
		User existingUser = this.userRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));
		
		// If user exists
		if (existingUser != null) {
			
			// Inform Security Manager to update user credentials, if provided
			this.userLogic.updateUserCredentials(newUser.getUsername(), newUser.getPassword());
			
			// Update user
			existingUser.setFirstName(newUser.getFirstName());
			existingUser.setLastName(newUser.getLastName());
			existingUser.setAddress(newUser.getAddress());
			existingUser.setCity(newUser.getCity());
			existingUser.setState(newUser.getState());
			existingUser.setCountry(newUser.getCountry());
			existingUser.setPostalCode(newUser.getPostalCode());
			existingUser.setPhoneNumber(newUser.getPhoneNumber());
			
			this.userRepository.save(existingUser);
		
			return true;
		}
		
		return false;
	}

	// Delete a user
	@DeleteMapping("/deleteUser/{username}")
	public boolean deleteUser(@PathVariable(value = "username") String username) {

		// Get the existing user
		User existingUser = this.userRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));
		
		// If user exists
		if (existingUser != null) {
			
			// Inform Security Manager to update user credentials, if provided
			this.userLogic.DeleteUserCredentials(username);
			
			// Delete user
			this.userRepository.delete(existingUser);
			
			return true;
		}
		
		return false;
	}

}
