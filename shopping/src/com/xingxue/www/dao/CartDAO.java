package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Cart;

public interface CartDAO {
	
	public Cart selectOne(int user_id,int product_id);
	public Cart selectOne(int id);
	public void add(int user_id,int product_id,int num);
	public void add(Cart cart);
	public void delete(int id);
	public void clear(int user_id);
	public void update(int user_id,int product_id,int num);
	public void update(Cart cart);
	public List<Cart> selectAll(int u_id);
	
	
	
	public List<Cart> selectForPage(int page,int rows);
	
}
