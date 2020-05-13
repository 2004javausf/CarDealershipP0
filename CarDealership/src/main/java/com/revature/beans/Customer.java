package com.revature.beans;

public class Customer {

	private int customer_id;

	private String username;

	private String firstname;

	private String lastname;

	private String email;

	private String address;

	private double cash_on_hand;

	private String city;

	private int credit_score;

	private String password;

	private String phone_number;

	private String postal_code;

	private String state;

	public Customer() {
		super();
	}

	

	public Customer(int customer_id, String username, String password, String firstname, String lastname, String email, String address, String city, String state, String postal_code, int credit_score, double cash_on_hand, String phone_number
			) {
		super();
		this.customer_id = customer_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.cash_on_hand = cash_on_hand;
		this.city = city;
		this.credit_score = credit_score;
		this.password = password;
		this.phone_number = phone_number;
		this.postal_code = postal_code;
		this.state = state;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getCash_on_hand() {
		return cash_on_hand;
	}

	public void setCash_on_hand(double cash_on_hand) {
		this.cash_on_hand = cash_on_hand;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCredit_score() {
		return credit_score;
	}

	public void setCredit_score(int credit_score) {
		this.credit_score = credit_score;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", username=" + username + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", address=" + address + ", cash_on_hand="
				+ cash_on_hand + ", city=" + city + ", credit_score=" + credit_score + ", password=" + password
				+ ", phone_number=" + phone_number + ", postal_code=" + postal_code + ", state=" + state + "]";
	}

}