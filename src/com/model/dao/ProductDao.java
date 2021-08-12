package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.common.JDBCTemplate;
import com.model.dto.Product;

public class ProductDao extends JDBCTemplate {
	List<Product> ProductList = new ArrayList<Product>();

	public ProductDao() {
	}

	public ProductDao(ArrayList<Product> list) {
		ProductList = list;
	}

	public List<Product> selectAll(Connection con) {

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
			close(rs);
			close(stmt);
			close(con);
		}
		return ProductList;
	}

	public Product selectOne(Connection con, String p_name) {

		Product pd = new Product();
		PreparedStatement pstm = null;
		String sql = "SELECT * FROM PRODUCT WHERE P_NAME = ?";
		ResultSet rs = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p_name);

			rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getInt(3) + ":" + rs.getString(4)
						+ ":" + rs.getInt(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return pd;

	}

	public int insert(Connection con, Product dto) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO PRODUCT VALUES(?,?,?,?,?)";
		int result = 0;

		try {
			con = getConnection();
			pstm = con.prepareCall(sql);
			pstm.setString(1, dto.getProduct_id());
			pstm.setString(2, dto.getP_name());
			pstm.setInt(3, dto.getPrice());
			pstm.setString(4, dto.getDescription());
			pstm.setInt(5, dto.getStock());
			int rs = pstm.executeUpdate();
			result = rs;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return result;
	}

	public int update(Connection con, Product dto) {
		Scanner sc = new Scanner(System.in);
		PreparedStatement pstm = null;
		String sql = "UPDATE PRODUCT SET P_NAME = ?,PRICE = ?,DESCRIPTION =?,STOCK =? WHERE PRODUCT_ID = ?";
		int rs = 0;

		System.out.print("수정할 상품 아이디 입력:");
		String product_id = sc.next();
		System.out.print("상품명: ");
		String p_name = sc.next();
		System.out.print("상품가격: ");
		int price = sc.nextInt();
		System.out.print("상품상세정보: ");
		String description = sc.next();
		System.out.print("재고: ");
		int stock = sc.nextInt();

		con = getConnection();

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p_name);
			pstm.setInt(2, price);
			pstm.setString(3, description);
			pstm.setInt(4, stock);
			pstm.setString(5, product_id);
			rs = pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}

		return rs;
	}

}
