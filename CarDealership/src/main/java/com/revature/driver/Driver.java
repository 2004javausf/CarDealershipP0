package com.revature.driver;

import java.util.Scanner;

import com.revature.menu.CustomerMenu;
import com.revature.menu.DealershipMenu;
import com.revature.menu.EmployeeMenu;

public class Driver {

	public static void main(String[] args) {

		System.out.println(
				"Welcome to the Yates' Dealership please pick from the following options \n1. Customer Interface\n2. Employer Interface\n3. Dealer Interface\n4. Done");

		Scanner input = new Scanner(System.in);

		int menuOption = input.nextInt();

		switch (menuOption) {
	
		case 1:
			CustomerMenu customerMenu = new CustomerMenu();
			customerMenu.render();
			System.out.println("Customer Interface");
			break;
		case 2:
			EmployeeMenu employeeMenu = new EmployeeMenu();
			employeeMenu.render();
			System.out.println("Employee Interface");
			break;
		case 3:
			System.out.println("Dealership Interface");
			DealershipMenu s = new DealershipMenu();
			s.render();
			break;
		case 4:
			System.out.println("Thank you for stopping by. Please come again.");
			System.exit(menuOption);
			break;
		default:
			System.out.println("Invalid Entry");
			System.out.println("\n\nPlease try again");

		}
		input.close();
	}
}