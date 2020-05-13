package com.revature.beans;

public class CustomerOwnedCars {

	private int customer_id;

	private int car_id;

	private double amount;

	private boolean is_payment_made;

	
	public CustomerOwnedCars() {
		super();
	}

	public CustomerOwnedCars(int customer_id, int car_id, double amount, boolean is_payment_made) {
		super();
		this.customer_id = customer_id;
		this.car_id = car_id;
		this.amount = amount;
		this.is_payment_made = is_payment_made;
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

	public boolean isIs_payment_made() {
		return is_payment_made;
	}

	public void setIs_payment_made(boolean is_payment_made) {
		this.is_payment_made = is_payment_made;
	}
	
	@Override
	public String toString() {
		return "CustomerOwnedCars [customer_id=" + customer_id + ", car_id=" + car_id + ", amount=" + amount
				+ ", is_payment_made=" + is_payment_made + "]";
	}

}
