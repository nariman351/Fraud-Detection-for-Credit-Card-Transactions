package ca.uwo.cs9864.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_credentials")
public class UserCredential {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private boolean status;
	
	
	// Default constructor to avoid hibernate error
	public UserCredential() {
		
	}
	
	// Parameterized constructor
	public UserCredential(String username, String password, boolean status) {
		super();
		
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
