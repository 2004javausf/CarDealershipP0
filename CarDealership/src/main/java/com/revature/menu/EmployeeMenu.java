package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.CustomerBid;
import com.revature.beans.DealerPayments;
import com.revature.dao.CustomerBidDAO;
import com.revature.daoImpl.CarDAOImpl;
import com.revature.daoImpl.CustomerBidDAOImpl;
import com.revature.daoImpl.DealerPaymentsDAOImpl;
import com.revature.daoImpl.EmployeeDAOImpl;

public class EmployeeMenu {

	EmployeeDAOImpl cdi = new EmployeeDAOImpl();

	DealerPaymentsDAOImpl dealerPaymentsDAOImpl = new DealerPaymentsDAOImpl();

	CarDAOImpl carDAOImpl = new CarDAOImpl();

	CustomerBidDAOImpl customerBidsDAOImpl = new CustomerBidDAOImpl();
	
	
	public static void main(String args[]) {
		EmployeeMenu s = new EmployeeMenu();
		s.render();
	}

	public void render() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome Employee what would you like to do?");
		System.out.println("Please select option from the menu.");
		System.out.println("1: Create new account");
		System.out.println("2: Login");
		System.out.println("3: Payments list");
		System.out.println("4: Add car to lot");
		System.out.println("5: Remove car from lot");
		System.out.println("6: Accept offer");
		System.out.println("7: Reject offer");
		int choice = scan.nextInt();

		if (choice == 1) {

			System.out.println("We are glad you are joining");

			System.out.println("What is your username?");
			scan.nextLine();

			String username = scan.nextLine();

			System.out.println("What is your firstname?");
			String firstname = scan.nextLine();

			System.out.println("What is your lastname?");
			String lastname = scan.nextLine();

			System.out.println("What would you like your password to be?");
			String password = scan.nextLine();

			cdi.createEmployee(username, firstname, lastname, password);

			System.out.println("Thanks for signing up!");

		}

		else if (choice == 2) {
			System.out.println("We are glad you are joining");

			System.out.println("We are glad you are logining");

			System.out.println("Please enter your username: ");
			String username = scan.next();
			System.out.println("Please enter your password: ");
			scan.nextLine();
			String password = scan.nextLine();

			cdi.employeeLogin();
		}

		else if (choice == 3) {
			System.out.println("Here is the payments list");
			List<DealerPayments> payments = dealerPaymentsDAOImpl.getAllPayments();

			if (payments.isEmpty()) {
				System.out.println("You dont have any payments");
			} else {
				System.out.println("Here are the payments");

				for (DealerPayments p : payments) {
					System.out.println(p);
				}
			}
		}

		else if (choice == 4) {
			System.out.println("Add a car to alot");
			System.out.println("Which car ?");

			int car_id = scan.nextInt();

			Car car = carDAOImpl.getCarById(car_id);

			if (car == null) {
				System.out.println("This car is not present");
			}

			else if (car.getCurrent_status().equals("IN_LOT")) {
				System.out.println("This car is already present in the lot");
			} else {
				carDAOImpl.addCarToLot(car_id);
				System.out.println("Successfully added the car to the lot");

			}
		}

		else if (choice == 5) {
			System.out.println("Remove a car from the lot");
			System.out.println("Which car ?");

			int car_id = scan.nextInt();

			Car car = carDAOImpl.getCarById(car_id);

			if (car == null) {
				System.out.println("This car is not present");
			}

			if (!car.getCurrent_status().equals("IN_LOT")) {
				System.out.println("This car is already not present in the lot");
			} else {
				carDAOImpl.removeCarFromLot(car_id);
				System.out.println("Successfully removed the car to the lot");

			}
		}

		else if (choice == 6) {

			System.out.println("Accept an offer");
			System.out.println("Which bid ?");

			int bid_id = scan.nextInt();

			CustomerBid bid = customerBidsDAOImpl.getBidById(bid_id);

			if (bid == null) {
				System.out.println("Invalid bid id given");
			} else {
				customerBidsDAOImpl.acceptCustomerBid(bid_id);
				System.out.println("Successfully accept a bid");
			}

		}

		else if (choice == 7) {
			System.out.println("Reject an offer");
			System.out.println("Which bid ?");
			
			int bid_id = scan.nextInt();

			CustomerBid bid = customerBidsDAOImpl.getBidById(bid_id);

			if (bid == null) {
				System.out.println("Invalid bid id given");
			} else {
				customerBidsDAOImpl.rejectBid(bid_id);
				System.out.println("Successfully rejected a bid");
			}

		}

		else {
			System.out.println("Invalid Entry");
		}

		scan.close();
	}
}