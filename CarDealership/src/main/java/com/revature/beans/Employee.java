package com.revature.beans;

public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private int userID;

    //Constructor Methods
    public Employee(){
        super();
    }

    public Employee(int empId, String firstName, String lastName) {
        super();
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    //getters and setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    //to String
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void handleCustomer(Customer customer, boolean finance, Car car){
        if(finance == true){
            double loanAmount = car.getPrice() - customer.getCashOnHand();
            runCreditHistory(customer, loanAmount);
        }else if(car.getPrice() <= customer.getCashOnHand()){
            //customer pays in cash
            processTransaction(customer, car);
        }else {
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " will need more money to purchase " + car + ".");
        }
    }

    public void runCreditHistory(Customer customer, double loanAmount){
        System.out.println("Customer's Credit history was ran.");
        System.out.println("Customer has been approved to purchase the car.");
    }
    public void processTransaction(Customer customer, Car car){
        System.out.println("Customer has purchased the car: " + car + " for the price: $" + car.getPrice());
    }
}