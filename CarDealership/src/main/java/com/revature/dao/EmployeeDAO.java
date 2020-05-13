package com.revature.dao;

public interface EmployeeDAO {

	public void createEmployee(String username, String firstname, String lastname, String password);
	
	public void employeeLogin();
}
