package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class UserDAOImpl implements UserDAO{
	public static ConnFactory cf=ConnFactory.getInstance();
	Connection conn;
	PreparedStatement ps;

	@Override
	public void createUser(int userId, String userName, String password, String firstName, String lastName,
			boolean isEmployee) throws SQLException {
		try {
			conn= cf.getConnection();
			String sql= "INSERT INTO USER VALUES (USSEQ.NEXTVAL,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setId(1, getUserId());
			ps.setString(2, getUserName());
			ps.setString(3, getPassword());
			ps.setString(4, getFirstName());
			ps.setString(5, getLastName());
			ps.executeUpdate();
			
			LogThis.LogIt("info", "User is added to Dealership Database.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
