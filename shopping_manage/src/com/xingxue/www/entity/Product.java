package com.xingxue.www.entity;

import java.io.Serializable;
import java.util.List;

import com.xingxue.www.util.JdbcUtil;

public class Product implements Serializable{
	private Integer id;  
	private String name;//商品名称
	private String code;//商品编号
	private String product_des;//商品描述
	private Double price;//商品价格
	private Integer count;//商品数量
	private Integer status;//0:上架 1:下架
	private String img_path;//商品图片路径
	private Integer category_id;//商品类别的id,
	private Integer brand_id;//商品品牌id 
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", code=" + code
				+ ", product_des=" + product_des + ", price=" + price
				+ ", count=" + count + ", status=" + status + ", img_path="
				+ img_path + ", category_id=" + category_id + ", brand_id="
				+ brand_id + "]";
	}
	
	public Product() {
		super();
	}
	public Product(Integer id, String name, String code, String product_des,
			Double price, Integer count, Integer status, String img_path,
			Integer category_id, Integer brand_id) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.product_des = product_des;
		this.price = price;
		this.count = count;
		this.status = status;
		this.img_path = img_path;
		this.category_id = category_id;
		this.brand_id = brand_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProduct_des() {
		return product_des;
	}
	public void setProduct_des(String product_des) {
		this.product_des = product_des;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Integer getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}
	
/*	public static void main(String[] args) {
		List<Product> products=JdbcUtil.findList(Product.class, "select * from t_product");
		for(Product p:products){
			System.out.println(p);
		}
	}*/
}
