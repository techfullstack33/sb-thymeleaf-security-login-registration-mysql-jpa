package com.techfs.sb.web.dto;

public class EmployeeRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String country;
	private String password;
	

	public EmployeeRegistrationDto() {
			
	}
	
	public EmployeeRegistrationDto(String firstName, String lastName, String email, String country, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.password = password;
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

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmployeeRegistrationDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", country=" + country + ", password=" + password + "]";
	}

	
	
	
	
	
}
