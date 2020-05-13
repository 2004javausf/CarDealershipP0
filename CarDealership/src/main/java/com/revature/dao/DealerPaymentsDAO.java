package com.revature.dao;

import java.util.List;

import com.revature.beans.DealerPayments;

public interface DealerPaymentsDAO {

	public void createPayment(int customer_id, int car_id, double amount);
	
	public double getMonthlyPayments(int year, int month);
	
	public List<DealerPayments> getAllPayments();

}