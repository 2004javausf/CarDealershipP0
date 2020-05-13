package com.revature.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.CustomerBid;
import com.revature.beans.DealerPayments;
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

		int employee_id = 0;
		System.out.println("\n\n*************** Welcome Employee *************** \n\n");
		int choice;
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("\n\nPlease select an option from the menu?\n\n");

			System.out.println("1.) Create new account");
			System.out.println("2.) Login");
			System.out.println("3.) Payments list");
			System.out.println("4.) Add car to lot");
			System.out.println("5.) Remove car from lot");
			System.out.println("6.) Accept offer");
			System.out.println("7.) Reject offer");
			System.out.println("8.) Exit\n");
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

				System.out.println("What would you like your password to be?");
				String password = scan.nextLine();

				cdi.createEmployee(username, firstname, lastname, password);
				
				employee_id = cdi.getEmployeeidByUserName(username);


				System.out.println("Thanks for signing up!\n\n");
				break;
			case 2:

				System.out.println("Here you go. To login you need to enter your credentials..\n");

				System.out.println("Please enter your username: ");
				username = scan.next();
				System.out.println("Please enter your password: ");
				scan.nextLine();
				password = scan.nextLine();

				cdi.employeeLogin(username, password);
				
				employee_id = cdi.getEmployeeidByUserName(username);


				break;
			case 3:
				if (employee_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("Here is the payments list");
					List<DealerPayments> payments = dealerPaymentsDAOImpl.getAllPayments();

					if (payments.isEmpty()) {
						System.out.println("\n\nYou dont have any payments");
					} else {
						System.out.println("\n\nHere are the payments");

						for (DealerPayments p : payments) {
							System.out.println(p);
						}
					}
				}
				break;

			case 4:
				if (employee_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nAdd a car to alot");
					System.out.println("\n\nWhich car ?");

					int car_id = scan.nextInt();

					Car car = carDAOImpl.getCarById(car_id);

					if (car == null) {
						System.out.println("\n\nThis car is not present");
					}

					else if (car.getCurrent_status().equals("IN_LOT")) {
						System.out.println("\n\nThis car is already present in the lot");
					} else {
						carDAOImpl.addCarToLot(car_id);
						System.out.println("\n\nSuccessfully added the car to the lot");

					}
				}
				break;
			case 5:
				if (employee_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nRemove a car from the lot");
					System.out.println("\n\nWhich car ?");

					int car_id = scan.nextInt();

					Car car = carDAOImpl.getCarById(car_id);

					if (car == null) {
						System.out.println("\n\nThis car is not present");
					}

					if (!car.getCurrent_status().equals("IN_LOT")) {
						System.out.println("\n\nThis car is already not present in the lot");
					} else {
						carDAOImpl.removeCarFromLot(car_id);
						System.out.println("\n\nSuccessfully removed the car to the lot");

					}
				}
				break;
			case 6:
				if (employee_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nAccept an offer");

					List<CustomerBid> bids = customerBidsDAOImpl.getAllBids();

					if (bids.isEmpty()) {
						System.out.println("\n\n No Bids Available");
					}

					else {
						for (CustomerBid bid : bids) {
							System.out.println("\n" + bid);
						}
					}

					System.out.println("\n Which bid id ?");

					int bid_id = scan.nextInt();

					CustomerBid bid = customerBidsDAOImpl.getBidById(bid_id);

					if (bid == null) {
						System.out.println("Invalid bid id given");
					} else {
						customerBidsDAOImpl.acceptCustomerBid(bid_id);
						System.out.println("Successfully accept a bid");
					}
				}
				break;
			case 7:

				if (employee_id == 0) {
					System.out.println("\n\nUser need to either signup or login before doing any other operation");
				} else {
					System.out.println("\n\nReject an offer");

					List<CustomerBid> bids = customerBidsDAOImpl.getAllBids();

					if (bids.isEmpty()) {
						System.out.println("\n\n No Bids Available");
					}

					else {
						for (CustomerBid bid : bids) {
							System.out.println("\n" + bid);
						}
					}

					System.out.println("\n\nWhich bid id ?");

					int bid_id = scan.nextInt();

					CustomerBid bid = customerBidsDAOImpl.getBidById(bid_id);

					if (bid == null) {
						System.out.println("\n\nInvalid bid id given");
					} else {
						customerBidsDAOImpl.rejectBid(bid_id);
						System.out.println("\n\nSuccessfully rejected a bid");
					}
				}
			case 8:

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