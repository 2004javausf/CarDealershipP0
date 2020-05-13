package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
	public void employeeLogin() {

		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Please enter your username: ");
			String username = scanner.next();
			System.out.println("Please enter your password: ");
			String password = scanner.nextLine();
			Connection conn = cf.getConnection();
			Statement stm = conn.createStatement();
			String sql = "SELECT username, password FROM employee WHERE customer_id = " + "'" + username + "'"
					+ " AND password = '" + password + "'";
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next() == false) {
				System.out.println("Incorrect customer ID or password.");
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