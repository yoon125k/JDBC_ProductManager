package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			e.printStackTrace();

		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "KH";
		String pw = "KH";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url,id,pw);
		}catch(SQLException e){
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		}catch(SQLException e) {
			System.out.println("connection close 에러");
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		}catch(SQLException e) {
			System.out.println("statement clsoe 에러");
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstm) {
		try {
			pstm.close();
		}catch(SQLException e) {
			System.out.println("PreparedStatement clsoe 에러");
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			System.out.println("[Error] resultest close 에러");
			e.printStackTrace();
		}

	}
	
	public static void commit(Connection con) {
		try {
		con.commit();
		}catch(SQLException e) {
			System.out.println("[Error] commit 에러");
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		}catch(SQLException e) {
			System.out.println("[Error] rollback 에러");
			e.printStackTrace();
		}
	}
}
