package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.OrderDetail;

public interface OrderDetailDAO {
	//����
	public void insert(OrderDetail orderDetail);
	//��ѯ
	public List<OrderDetail> selectDetails(int id);
}
