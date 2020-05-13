package com.revature.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.daoImpl.CarDAOImpl;
import com.revature.daoImpl.CustomerDAOImpl;
import com.revature.daoImpl.EmployeeDAOImpl;

public class DealershipMenu {
	public static Scanner sc = new Scanner(System.in);
    EmployeeDAOImpl edi = new EmployeeDAOImpl();
    CustomerDAOImpl cdi = new CustomerDAOImpl();
	CarDAOImpl cadi = new CarDAOImpl();
    int menuOption = 0;
        

        

    
    public static void displayMenu(int menuOption) {
    	System.out.println("Welcome to the Yates' Dealership please choose from the following options (Press 0 for menu) \n\n");
        System.out.println("What would you like to do?");
        System.out.println("----------------------------------------------------------------");
        System.out.println("1. Sign in as a customer.");
        System.out.println("2. Sign in as an employee.");
        System.out.println("3. Exit program.\n\n");
        menuOption=sc.nextInt();
        
        switch (menuOption) {
        case 0:
            System.out.println("Main Menu");
            displayMenu(menuOption);
            break;
        case 1:
            System.out.println("Customer Login");
            new CustomerMenu().render(sc);
            break;
        case 2:
            System.out.println("Employee Login");
            new EmployeeLogin().render(menuOption);
            break;
        case 3:
            System.out.println("Thank you for stopping by. Please come again.");
            System.exit(menuOption);
            break;
        default:
        	System.out.println("Invalid Entry");
        	System.out.println("\n\nPlease try again");
        	
    }
    
    }
}

