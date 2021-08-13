package com.view;

import java.util.List;
import java.util.Scanner;

import com.controller.ProductController;
import com.model.dto.Product;

public class ProductMenu {

	public void menu() {

		System.out.println("1.전체 조회하기");
		System.out.println("2.상품 추가하기");
		System.out.println("3.상품 수정하기");
		System.out.println("4.상품 삭제하기");
		System.out.println("5.상품 검색하기");
		System.out.println("0. 프로그램 종료하기");

		ProductController pc = new ProductController();
		Scanner sc = new Scanner(System.in);

		int no = -1;
		int num = 0;

		while (no != 0) {
			System.out.print("메뉴번호를 입력하세요: ");
			no = sc.nextInt();
			switch (no) {
			case 1:
				List<Product> ProductList = pc.selectAll();
				for (Product p : ProductList) {
					System.out.println(p.getProduct_id() + "," + p.getP_name() + "," + p.getPrice() + ","
							+ p.getDescription() + "," + p.getStock());
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
				Product p = pc.selectOne();
				if(p != null) {
					System.out.println(p.getProduct_id()+p.getP_name()+p.getPrice()+p.getDescription()+p.getStock());
					
				} else {
					System.out.println("검색된 정보가 없습니다.");
				}
				break;

			default:
				System.out.println("종료");
				break;
			}
		}

	}

}
