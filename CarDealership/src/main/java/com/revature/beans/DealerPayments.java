package com.revature.beans;

public class DealerPayments {

	private int payment_id;

	private int bid_id;

	private int customer_id;

	private int car_id;

	private double amount;

	private double payment_date;
	
	public DealerPayments(int payment_id, int bid_id, int customer_id, int car_id, double amount, double payment_date) {
		super();
		this.payment_id = payment_id;
		this.bid_id = bid_id;
		this.customer_id = customer_id;
		this.car_id = car_id;
		this.amount = amount;
		this.payment_date = payment_date;
	}

	public DealerPayments() {
		super();
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(double payment_date) {
		this.payment_date = payment_date;
	}

	@Override
	public String toString() {
		return "DealerPayments [payment_id=" + payment_id + ", bid_id=" + bid_id + ", customer_id=" + customer_id
				+ ", car_id=" + car_id + ", amount=" + amount + ", payment_date=" + payment_date + "]";
	}

	
}