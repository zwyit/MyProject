package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.OrderDetail;

public interface OrderDetailDAO {
	//Ôö¼Ó
	public void insert(OrderDetail orderDetail);
	//²éÑ¯
	public List<OrderDetail> selectDetails(int id);
}
