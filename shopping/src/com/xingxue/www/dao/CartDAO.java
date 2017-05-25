package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Cart;

public interface CartDAO {
	
	public Cart selectOne(int user_id,int product_id);
	public void add(int user_id,int product_id,int num);
	public void delete(int user_id,int product_id);
	public void update(int user_id,int product_id,int num);
	public List<Cart> selectAll(int u_id);
	
	
	
	public List<Cart> selectForPage(int page,int rows);
	
}
