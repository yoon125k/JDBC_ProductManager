package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.common.JDBCTemplate;
import com.model.dao.ProductDao;
import com.model.dto.Product;
import com.model.service.ProductBiz;

public class ProductController extends JDBCTemplate {

	ProductBiz pb = new ProductBiz();
	
	public List<Product> selectAll(){
		return pb.selectAll();
	}
	
	public Product selectOne() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 상품명:");
		String p_name = sc.next();
		sc.nextLine();
		return pb.selectOne(p_name);
		
	}

	public int insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 상품 아이디 입력:");
		String product_id = sc.next();
		System.out.print("상품명: ");
		String p_name = sc.next();
		System.out.print("상품가격: ");
		int price = sc.nextInt();
		System.out.print("상품상세정보: ");
		String description = sc.next();
		System.out.print("재고: ");
		int stock = sc.nextInt();

		Product pd = new Product(product_id, p_name, price, description, stock);

		return pb.insert(pd);
	}

	public int update() {

		Product pd = new Product();
		return pb.update(pd);

	}
	
	public int delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 상품ID: ");
		String product_id = sc.next();
		
		return pb.delete(product_id);
		
	}
}
