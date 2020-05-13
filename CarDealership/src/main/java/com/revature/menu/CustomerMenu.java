package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.CustomerOwnedCars;
import com.revature.daoImpl.CarDAOImpl;
import com.revature.daoImpl.CustomerBidDAOImpl;
import com.revature.daoImpl.CustomerDAOImpl;
import com.revature.daoImpl.CustomerOwnedCarsDAOImpl;

public class CustomerMenu {
	
	CustomerDAOImpl cdi = new CustomerDAOImpl();
	CarDAOImpl carDAOImpl = new CarDAOImpl();
	CustomerBidDAOImpl customerBidsDAOImpl = new CustomerBidDAOImpl();
	CustomerOwnedCarsDAOImpl customerOwnedCarsDAOImpl = new CustomerOwnedCarsDAOImpl();

	public static void main(String args[]) {
		CustomerMenu s = new CustomerMenu();
		s.render();
	}

	public void render() {

		int customer_id = 0;
		System.out.println("\n\n*************** Welcome Customer *************** \n\n");
		int choice;
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("\n\nPlease select an option from the menu?\n\n");

			System.out.println("1.) Create customer account");
			System.out.println("2.) Login");
			System.out.println("3.) Cars on lot");
			System.out.println("4.) Make an offer for a car");
			System.out.println("5.) My list of cars");
			System.out.println("6.) My remaining payments");
			System.out.println("7.) Exit\n");
			System.out.print("\nEnter Your Menu Choice: ");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("We are glad you are joining\n\n");

				System.out.println("What is your username?");
				scan.nextLine();
				String username = scan.nextLine();

				System.out.println("What is your firstname?");
				String firstname = scan.nextLine();

				System.out.println("What is your lastname?");
				String lastname = scan.nextLine();

				System.out.println("What is your email?");
				String email = scan.nextLine();

				System.out.println("What is your address?");
				String address = scan.nextLine();

				System.out.println("What is your city?");
				String city = scan.nextLine();

				System.out.println("What is your state?");
				String state = scan.nextLine();

				System.out.println("What is your postal_code?");
				String postal_code = scan.nextLine();

				System.out.println("What is your phone_number?");
				String phone_number = scan.nextLine();

				System.out.println("What is your credit_score?");
				int credit_score = scan.nextInt();

				System.out.println("What is your cash_on_hand?");
				double cash_on_hand = scan.nextDouble();

				System.out.println("What would you like your password to be?");
				String password = scan.next();

				cdi.createCustomer(customer_id, username, password, firstname, lastname, email, address, city, state, postal_code, credit_score, cash_on_hand, phone_number);

				customer_id = cdi.getCustomeridByUserName(username);

				System.out.println("Thanks for signing up!\n\n");
				break;
			case 2:
				System.out.println("Here you go. To login you need to enter your credentials..\n");

				System.out.println("Please enter your username: ");
				username = scan.next();
				System.out.println("Please enter your password: ");
				password = scan.next();

				customer_id = cdi.customerLogin(username, password);

				break;
			case 3:
				if (customer_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					List<Car> cars = carDAOImpl.getCarsOnLot();
					System.out.println("Here are the cars on the lot");

					for (Car c : cars) {
						System.out.println(c);
					}
				}
				break;

			case 4:
				if (customer_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nOK you can make offer on a car");

					System.out.println("Which car ?");

					int car_id = scan.nextInt();

					Car car = carDAOImpl.getCarById(car_id);

					if (car == null || !car.getCurrent_status().equals("IN_LOT")) {
						System.out.println("\n\nThis car is not present in the lot");
					} else {
						System.out.println("\n\nWhat is the offer?");
						double offer_made = scan.nextDouble();

						customerBidsDAOImpl.createCustomerBid(car_id, customer_id, offer_made);
						System.out.println("\n\nSuccessfully created a bid");
					}
				}
				break;
			case 5:
				if (customer_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nHere is the list of cars you own");
					List<CustomerOwnedCars> customerOwnedCars = customerOwnedCarsDAOImpl.getCustomerCars(customer_id);

					if (customerOwnedCars.isEmpty()) {
						System.out.println("\n\nYou dont own any cars");
					} else {
						System.out.println("\n\nThe cars you own");

						for (CustomerOwnedCars c : customerOwnedCars) {
							System.out.println(c);
						}
					}
				}
				break;
			case 6:
				if (customer_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nHere is the list of remaining payments");
					List<CustomerOwnedCars> customerOwnedCars = customerOwnedCarsDAOImpl
							.getLeftOverPayments(customer_id);

					if (customerOwnedCars.isEmpty()) {
						System.out.println("\n\nYou dont have any payments");
					} else {
						System.out.println("\n\nHere are the pending payments");

						for (CustomerOwnedCars c : customerOwnedCars) {
							System.out.println(c);
						}
					}
				}
				break;
			case 7:
				System.out.println("\n\nExiting Program...");
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("\n\nThis is not a valid Menu Option! Please Select Another");
				break;
			}
		}
	}
}