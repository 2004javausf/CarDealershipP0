package com.revature.beans;

public class Car {
	//fields
	private int car_id;

	private String vin_number;

	private String make;

	private String model;

	private int mileage;

	private int year;

	private double price;

	private double rate;

	private double monthly_payment;

	private String current_status;

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	
//Constructors
	public Car() {
		super();
	}

	public Car(int car_id, String vin_number, String make, String model, int mileage, int year, double price,
			double rate, double monthly_payment, String current_status) {
		super();
		this.car_id = car_id;
		this.vin_number = vin_number;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
		this.rate = rate;
		this.monthly_payment = monthly_payment;
		this.current_status = current_status;
	}

	//getter and setter methods
	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getVin_number() {
		return vin_number;
	}

	public void setVin_number(String vin_number) {
		this.vin_number = vin_number;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getMonthly_payment() {
		return monthly_payment;
	}

	public void setMonthly_payment(double monthly_payment) {
		this.monthly_payment = monthly_payment;
	}
	
	//to string Method
	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", vin_number=" + vin_number + ", make=" + make + ", model=" + model
				+ ", mileage=" + mileage + ", year=" + year + ", price=" + price + ", rate=" + rate
				+ ", monthly_payment=" + monthly_payment + ", current_status=" + current_status + "]";
	}

}