package com.revature.dao;

import java.sql.SQLException;

public interface UserDAO {
	//CREATE METHODS
		public void createUser(int userId, String userName, String password, String firstName, String lastName, boolean isEmployee) throws SQLException;
}
