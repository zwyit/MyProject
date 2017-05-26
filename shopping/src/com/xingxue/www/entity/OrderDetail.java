package com.xingxue.www.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	
	private int order_id;//订单id
	private int p_id;//商品id
	private String p_name;//商品名称
	private double p_price;//商品价格
	private int p_num;//购买数量
	
	private Order order;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderDetail() {
		super();
	}

	public OrderDetail(int order_id, int p_id, String p_name, double p_price,
			int p_num) {
		super();
		this.order_id = order_id;
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_num = p_num;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public double getP_price() {
		return p_price;
	}

	public void setP_price(double p_price) {
		this.p_price = p_price;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	@Override
	public String toString() {
		return "OrderDetail [order_id=" + order_id + ", p_id=" + p_id + ", p_name=" + p_name + ", p_price=" + p_price
				+ ", p_num=" + p_num + "]";
	}

}
