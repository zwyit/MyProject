package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.Category;

public interface CategoryService {
	//��Ʒ�����еķ���
	public void save(Category category);
	public void delete(Category category);
	public void update(Category category);
	public List<Category> selectAll();
	public Category selectOne(Integer id);
}
