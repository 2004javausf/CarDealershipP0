package com.revature.beans;

import java.util.ArrayList;

public class Customer extends User {
	//fields
	private int custID;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private int creditScore;
    private double cashOnHand;
    private ArrayList<Integer> carsOwned;
    private int deleted;

    //Constructors
    public Customer() {
        super();

    }

    public Customer(int custID, String address, String city, String state, String postalCode, String phoneNumber,
			String email, int creditScore, double cashOnHand, ArrayList<Integer> carsOwned, int deleted) {
		super();
		this.custID = custID;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.creditScore = creditScore;
		this.cashOnHand = cashOnHand;
		this.carsOwned = carsOwned;
		this.deleted = deleted;
	}


    //Getters and Setters
    public int getCustID() {
        return custID;
    }


    public void setCustID(int custID) {
        this.custID = custID;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        address += "Dealership City ";
        this.address = address;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

    public String getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public double getCashOnHand(){
        return cashOnHand;
    }

    public void setCashOnHand(double cashOnHand){
        cashOnHand += 500.00;
        this.cashOnHand = cashOnHand;
    }
    

	public ArrayList<Integer> getCarsOwned() {
		return carsOwned;
	}

	public void setCarsOwned(ArrayList<Integer> carsOwned) {
		this.carsOwned = carsOwned;
	}
	
    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    //to String method
    @Override
    public String toString() {
        return "Customer{" +
        		"custID= '" + custID + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", creditScore=" + creditScore +
                ", cashOnHand=" + cashOnHand +
                '}';
    }
}