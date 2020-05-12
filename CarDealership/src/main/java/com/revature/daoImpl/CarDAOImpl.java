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

public class CarDAOImpl implements CarDAO{
	public static ConnFactory cf=ConnFactory.getInstance();
	Connection conn;
	PreparedStatement ps;
	@Override
	public void createCar(String VIN, String make, String model, int year, int mileage, double price, String status) throws SQLException {
	//Prepared Statement- pre compiled - compiled in Java/ Statement is complied in sql
		try {
		Connection conn= cf.getConnection();
		String sql= "INSERT INTO POWERS VALUES (CARSEQ.NEXTVAL,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, VIN);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setInt(4, year);
		ps.setInt(5, mileage);
		ps.setDouble(6, price);
		ps.setString(7, status);
		ps.executeUpdate();
		
		LogThis.LogIt("info", "Car has been added to the lot.");
	}catch(SQLException e) {
		e.printStackTrace();
		
	}
	}
	@Override
	public List<Car> getCarList() throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		try {
			conn = cf.getConnection();
			String sql = "SELECT * FROM CARS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps .executeQuery();
			
			//When getting the result set you must grab the
					//COLUMN NAMES
			while(rs.next()) {
				Car car = new Car();
				car.setVIN(rs.getInt("VIN"));
				car.setMake(rs.getString("make"));
				car.setModel(rs.getString("model"));
				car.setYear(rs.getInt("year"));
				car.setOwner(rs.getString("owner"));
				car.setPrice(rs.getInt("price"));
				
				cars.add(car);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	
}
