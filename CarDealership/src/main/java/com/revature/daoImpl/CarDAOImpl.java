package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;
import com.revature.dao.CarDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class CarDAOImpl implements CarDAO {
	public static ConnFactory cf = ConnFactory.getInstance();
	Connection conn;

	@Override
	public void createCar(String vin_number, String make, String model, int mileage, int year, double price,
			double rate, double monthly_payment) {

		try {
			conn = cf.getConnection();
			String sql = "INSERT INTO car(vin_number, make, model, mileage, "
					+ "year, price, rate, monthly_payment) VALUES (?,?,?,?,?,?,?,?,?)";

			System.out.println(conn);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vin_number);
			ps.setString(2, make);
			ps.setString(3, model);
			ps.setLong(4, mileage);
			ps.setLong(5, year);
			ps.setDouble(6, price);
			ps.setDouble(7, rate);
			ps.setDouble(8, monthly_payment);

			ps.executeUpdate();

			LogThis.LogIt("info", "Customer is added to Dealership Database.");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Car> getCarsOnLot() {
		List<Car> cars = new ArrayList<Car>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM car where current_status = 'IN_LOT' ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Car car = new Car();
				
				
				car.setCar_id(rs.getInt("car_id"));
				car.setVin_number(rs.getString("vin_number"));

				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));
				car.setCurrent_status(rs.getString("current_status"));

				car.setMileage(rs.getInt("mileage"));

				car.setYear(rs.getInt("year"));
				car.setPrice(rs.getInt("price"));
				car.setRate(rs.getInt("rate"));
				
				cars.add(car);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cars;
	}

	@Override
	public void removeCarFromLot(int car_id) {

		conn = cf.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement("update car set current_status=? where car_id =?");

			stmt.setString(1, "NOT_IN_LOT");
			stmt.setInt(2, car_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	@Override
	public void addCarToLot(int car_id) {
		conn = cf.getConnection();

		try {
			PreparedStatement stmt = conn.prepareStatement("update car set current_status=? where car_id =?");

			stmt.setString(1, "IN_LOT");
			stmt.setInt(2, car_id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}

	}

	@Override
	public Car getCarById(int car_id) {

		Car car = new Car();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM car where car_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, car_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				car.setCar_id(rs.getInt("car_id"));
				car.setVin_number(rs.getString("vin_number"));

				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));
				car.setCurrent_status(rs.getString("current_status"));

				car.setMileage(rs.getInt("mileage"));

				car.setYear(rs.getInt("year"));
				car.setPrice(rs.getInt("price"));
				car.setRate(rs.getInt("rate"));

			}
			return car;
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
}