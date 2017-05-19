package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.Product;

public interface ProductService {
	public void save(Product product);//添加
	public void delete(Product product);//删除
	public void update(Product product);//修改
	public List<Product> sellectAll();//查询
	
	public Product selectOne(Integer id);//修改时回显
}
