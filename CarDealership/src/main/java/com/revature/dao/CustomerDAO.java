package com.revature.dao;

public interface CustomerDAO {

	public void createCustomer(int customer_id, String username, String password, String firstname, String lastname, String email, String address, String city, String state, String postal_code, int credit_score, double cash_on_hand, String phone_number);

	public int customerLogin(String username, String password);
	
	public int getCustomeridByUserName(String username);
}