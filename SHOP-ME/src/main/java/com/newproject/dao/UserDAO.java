package com.newproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newproject.Helper.*;
import com.newproject.entity.*;


public class UserDAO {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	// THIS IS FOR THE ADD USER TO THE SHOPUSER TABLE
	public boolean addUser(User user) {
		
		try {
			con = DbConnectHelper.getConnection();
			String sql = "insert into shopusers (userFname, userLname, userMobile, userEmail, userPassword, userType) VALUES (?, ?, ?, ?, ?, 'normal')";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, user.getuserFname());
			pst.setString(2, user.getuserLname());
			pst.setString(3, user.getuserMobile());
			pst.setString(4, user.getuserEmail());
			pst.setString(5, user.getuserPassword());
			
			int changed = pst.executeUpdate();
			
			pst.close();
            con.close();
            
			if(changed > 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}
	
	
	
	
	
	
	
	// THIS IS FOR GET USEREAMIL AND USERPASSWORD
	public User getUserByEmailAndPassword(String userEmail, String userPsssword) {
		User user = null;
			
		try {
			con = DbConnectHelper.getConnection();
			String sql = "select * from shopusers where userEmail=? && userPassword=?";
			pst = con.prepareStatement(sql);
				
			pst.setString(1, userEmail);
			pst.setString(2, userPsssword);
				
			rs = pst.executeQuery();
				
			if(rs.next()) {
				user = new User();
					
				user.setuserEmail(rs.getString("userEmail"));
				user.setuserPassword(rs.getString("userPassword"));
				user.setuserFname(rs.getString("userFname"));
				user.setuserType(rs.getString("userType"));	
				user.setuserId(rs.getInt("userId"));
			}
			pst.close();
			con.close();
			rs.close();
				
		}
		catch( Exception e) {
			e.printStackTrace();
		}
	return user;
	}
	
	
	
	
	// THIS IS FOR GET THE USER COUNT
	public int getuserCount() {
				
		try {
			Connection con = DbConnectHelper.getConnection();
			String sql = "select count(*) as user_count from shopusers WHERE userType != 'admin';";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
	
			if(rs.next()) {
				int userCount = rs.getInt("user_count");
				return userCount;
			}
		}
	
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
