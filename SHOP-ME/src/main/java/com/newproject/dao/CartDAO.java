package com.newproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newproject.Helper.*;
import com.newproject.entity.Cart;
import com.newproject.entity.Category;
import com.newproject.entity.Product;
public class CartDAO {
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	

	public  boolean addCart(int userId, int productId) {
		
		
		  try {
			  con = DbConnectHelper.getConnection();
			  String sql = "select * from cart where userId=? and productId=?";
			  
			  pst = con.prepareStatement(sql);
			  
			  pst.setInt(1, userId);
			  pst.setInt(2, productId);
			  
			  rs = pst.executeQuery();
			  
			  if(rs.next()) {
				  String sqladdq = "update cart set quantity = quantity + 1 where userId = ? and productId = ?";
				  pst = con.prepareStatement(sqladdq);
				  
				  pst.setInt(1, userId);
				  pst.setInt(2, productId);
				  pst.executeUpdate();
				  return true;
			  }
			  else {
				  String sqladdcart = "insert into cart (userId, productId, quantity) VALUES (?, ?, 1)";
				  pst = con.prepareStatement(sqladdcart);
				  pst.setInt(1, userId);
				  pst.setInt(2, productId);
				  pst.executeUpdate();
				  return true;
			  }
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
		return false;
	}
	
	
	
	
	public int getproductcount(int userId) {
		
		try {
			
			con = DbConnectHelper.getConnection();
			
			String sql = "select sum(quantity) as total_quantity from cart where userId=?";
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, userId);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				int productCount = rs.getInt("total_quantity");
				return productCount;
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		return 0;
	}	
	
	
	
	
	
	public List<Cart>  getallcartitems( int userId){
		
		List<Cart> cartitems = new ArrayList<>();
		
		try {
			con = DbConnectHelper.getConnection();
			
			String sql = "select c.productId, c.quantity, p.productName, p.price, p.productImageURL from cart c join products p on c.productId = p.productId where c.userId=?";
			
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Cart cart = new Cart();
				
				cart.setproductId(rs.getInt("productId"));
				cart.setproductName(rs.getString("productName"));
				cart.setprice(rs.getDouble("price"));
				cart.setproductImageURL(rs.getString("productImageURL"));
				cart.setquantity(rs.getInt("quantity"));
				cartitems.add(cart);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return cartitems;
		
	}
	
	
	
	
	public double totalCartPrice(List<Cart> cartitems) {
		double totalprice = 0.0;
		
		
		for(Cart item : cartitems) {
			double itemprice = item.getprice() * item.getquantity();
			 totalprice  += itemprice;
		}
		return totalprice;
	}




	public boolean getremoveStatus(int uid, int deletepro) {
		
		try {
			
			con = DbConnectHelper.getConnection();
			
			String sql = "delete from cart where userId = ? and productId = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.setInt(2, deletepro);
			
			int changed = pst.executeUpdate();
			
			if(changed > 0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}




	public boolean removeoneProduct(int productId, int userId) {
		
		
		try {
			
			con = DbConnectHelper.getConnection();
			
			String sql = "update cart set quantity = quantity - 1 where productId = ? and userId=?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, productId);
			pst.setInt(2, userId);
			
			int changed = pst.executeUpdate();
			
			if(changed > 0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
public boolean addoneProduct(int productId, int userId) {
		
		
		try {
			
			con = DbConnectHelper.getConnection();
			
			String sql = "update cart set quantity = quantity + 1 where productId = ? and userId=?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, productId);
			pst.setInt(2, userId);
			
			int changed = pst.executeUpdate();
			
			if(changed > 0) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
