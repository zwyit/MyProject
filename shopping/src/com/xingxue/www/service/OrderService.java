package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.entity.User;

public interface OrderService {
	// �µ� (����һ���������󣬶�������������)
	public void insert(Order order);
	public void order(Order order, List<OrderDetail> details);
	
	public List<Order> selectAll(User user);
	public Order selectOne(int id);
}
