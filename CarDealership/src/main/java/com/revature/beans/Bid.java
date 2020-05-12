package com.revature.beans;

public class Bid {
	//fields
	private int bidId, userID, carID;
	private double bidAmount;
	private boolean isAccepted;
	private int months;

	//Constructors
	public Bid() {
		super();
	}
	public Bid(int bidId, int userID, int carID, double bidAmount, boolean isAccepted, int months) {
		super();
		this.bidId = bidId;
		this.userID = userID;
		this.carID = carID;
		this.bidAmount = bidAmount;
		this.isAccepted = isAccepted;
		this.months = months;
	}
	
	
	//Getters and Setters
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public double getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAmount(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public int getMonths() {
		return months;
	}
	public void setMonths(int months) {
		this.months = months;
	}
	//to String Method
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", userID=" + userID + ", carID=" + carID + ", bidAmount=" + bidAmount
				+ ", isAccepted=" + isAccepted + ", months=" + months + "]";
	}
	
	
	
	
}
