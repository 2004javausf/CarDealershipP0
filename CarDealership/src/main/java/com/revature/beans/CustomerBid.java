package com.revature.beans;

public class CustomerBid {

	private int bid_id;

	private int customer_id;

	private int car_id;

	private double offer_made;

	private int months;

	public CustomerBid() {
		super();
	}

	public CustomerBid(int bid_id, int customer_id, int car_id, double offer_made, int months) {
		super();
		this.bid_id = bid_id;
		this.customer_id = customer_id;
		this.car_id = car_id;
		this.offer_made = offer_made;
		this.months = months;
	}

	@Override
	public String toString() {
		return "CustomerBids [bid_id=" + bid_id + ", customer_id=" + customer_id + ", car_id=" + car_id
				+ ", offer_made=" + offer_made + ", months=" + months + "]";
	}

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public double getOffer_made() {
		return offer_made;
	}

	public void setOffer_made(double offer_made) {
		this.offer_made = offer_made;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

}
