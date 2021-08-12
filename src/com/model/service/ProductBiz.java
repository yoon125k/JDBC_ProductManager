package com.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.common.JDBCTemplate;
import com.model.dao.ProductDao;
import com.model.dto.Product;

public class ProductBiz extends JDBCTemplate {
	ProductDao pd = new ProductDao();

	public List<Product> selectAll(){
		return pd.selectAll(getConnection());
	}
	
	public Product selectOne(String p_name) {
		return pd.selectOne(getConnection(), p_name);
	}
	
	public int insert(Product dto) {

		return pd.insert(getConnection(), dto);

	}

	public int update(Product dto) {

		return pd.update(getConnection(), dto);

	}
	
	public int delete(String product_id) {
		
		return pd.delete(getConnection(), product_id);
		
	}
}
