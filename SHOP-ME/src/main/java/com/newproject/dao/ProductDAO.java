package com.newproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.newproject.Helper.DbConnectHelper;
import com.newproject.entity.Product;

public class ProductDAO {

	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	
	
	// THIS IS FOT ADD HE PRODUCTS IN THE PRODUCTS TABLE
	public boolean addProduct(Product product) {
		
		try {
			
			Connection con = DbConnectHelper.getConnection();
			
			String sql = "insert into products (productName, description, price, stockQuantity, productImageURL, categoryId) values (?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, product.getproductName());
			pst.setString(2, product.getdescription());
			pst.setDouble(3, product.getprice());
			pst.setInt(4, product.getstockQuantity());
			pst.setString(5, product.getproductImageURL());
			pst.setInt(6, product.getcategoryId());
					
			int change = pst.executeUpdate();
						
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
	
	
	
	// THIS IS FOR GET  PRODUCTS COUNT
	public int getproductCount() {
		
		try {
			Connection con = DbConnectHelper.getConnection();
			String sql = "select count(*) as product_count from products";
			
			
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next()) {
				int productCount = rs.getInt("product_count");
				return productCount;
			}					
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	// THIS IS FOR GET ALL PRODUCTS 
	public List<Product> getAllProducts() {
		 
		List<Product> allproducts = new ArrayList<>();
		
		try {
			Connection con = DbConnectHelper.getConnection();
			String sql = "select * from products";
			
			pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Product product = new Product();
				product.setproductId(rs.getInt("productId"));
				product.setproductName(rs.getString("productName"));
				product.setdescription(rs.getString("description"));
				product.setprice(rs.getDouble("price"));
				product.setstockQuantity(rs.getInt("stockQuantity"));
				product.setproductImageURL(rs.getString("productImageURL"));
				product.setcategoryId(rs.getInt("categoryId"));
				allproducts.add(product);
			}		
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return allproducts;
	}
	
	
	
	
	// THIS IS FOR GET ALL PRODUCTS BY THE CATEGORY
	public List<Product> getAllProductsById(int catid) {
		 
		List<Product> allproducts = new ArrayList<>();
		
		try {
			Connection con = DbConnectHelper.getConnection();
			String sql = "select * from products where categoryId=?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, catid);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Product product = new Product();
				product.setproductId(rs.getInt("productId"));
				product.setproductName(rs.getString("productName"));
				product.setdescription(rs.getString("description"));
				product.setprice(rs.getDouble("price"));
				product.setstockQuantity(rs.getInt("stockQuantity"));
				product.setproductImageURL(rs.getString("productImageURL"));
				product.setcategoryId(rs.getInt("categoryId"));
				allproducts.add(product);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return allproducts;
	}
	
	
	
	
	
	// THIS IS FOR GET ALL PRODUCTS BY THE PRODUCT ID
		public Product getAllProductsByPId(int proid) {
			 
			Product product = null;
			
			try {
				Connection con = DbConnectHelper.getConnection();
				String sql = "select * from products where productId=?";
				
				pst = con.prepareStatement(sql);
				pst.setInt(1, proid);
				
				rs = pst.executeQuery();
				
				if(rs.next()){
					product = new Product();
					
					product.setproductName(rs.getString("productName"));
					product.setprice(rs.getDouble("price"));
					product.setstockQuantity(rs.getInt("stockQuantity"));
					product.setproductImageURL(rs.getString("productImageURL"));
					
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}		
			return product;
		}
}
