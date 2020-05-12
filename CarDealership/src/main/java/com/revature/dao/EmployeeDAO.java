package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {
public void insertEmployee(int empId) throws SQLException;
	
	public List<Employee> getEmployeeList() throws SQLException;
	
	public void getAccount(int id) throws SQLException;
	
	public void newAccount() throws SQLException;
	
	public void employeeLogin() throws SQLException;
}
