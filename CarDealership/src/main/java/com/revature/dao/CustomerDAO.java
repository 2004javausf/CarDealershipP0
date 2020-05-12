package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Customer;

public interface CustomerDAO {
	public void insertCustomer(int custID, String address, String city, String state, String postalCode, String phoneNumber,
			String email, int creditScore, double cashOnHand, ArrayList<Integer> carsOwned, int deleted) throws SQLException;
	
	public List<Customer> getCustomerList() throws SQLException;
	
	public void getAccount(int id) throws SQLException;
	
	public void newAccount() throws SQLException;
	
	public void customerLogin() throws SQLException;
	
	public void makeOffer(int acct_num, int car_Id, int offer, int offer_Id, String stat) throws SQLException;
	
	public ArrayList <Car> getCarsOwned() throws SQLException;
	
	public void getBalance() throws SQLException;
	
	public void makePayment() throws SQLException;

}
