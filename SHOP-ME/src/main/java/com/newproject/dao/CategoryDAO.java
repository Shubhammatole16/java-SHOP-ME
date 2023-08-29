package com.newproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newproject.Helper.DbConnectHelper;
import com.newproject.entity.Category;

public class CategoryDAO {

	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	
	// THIS IS FOR THE ADD CATEGORY IN THE CATEGORIRES TABLE
	public boolean addCategory(Category category) {
		
		try {
			con = DbConnectHelper.getConnection();
			
			String sql = "insert into categories (categoryName) values (?)";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, category.getcategoryName());
			
			int change = pst.executeUpdate();
			
			
			pst.close();
			con.close();
			
			if(change > 0) {
				return true;
			}
			else return false;
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	// THIS IS FOR GET THE ALL THE CATEGORIES
	public List<Category> getAllCategories() {
		
		List<Category> categories = new ArrayList<>();
		
		try {
			con = DbConnectHelper.getConnection();
			String sql = "select * from categories";
			
			pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery(sql);
			
			while(rs.next()) {
				Category category = new Category();
				category.setcategoryId(rs.getInt("categoryId"));
				category.setcategoryName(rs.getString("categoryName"));
				categories.add(category);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}
	
	
	
	// THIS IS FOR GET THE  COUNT OF CATEGORY
	public int getcategoryCount() {
		
		try {
			Connection con = DbConnectHelper.getConnection();
			String sql = "select count(*) as category_count from categories";
			pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				int categoryCount = rs.getInt("category_count");
				return categoryCount;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
