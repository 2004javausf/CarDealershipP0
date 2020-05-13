package com.revature.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.daoImpl.CustomerDAOImpl;
import com.revature.util.LogThis;

public class CustomerMenu {

	Customer cust = new Customer();
	CustomerDAOImpl cdi = new CustomerDAOImpl();
	String choice;


	public void render(Scanner sc) {
		System.out.println("Welcome Customer what would you like to do?");
		System.out.println("Please select option from the menu.");
		System.out.println("1: Create new account");
		System.out.println("2: Login");
		choice = sc.nextLine();
		
		if(choice.equals("1")) {
			String userName;
			String password;
			String firstName;
			String lastName;
			String address;
			String city;
			String state;
			String postalCode;
			String phoneNumber;
			String email;
			int creditScore;
			double cashOnHand;
			
			
			System.out.println("We are glad you are joining");
			System.out.println("What would you like your username to be?");
			userName = sc.nextLine();
			System.out.println("What would you like your password to be?");
			password = sc.nextLine();
			System.out.println("What is your first name?");
			firstName = sc.nextLine();
			System.out.println("What is your last name?");
			lastName = sc.nextLine();
			System.out.println("What is your address to be?");
			address = sc.nextLine();
			System.out.println("Which city do you live in?");
			city = sc.nextLine();
			System.out.println("Which state do you live in?");
			state = sc.nextLine();
			System.out.println("What is your postal code?");
			postalCode = sc.nextLine();
			System.out.println("What is your phone number?");
			phoneNumber = sc.nextLine();
			System.out.println("What is your email address?");
			email = sc.nextLine();
			System.out.println("What is your credit score?");
			creditScore = sc.nextInt();
			System.out.println("How much money do you wish to put down on the car?");
			cashOnHand = sc.nextDouble();
			
			try {
				cdi.createCustomer(userName, password,firstName,lastName, address,city, state, postalCode, phoneNumber,
						email, creditScore, cashOnHand);
				System.out.println("The new account for: " + firstName + " " + lastName + " has been created.");
				LogThis.LogIt("info", "Customer " + userName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		else if (choice.equals("2")) {
//			return CustomerDAO.customerLogin().render(sc);
			try {
				CustomerDAOImpl.customerLogin();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
			System.out.println("Invalid Entry");
//			return new CustomerMenu().render(sc);
		}
		
		System.out.println("Thanks for signing up!");
//		return new DealershipMenu().render(sc);
	}

}
