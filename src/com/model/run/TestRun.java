package com.model.run;

import com.controller.ProductController;
import com.model.dto.Product;
import com.model.service.ProductBiz;
import com.view.ProductMenu;

public class TestRun {
	public static void main(String[] args) {
		Product pd = new Product();
		ProductMenu pm = new ProductMenu();
		ProductController pc = new ProductController();
		ProductBiz pb = new ProductBiz();
		
	
//		System.out.println(pb.insert(pd));
		
		pm.menu();
//		pc.selectAll();
		
		
		
	}
}
