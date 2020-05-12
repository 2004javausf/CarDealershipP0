package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class EmployeeDAOImpl implements EmployeeDAO{
	public static ConnFactory cf=ConnFactory.getInstance();
	Connection conn;
	PreparedStatement ps;

	@Override
	public void insertEmployee(int empId) throws SQLException {
		try {
			conn= cf.getConnection();
			String sql= "INSERT INTO EMPLOYEE VALUES (CUSTSEQ.NEXTVAL,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setId(1, getEmpId());
			ps.executeUpdate();
			
			LogThis.LogIt("info", "Employee is added to Dealership Database.");
		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<Employee> getEmployeeList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAccount(int empId) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newAccount() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void employeeLogin() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
