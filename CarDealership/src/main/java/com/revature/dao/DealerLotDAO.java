package com.revature.dao;

import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.User;

public interface DealerLotDAO {
 public List<User> getUserList() throws Exception;
	
	public List<Car> getCarsList() throws Exception;
	
	public void addCars() throws Exception;
	
	public void removeCar() throws Exception;

	public void viewCars() throws Exception;
	
	public List<Car> ownedCars(String userName) throws Exception;
	
	public void acceptRejectOffers() throws Exception;
}
