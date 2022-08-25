package ca.uwo.cs9864.controller;

import java.util.List;

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

import ca.uwo.cs9864.entity.UserCredential;
import ca.uwo.cs9864.exceptions.ResourceNotFoundException;
import ca.uwo.cs9864.repository.UserCredentialsRepository;
import ca.uwo.cs9864.service.SecurityLogic;

@RestController
@RequestMapping("/SecurityManager")
public class SecurityController {

	// Security Logic attribute
	SecurityLogic businessLogic = new SecurityLogic();
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	// Display all security credentials (Am I serious? :P)
	@GetMapping("/secret")
	public List<UserCredential> getAllCredentials() {

		return this.userCredentialsRepository.findAll();
	}

	// Display a security credentials
	@GetMapping("/secret/{username}")
	public UserCredential getUserCredential(@PathVariable(value = "username") String username) {

		return this.userCredentialsRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));
	}

	// Get user access status 
	@GetMapping("/userBanStatus/{username}")
	public boolean userBanStatus(@PathVariable(value = "username") String username) {

		UserCredential existingUser = this.userCredentialsRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));
		
		return existingUser.getStatus();
	}

	// Add user authentication credentials
	@PostMapping("/addUserCredential")
	public boolean addUserCredential(@RequestBody UserCredential userCredential) {

		// If the user name already exists in the DB, return false
		if (this.userCredentialsRepository.existsById(userCredential.getUsername())) {

			UserCredential existingUser = this.userCredentialsRepository.findById(userCredential.getUsername()).get();

			if (existingUser != null) {

				return false;
			}
		}
		
			
		// Otherwise, add the credentials in DB
		this.userCredentialsRepository.save(userCredential);

		return true;
	}

	// Update user password
	@PutMapping("/updateUserPassword/{username}")
	public boolean updateUserPassword(@RequestBody UserCredential newUserCredential,
			@PathVariable(value = "username") String username) {

		UserCredential existingUser = this.userCredentialsRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));

		if (existingUser != null) {
			
			existingUser.setPassword(newUserCredential.getPassword());
			this.userCredentialsRepository.save(existingUser);
			
			return true;
		}

		return false;
	}

	// Update user access status
	@PutMapping("/updateBanStatus/{username}")
	public UserCredential updateBanStatus(@RequestBody UserCredential newUserCredential,
			@PathVariable(value = "username") String username) {

		UserCredential existingUser = this.userCredentialsRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));

		existingUser.setStatus(newUserCredential.getStatus());

		return this.userCredentialsRepository.save(existingUser);
	}

	// Delete user credentials
	@DeleteMapping("/deleteUserCredential/{username}")
	public boolean deleteUserCredential(@PathVariable(value = "username") String username) {

		// Get the user from the database
		UserCredential existingUser = this.userCredentialsRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));

		if (existingUser != null) {
			
			this.userCredentialsRepository.delete(existingUser);
			return true;
		}
		
		return false;
	}

	// Authenticate User
	@GetMapping("/authenticateUser/{username},{password}")
	public boolean authenticateUser(@PathVariable(value = "username") String username,
			@PathVariable(value = "password") String password) {

		// Get the user from the database
		UserCredential existingUser = this.userCredentialsRepository.findById(username)
				.orElseThrow(() -> new ResourceNotFoundException("Username: " + username + " not found!"));

		// If password is matched and user is not banned, return true
		if ((existingUser.getPassword().equals(password)) && (existingUser.getStatus() == true)) {

			// Login the user
			this.businessLogic.login(username);
			
			return true;
		}

		return false;
	}
	
	// Method: Return user login status
	@GetMapping("/userLoginStatus/{username}")
	public boolean userLoginStatus(@PathVariable(value = "username") String username) {
		
		if (this.businessLogic.isUserLoggedIn(username)) {
			
			return true;
		}
		
		return false;
	}
	
	// Logout user
	@GetMapping("/logoutUser/{username}")
	public boolean logoutUser(@PathVariable(value = "username") String username) {
		
		if (this.businessLogic.isUserLoggedIn(username)) {
			
			this.businessLogic.logout(username);
			
			return true;
		}
		
		return false;
	}

}
