	package com.revature.beans;

	import java.io.*;
	import java.util.Objects;

	public class Car{
	    //fields
	    private String VIN;
	    private String make;
	    private String model;
	    private int year;
	    private int mileage;
	    private double price;
	    private String status;
	    public static int numCars = 0;
	//Constructors
	    public Car() {};   // no args constructor
	    public Car(String VIN, String make, String model, int year, int mileage, double price, String status) {
	        this.VIN = VIN;
	        this.make = make;
	        this.model = model;
	        this.year = year;
	        this.mileage = mileage;
	        this.price = price;
	        this.status = status;
	        numCars ++;

	    }

	    //Getters and Setters

	    public String getVIN() {
	        return VIN;
	    }

	    public String getMake() {
	        return make;
	    }

	    public String getModel() {
	        return model;
	    }

	    public int getYear() {
	        return year;
	    }

	    public int getMileage() {
	        return mileage;
	    }

	    public double getPrice() {
	        return price;
	    }
	    public String getStatus() {
	        return status;
	    }

	    public void setVIN(String VIN) {
	        this.VIN = VIN;
	    }

	    public void setMake(String make) {
	        this.make = make;
	    }

	    public void setModel(String model) {
	        this.model = model;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public void setMileage(int mileage) {
	        this.mileage = mileage;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }


	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Car)) return false;
	        Car car = (Car) o;
	        return getYear() == car.getYear() &&
	                getMileage() == car.getMileage() &&
	                Double.compare(car.getPrice(), getPrice()) == 0 &&
	                getVIN().equals(car.getVIN()) &&
	                getMake().equals(car.getMake()) &&
	                getModel().equals(car.getModel()) &&
	                getStatus().equals(car.getStatus());
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(getVIN(), getMake(), getModel(), getYear(), getMileage(), getPrice(), getStatus());
	    }
	    //to string method
	    @Override
	    public String toString() {
	        return "Car{" +
	                "VIN='" + VIN + '\'' +
	                ", make='" + make + '\'' +
	                ", model='" + model + '\'' +
	                ", year=" + year +
	                ", mileage=" + mileage +
	                ", price=" + price +
	                ", status='" + status + '\'' +
	                '}';
	    }
   

}
