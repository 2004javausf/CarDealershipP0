package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;

public interface CarDAO {
		
	//Create
		public void createCar(String VIN, String make, String model, int year, int mileage, double price, String status)
				throws SQLException;
		
		//Read All
		public List<Car> getCarList()throws SQLException;

		

		

}
