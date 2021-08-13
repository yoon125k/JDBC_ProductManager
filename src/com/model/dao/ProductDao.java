package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.common.JDBCTemplate.*;
import com.model.dto.Product;

public class ProductDao{
	List<Product> ProductList = new ArrayList<Product>();

	public ProductDao() {
	}

	public ProductDao(ArrayList<Product> list) {
		ProductList = list;
	}

	public List<Product> selectAll(Connection con) {
//		List<Product> ProductList = new ArrayList<Product>();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM PRODUCT";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Product p = new Product();
				p.setProduct_id(rs.getString(1));
				p.setP_name(rs.getString(2));
				p.setPrice(rs.getInt(3));
				p.setDescription(rs.getString(4));
				p.setStock(rs.getInt(5));
				
				ProductList.add(p);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			close(stmt);
		}
		return ProductList;
	}

	public Product selectOne(Connection con, String p_name) {

		Product pd = new Product();
		PreparedStatement pstm = null;
		String sql = "SELECT * FROM PRODUCT WHERE P_NAME = ?";
		ResultSet rs = null;
		
		Product res = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p_name);

			rs = pstm.executeQuery();

			if(rs.next()) {
				res = new Product();
				res.setProduct_id(rs.getString(1));
				res.setP_name(rs.getString(2));
				res.setPrice(rs.getInt(3));
				res.setDescription(rs.getString(4));
				res.setStock(rs.getInt(5));
				
			}
//			
//			while (rs.next()) {
//				System.out.println(rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getInt(3) + ":" + rs.getString(4)
//						+ ":" + rs.getInt(5));
//			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			
		}
		return res;

	}

	public int insert(Connection con, Product dto) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?)";
		int rs = 0;

		try {
			con = getConnection();
			pstm = con.prepareCall(sql);
			pstm.setString(1, dto.getProduct_id());
			pstm.setString(2, dto.getP_name());
			pstm.setInt(3, dto.getPrice());
			pstm.setString(4, dto.getDescription());
			pstm.setInt(5, dto.getStock());
			rs = pstm.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			
		}
		return rs;
	}

	public int update(Connection con, Product dto) {
		
		PreparedStatement pstm = null;
		String sql = "UPDATE PRODUCT SET P_NAME = ?,PRICE = ?,DESCRIPTION =?,STOCK =? WHERE PRODUCT_ID = ?";
		int rs = 0;


		con = getConnection();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(5, dto.getProduct_id());
			pstm.setString(1, dto.getP_name());
			pstm.setInt(2, dto.getPrice());
			pstm.setString(3, dto.getDescription());
			pstm.setInt(4, dto.getStock());
			rs = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			
		}

		return rs;
	}

	public int delete(Connection con, String product_id) {

		con = getConnection();
		PreparedStatement pstm = null;
		int rs = 0;
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = ?";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, product_id);

			rs = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			
		}

		return rs;
	}

}
