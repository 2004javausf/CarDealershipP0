package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.beans.DealerPayments;

public interface DealerPaymentsDAO {

	public void createPayment(int bid_id, int customer_id, int car_id, double amount,
			Date payment_date);
	
	public double getMonthlyPayments(int year, int month);
	
	public List<DealerPayments> getAllPayments();

}