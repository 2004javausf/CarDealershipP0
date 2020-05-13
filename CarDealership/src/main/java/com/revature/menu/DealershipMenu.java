package com.revature.menu;

import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.daoImpl.CarDAOImpl;
import com.revature.daoImpl.CustomerDAOImpl;
import com.revature.daoImpl.DealerPaymentsDAOImpl;
import com.revature.daoImpl.EmployeeDAOImpl;

public class DealershipMenu {
	
	public static Scanner sc = new Scanner(System.in);
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	CustomerDAOImpl cdi = new CustomerDAOImpl();
	CarDAOImpl cadi = new CarDAOImpl();
	DealerPaymentsDAOImpl dealerPaymentsDAOImpl = new DealerPaymentsDAOImpl();

	CarDAOImpl carDAOImpl = new CarDAOImpl();

	public static void main(String args[]) {
		DealershipMenu s = new DealershipMenu();
		s.render();
	}

	public void render() {

		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println("\n\nPlease select an option from the menu?\n\n");

			System.out.println("Welcome to Dealer. what would you like to do?");
			System.out.println("Please select option from the menu.");
			System.out.println("1.) Accept a car and update to owned state");
			System.out.println("2.) Calculate monthly payment");
			System.out.println("3.) Exit\n");
			System.out.print("\nEnter Your Menu Choice: ");

			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("We are glad you are here");
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
				break;
			case 2:
				System.out.println("Here is the payment in a given month");

				System.out.println("Which year ?");

				int year = scan.nextInt();

				System.out.println("Which month ?");

				int month = scan.nextInt();

				double amount = dealerPaymentsDAOImpl.getMonthlyPayments(year, month);

				System.out.println("The total payment in the entered month is " + amount);
				break;
			case 3:

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