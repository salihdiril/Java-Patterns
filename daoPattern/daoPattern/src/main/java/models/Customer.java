package models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("id")
	private int customerId;
	private String email;
	@JsonProperty("first")
	private String firstName;
	@JsonProperty("last")
	private String lastName;
	private String company;
	@JsonProperty("created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
	private Date createdAt;
	private String country;

	public Customer() {
	}

	public Customer(int customerId, String email, String firstName, String lastName, String company, Date createdAt, String country) {
		this.customerId = customerId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.company = company;
		this.createdAt = createdAt;
		this.country = country;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer{" + "customerId=" + customerId + ", email='" + email + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", company='" + company + '\'' + ", createdAt=" + createdAt + ", country='" + country + '\'' + '}';
	}
}
