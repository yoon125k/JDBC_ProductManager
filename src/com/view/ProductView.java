package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.ProductController;
import com.model.dto.Product;

public class ProductView {
	
	public int getMenu() {
		
		int select = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.전체 조회하기");
		System.out.println("2.상품 추가하기");
		System.out.println("3.상품 수정하기(상품id로 조회하고 수정)");
		System.out.println("4.상품 삭제하기(상품id로 조회해서 삭제)");
		System.out.println("5.상품 검색하기(상품 이름으로 키워드 검색)");
		System.out.println("0. 프로그램 종료하기");

		
		select = sc.nextInt();
		
		return select;
	}
	
	
	public ProductView() {
		int select = -1;
		ProductController pc = new ProductController();
		
		while(select !=0) {
			select = getMenu();
			
			switch(select){
			case 1:
				List<Product> res = pc.selectAll();//controller의 sellect all 실행
			for(Product p : res) {
				System.out.println(p.getProduct_id() + "," + p.getP_name() + "," + p.getPrice() + ","
						+ p.getDescription() + "," + p.getStock());
			}
			break;
			case 2:
				int resInsert = pc.insert();
			
			}
		}
		
		
		
	}
}
