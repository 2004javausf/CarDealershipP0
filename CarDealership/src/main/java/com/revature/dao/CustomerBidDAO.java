package com.revature.dao;

import java.util.List;

import com.revature.beans.CustomerBid;

public interface CustomerBidDAO {

	public void createCustomerBid(int car_id, int customer_id,  double offer_made);

	public void rejectCustomerBid(int bid_id);

	public void acceptCustomerBid(int bid_id);
	
	public void removeCarFromAllBids(int car_id);

	public CustomerBid getBidById(int bid_id);
	
	public void rejectBid(int bid);
	
	public List<CustomerBid> getAllBids();

}