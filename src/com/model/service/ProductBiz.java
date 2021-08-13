package com.model.service;


import java.sql.Connection;
import java.util.List;

import static com.common.JDBCTemplate.*;
import com.model.dao.ProductDao;
import com.model.dto.Product;
//기능1. 쿼리1 x 
//기능1, 쿼리3 개 실행시 biz에서 쿼리문3개가 전부 실행되어야 기능하나 실행
//즉 디비에 3번 접근해야 하나의 작업이 완료 그런 관리를 biz에서 한다.
//ex) insert 2번 실행하고 update를 실행시 모든 기능이 잘 실행되어야 작업완료
//안되면 되돌리는 작업을 비즈니스 ( 서비스) 에서 실행
public class ProductBiz {
	ProductDao pd = new ProductDao();

	public List<Product> selectAll(){
		Connection con = getConnection();
		List<Product> res = pd.selectAll(con);
		close(con);
		return res;
//		return pd.selectAll(getConnection());
	}
	
	public Product selectOne(String p_name) {
		Connection con = getConnection();
		Product dto = pd.selectOne(con, p_name);
		close(con);
		return dto;
//		return pd.selectOne(getConnection(), p_name);
	}
	
	public int insert(Product dto) {
		Connection con = getConnection();
		int res= pd.insert(con, dto);
		if (res > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return res;
//		return pd.insert(getConnection(), dto);

	}
	
	public int update(Product dto) {
		Connection con = getConnection();
		int res = pd.update(con, dto);
		
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
//		return pd.update(getConnection(), dto);

	}
	
	public int delete(String product_id) {
		Connection con = getConnection();
		int res = pd.delete(con, product_id);
		if(res>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return res;
//		return pd.delete(getConnection(), product_id);
		
	}
}
