package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Product;
public interface ProductDAO {
	public void save(Product product);//添加
	public void delete(Product product);//删除
	public void update(Product product);//修改
	public List<Product> sellectAll();//查询
	
	public Product selectOne(Integer id);//修改时回显
	
	/**
	 * @param page页号
	 * @param rows页面大小
	 */
	public int selectCount();//查询记录的总数 分页用
	public List<Product> selectProductForPage(int page,int rows);
}
