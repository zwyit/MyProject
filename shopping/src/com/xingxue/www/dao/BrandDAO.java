package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Brand;

public interface BrandDAO {
	//��Ʒ�����еķ���
	public void save(Brand brand);
	public void delete(Brand brand);
	public void update(Brand brand);
	public List<Brand> selectAll();
	public Brand selectOne(Integer id);
}
