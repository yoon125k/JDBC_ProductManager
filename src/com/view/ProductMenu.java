package com.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.controller.ProductController;
import com.model.dto.Product;

import oracle.net.aso.e;

public class ProductMenu {

	public void menu() {

		System.out.println("1.전체 조회하기");
		System.out.println("2.상품 추가하기");
		System.out.println("3.상품 수정하기(상품id로 조회하고 수정");
		System.out.println("4.상품 삭제하기(상품id로 조회해서 삭제");
		System.out.println("5.상품 검색하기(상품 이름으로 키워드 검색");
		System.out.println("0. 프로그램 종료하기");

		ProductController pc = new ProductController();
		Scanner sc = new Scanner(System.in);

		System.out.print("메뉴번호를 입력하세요: ");
		int no = sc.nextInt();

		int num = 0;

		switch (no) {
		case 1:
			List<Product> ProductList = pc.selectAll();
			for (Product p : ProductList) {
				System.out.println(p.getProduct_id() + "," + p.getP_name() +"," + p.getPrice() +"," + p.getDescription() +"," + p.getStock());
			}
			break;

		case 2:
			num = pc.insert();
			if (num > 0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
			break;
		case 3:
			num = pc.update();
			if (num > 0) {
				System.out.println("update 성공");
			} else {
				System.out.println("update 실패");
			}
			break;
		case 4:
			num = pc.delete();
			if (num > 0) {
				System.out.println("delete 성공");

			} else {
				System.out.println("delete 실패");
			}
			break;
		case 5:
			pc.selectOne();
			System.out.println();
			break;

		default:
			System.out.println("종료");
			break;
		}

	}

}
