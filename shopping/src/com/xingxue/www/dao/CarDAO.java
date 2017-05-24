package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Cart;

public interface CarDAO {
	public void add(Cart cart);
	public void delete(Cart cart);
	public void update(Cart cart);
	public List<Cart> selectAll();
}
