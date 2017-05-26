package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.User;

public interface OrderDAO {
	
	public void insert(Order order);
	public List<Order> selectAll(User user);
	public Order selectOne(int id);
}
