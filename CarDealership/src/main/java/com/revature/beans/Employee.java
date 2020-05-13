package com.revature.beans;

public class Employee {

	private int employee_id;

	private String username;

	private String firstname;

	private String lastname;

	private String password;

	
	public Employee() {
		super();
	}
	public Employee(int employee_id, String username, String firstname, String lastname, String password) {
		super();
		this.employee_id = employee_id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", username=" + username + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", password=" + password + "]";
	}
}