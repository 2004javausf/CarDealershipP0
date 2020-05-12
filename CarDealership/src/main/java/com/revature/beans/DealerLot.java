package com.revature.beans;

import java.util.ArrayList;

public class DealerLot {
	private ArrayList<Integer> carInventory;
	private ArrayList<Integer> customers;
	
	//Constructor
	public DealerLot() {
		super();
	}
	public DealerLot(ArrayList<Integer> carInventory, ArrayList<Integer> customers) {
		super();
		this.carInventory = carInventory;
		this.customers = customers;
	}
	
	//Getters and Setters
	public ArrayList<Integer> getCarInventory() {
		return carInventory;
	}
	public void setCarInventory(ArrayList<Integer> carInventory) {
		this.carInventory = carInventory;
	}
	public ArrayList<Integer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Integer> customers) {
		this.customers = customers;
	}
	
	//ToString Method

}
