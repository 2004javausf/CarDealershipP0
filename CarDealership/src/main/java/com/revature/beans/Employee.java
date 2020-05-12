package com.revature.beans;

public class Employee extends User {
    private int empId;
    

    //Constructor Methods
    public Employee(){
        super();
    }

    public Employee(int empId) {
        super();
        this.empId = empId;
    }


    //getters and setters
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    
    //to String
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId  +
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