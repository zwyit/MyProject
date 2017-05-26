package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.entity.User;

public interface OrderService {
	// 下单 (接收一个订单对象，多个订单详情对象)
	public void insert(Order order);
	public void order(Order order, List<OrderDetail> details);
	
	public List<Order> selectAll(User user);
	public Order selectOne(int id);
}
