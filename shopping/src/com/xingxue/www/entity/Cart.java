package com.xingxue.www.entity;

public class Cart {
	//���ﳵ
	private Integer id;
	private Integer product_id;//������Ʒid
	private Integer num;//������Ʒ����
	private String remark;//��ע
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product_id=" + product_id + ", num=" + num
				+ ", remark=" + remark + "]";
	}
	public Cart() {
		super();
	}
	public Cart(Integer id, Integer product_id, Integer num, String remark) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.num = num;
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
