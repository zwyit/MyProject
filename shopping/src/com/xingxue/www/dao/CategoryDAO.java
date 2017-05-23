package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Category;

public interface CategoryDAO {
	//商品类别表中的方法
	public void save(Category category);
	public void delete(Category category);
	public void update(Category category);
	public List<Category> selectAll();
	public Category selectOne(Integer id);
}
