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
			ps.setInt(1, userId);
			ps.setString(2, userName);
			ps.setString(3, password);
			ps.setString(4, firstName);
			ps.setString(5, lastName);
			ps.executeUpdate();
			
			LogThis.LogIt("info", "User is added to Dealership Database.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
