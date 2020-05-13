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
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome Customer what would you like to do?");
		System.out.println("Please select option from the menu.");
		System.out.println("1: Create new account");
		System.out.println("2: Login");
		System.out.println("3: Cars on lot");
		System.out.println("4: Make an offer for a car");
		System.out.println("5: My list of cars you");
		System.out.println("6: My remaining payments");
		int choice = scan.nextInt();
		
		int customer_id = 0;
		
		System.out.println("Choice  " + choice);

		if (choice == 1) {

			System.out.println("We are glad you are joining");

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
			scan.nextLine();
			String password = scan.nextLine();

			cdi.createCustomer(customer_id, username, password, firstname, lastname, email, address, city, state, postal_code, credit_score, cash_on_hand, phone_number);
			
			customer_id = cdi.getCustomeridByUserName(username);


			System.out.println("Thanks for signing up!");

		}

		else if (choice == 2) {
			System.out.println("We are glad you are logining");
			
			System.out.println("Please enter your username: ");
			String username = scan.nextLine();
			System.out.println("Please enter your password: ");
			scan.nextLine();
			String password = scan.nextLine();
			
			customer_id = cdi.customerLogin();
			
			System.out.println(customer_id);
		}

		else if (choice == 3) {
			List<Car> cars = carDAOImpl.getCarsOnLot();
			System.out.println("Here are the cars on the lot");
			
			for(Car c : cars) {
				System.out.println(c);
			}
		}

		else if (choice == 4) {
			System.out.println("OK you can make offer on a car");

			System.out.println("Which car ?");

			int car_id = scan.nextInt();
			
			Car car = carDAOImpl.getCarById(car_id);
			
			if (car == null || !car.getCurrent_status().equals("IN_LOT")) {
				System.out.println("This car is not present in the lot");
			}
			else {
			System.out.println("What is the offer?");
			double offer_made = scan.nextDouble();
			
			
			
			customerBidsDAOImpl.createCustomerBid(car_id, customer_id, offer_made);
			System.out.println("Successfully created a bid");}
		}

		else if (choice == 5) {
			System.out.println("Here is the list of cars you own");
			List<CustomerOwnedCars> cars = customerOwnedCarsDAOImpl.getCustomerCars(customer_id);
			
			if(cars.isEmpty()) {
				System.out.println("You dont own any cars");
			}
			else {
				System.out.println("The cars you own");

				for (CustomerOwnedCars c : cars) {
					System.out.println(c);
				}
			}
		}

		else if (choice == 6) {
			System.out.println("Here is the list of remaining payments");
			List<CustomerOwnedCars> cars = customerOwnedCarsDAOImpl.getLeftOverPayments(customer_id);
			
			if(cars.isEmpty()) {
				System.out.println("You dont have any payments");
			}
			else {
				System.out.println("Here are the pending payments");

				for (CustomerOwnedCars c : cars) {
					System.out.println(c);
				}
			}
		}

		else {
			System.out.println("Invalid Entry");
		}
		scan.close();
	}
}