package com.revature.dao;

import java.util.List;

import com.revature.beans.Car;

public interface CarDAO {

	public void createCar(String vin_number, String make, String model, int mileage, int year, double price,
			double rate, double monthly_payment);

	public void removeCarFromLot(int car_id);

	public void addCarToLot(int car_id);
	
	public Car getCarById(int car_id);
	
	public List<Car> getCarsOnLot();

}