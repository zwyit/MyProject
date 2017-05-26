package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.OrderDetail;


public interface OrderDetailService {
	
	public List<OrderDetail> selectDetails(int id);
}
