package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.dao.CustomerDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class CustomerDAOImpl implements CustomerDAO {
	static Scanner userInput = new Scanner(System.in);
	public static ConnFactory cf=ConnFactory.getInstance();
	Connection conn;
	PreparedStatement ps;
	@Override
	public void insertCustomer(int custID, String address, String city, String state, String postalCode,
			String phoneNumber, String email, int creditScore, double cashOnHand, ArrayList<Integer> carsOwned,
			int deleted) throws SQLException {
		//Prepared Statement- pre compiled - compiled in Java/ Statement is complied in sql
				try {
				conn= cf.getConnection();
				String sql= "INSERT INTO CUSTOMER VALUES (CUSTSEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, custID);
				ps.setString(2, address);
				ps.setString(3, city);
				ps.setString(4, state);
				ps.setString(5, postalCode);
				ps.setString(6, phoneNumber);
				ps.setString(7, email);
				ps.setDouble(8, creditScore);
				ps.setDouble(9, cashOnHand);
				ps.setString(10, carsOwned);
				ps.executeUpdate();
				
				LogThis.LogIt("info", "Customer is added to Dealership Database.");
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
		
	}

	@Override
	public List<Customer> getCustomerList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAccount(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newAccount() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void customerLogin() throws SQLException {
		
		int custAccNum;
		String password;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please Enter your Customer ID: ");
		custAccNum = userInput.nextInt();
		System.out.println("Enter Password");
		password = userInput.nextLine();
		Connection conn = cf.getConnection();
		Statement stm = conn.createStatement();
		String sql = "SELECT CUST_ID, PASSWORD FROM CUSTOMER WHERE CUST_ID = " + custAccNum + " AND PASSWORD = '" + password + "'";
		ResultSet rs = stm.executeQuery(sql);
		if(rs.next() == false) {
			System.out.println("Incorrect customer ID or password.");
			customerLogin();
		}
		else {
			System.out.println("Welcome Customer");
			CustLogin.uNum = num;
			LogThis.LogIt("info", "Customer " + custAccNum + " is logged in");
		}
		
	}

	@Override
	public void makeOffer(int acct_num, int car_Id, int offer, int offer_Id, String stat) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Car> getCarsOwned() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getBalance() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makePayment() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

}
