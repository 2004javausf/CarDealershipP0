package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.CustomerBid;
import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn;

	@Override
	public void createEmployee(String username, String firstname, String lastname, String password) {
		try {
			conn = cf.getConnection();
			String sql = "INSERT INTO employee(username, firstname, lastname, password) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, password);

			ps.executeUpdate();

			LogThis.LogIt("info", "Customer is added to Dealership Database.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void employeeLogin(String username, String password) {

		try {

			Connection conn = cf.getConnection();
			Statement stm = conn.createStatement();
			String sql = "SELECT username, password FROM employee WHERE username = " + "'" + username + "'"
					+ " AND password = '" + password + "'";
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next() == false) {
				System.out.println("Incorrect username or password.");
			} else {
				System.out.println("Welcome Employee");
				LogThis.LogIt("info", "Employee " + username + " is logged in");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public int getEmployeeidByUserName(String username) {
		

		CustomerBid bid = new CustomerBid();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM employee where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				bid.setCustomer_id(rs.getInt("employee_id"));
			

			}
			return bid.getCustomer_id();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}