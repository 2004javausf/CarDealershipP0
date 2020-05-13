package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.dao.CustomerDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class CustomerDAOImpl implements CustomerDAO {

	static Scanner userInput = new Scanner(System.in);
	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn;

	@Override
	public void createCustomer(int customer_id, String username, String password, String firstname, String lastname, String email, String address, String city, String state, String postal_code, int credit_score, double cash_on_hand, String phone_number) {
		try {
			conn = cf.getConnection();
			String sql = "INSERT INTO customer(username, firstname, lastname, email, "
					+ "address, city, state, postal_code, phone_number, "
					+ "credit_score, cash_on_hand, password) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, email);
			ps.setString(5, address);
			ps.setString(6, city);
			ps.setString(7, state);
			ps.setString(8, postal_code);
			ps.setString(9, phone_number);
			ps.setInt(10, credit_score);
			ps.setDouble(11, cash_on_hand);
			ps.setString(12, password);

			ps.executeUpdate();

			LogThis.LogIt("info", "Customer is added to Dealership Database.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void customerLogin() {

		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Please enter your username: ");
			String username = scanner.next();
			System.out.println("Please enter your password: ");
			String password = scanner.nextLine();
			Connection conn = cf.getConnection();
			Statement stm = conn.createStatement();
			String sql = "SELECT username, password FROM customer WHERE customer_id = " + "'" + username + "'"
					+ " AND password = '" + password + "'";
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next() == false) {
				System.out.println("Incorrect username or password.");
			} else {
				System.out.println("Welcome Customer");
				LogThis.LogIt("info", "Customer " + username + " is logged in");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			scanner.close();
		}
	}
}