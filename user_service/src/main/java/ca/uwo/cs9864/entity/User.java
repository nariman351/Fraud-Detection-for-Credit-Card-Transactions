package ca.uwo.cs9864.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class User {

	// Class Attributes
	
	// Send password to Security Manager 
	// Don't save it in users database
	@Transient
	private String password;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String 	lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	// Default constructor to avoid hibernate error
	public User() {
		
	}
	
	// Parameterized constructor
	public User(String username, String password, String firstName, String lastName, 
			String address, String city, String state, String country, String postalCode, String phoneNumber) {
		
		super();
		
		// Assign attributes
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		
	}

	/////////////////////////
	//	Getters and Setters
	/////////////////////////
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}

//@Column(name = "")
	//private String 
	
	
	/* Information required at the time of registration */
	
	// Username
	// Password

	// First Name
	// Last Name
	// Address
	// City
	// State/Province
	// Country
	// Postal Code/Zip code
	// Phone number 
