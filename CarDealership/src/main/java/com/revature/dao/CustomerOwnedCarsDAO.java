package com.revature.dao;

import java.util.List;

import com.revature.beans.CustomerOwnedCars;

public interface CustomerOwnedCarsDAO {

	public void addCarToCustomer(int customer_id, int car_id, double amount, boolean is_payment_made);

	public List<CustomerOwnedCars> getCustomerCars(int customer_id);

	public List<CustomerOwnedCars> getLeftOverPayments(int customer_id);

}
