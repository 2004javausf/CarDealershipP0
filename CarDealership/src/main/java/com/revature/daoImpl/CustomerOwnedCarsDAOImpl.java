package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.CustomerOwnedCars;
import com.revature.dao.CustomerOwnedCarsDAO;
import com.revature.util.ConnFactory;

public class CustomerOwnedCarsDAOImpl implements CustomerOwnedCarsDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn;

	@Override
	public void addCarToCustomer(int customer_id, int car_id, double amount, boolean is_payment_made) {

		try {
			conn = cf.getConnection();
			String sql = "INSERT INTO customer_owned_cars(customer_id, car_id, amount, is_payment_made) VALUES (?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, customer_id);
			ps.setLong(2, car_id);
			ps.setDouble(3, amount);
			ps.setBoolean(4, is_payment_made);

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CustomerOwnedCars> getCustomerCars(int customer_id) {
		
		List<CustomerOwnedCars> cars = new ArrayList<CustomerOwnedCars>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM customer_owned_cars where customer_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, customer_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerOwnedCars car = new CustomerOwnedCars();
				
				car.setCar_id(rs.getInt("car_id"));
				car.setCustomer_id(rs.getInt("customer_id"));
				car.setAmount(rs.getDouble("amount"));
				car.setIs_payment_made(rs.getBoolean("is_payment_made"));

	


			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cars;
	}

	@Override
	public List<CustomerOwnedCars> getLeftOverPayments(int customer_id) {
		
		List<CustomerOwnedCars> cars = new ArrayList<CustomerOwnedCars>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM customer_owned_cars where customer_id = ? AND is_payment_made = false";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, customer_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerOwnedCars car = new CustomerOwnedCars();
				
				car.setCar_id(rs.getInt("car_id"));
				car.setCustomer_id(rs.getInt("customer_id"));
				car.setAmount(rs.getDouble("amount"));
				car.setIs_payment_made(rs.getBoolean("is_payment_made"));

	


			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cars;
	}


}
