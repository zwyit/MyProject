package com.xingxue.www.entity;

import java.util.Date;
import java.util.List;

public class Order {
	private int id;//订单id
	private int user_id;//用户id
	private int addr_id;//地址信息id
	private double total;//支付总金额
	private Date order_date;//下单时间
	private int status;//订单状态
	
	private OrderDetail orderDetail;
	
	public OrderDetail getoDetail() {
		return orderDetail;
	}
	public void setoDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}
	
	public Order() {
		super();
	}
	public Order(int id, int user_id, int addr_id, double total,
			Date order_date, int status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.addr_id = addr_id;
		this.total = total;
		this.order_date = order_date;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(int addr_id) {
		this.addr_id = addr_id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", addr_id="
				+ addr_id + ", total=" + total + ", order_date=" + order_date
				+ ", status=" + status + ", orderDetail=" + orderDetail + "]";
	}
	public Order(int id, int user_id, int addr_id, double total,
			Date order_date, int status, OrderDetail orderDetail) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.addr_id = addr_id;
		this.total = total;
		this.order_date = order_date;
		this.status = status;
		this.orderDetail = orderDetail;
	}

}
