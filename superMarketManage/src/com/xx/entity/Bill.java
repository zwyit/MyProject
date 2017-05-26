package com.xx.entity;

import java.io.Serializable;
import java.sql.Date;

public class Bill implements Serializable {
	private Integer id;
	private String code;//账单编号
	private String productName;//商品名称
	private Integer productCount;//商品数量
	private Double money;//交易金额
	private Integer payStatus;//付款状态   0：已付    1：未付
	private String supplierName;//供应商名字
	private String productDesc;//商品描述
	private Date createDate;//账单时间
	
	
	
	public Bill() {
		super();
	}
	public Bill(Integer id, String code, String productName,
			Integer productCount, Double money, Integer payStatus,
			String supplierName, String productDesc, Date createDate) {
		super();
		this.id = id;
		this.code = code;
		this.productName = productName;
		this.productCount = productCount;
		this.money = money;
		this.payStatus = payStatus;
		this.supplierName = supplierName;
		this.productDesc = productDesc;
		this.createDate = createDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}
