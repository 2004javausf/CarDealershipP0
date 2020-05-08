package com.revature.beans;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private int creditScore;
    private double cashOnHand;
    private int deleted;

    public Customer() {
        super();

    }


    public Customer(String firstName, String lastName, String address, String city, String postalCode, String phoneNumber, String email, double cashOnHand) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cashOnHand = cashOnHand;
        this.deleted = 0;
    }

    public Customer(int id, String firstName, String lastName, String address, String city, String postalCode, String phoneNumber, String email, double cashOnHand, int deleted) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cashOnHand = cashOnHand;
        this.deleted = deleted;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        cashOnHand += 500;
        this.cashOnHand = cashOnHand;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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