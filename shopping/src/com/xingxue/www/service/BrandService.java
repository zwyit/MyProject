package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.Brand;

public interface BrandService {
	//��Ʒ�����еķ���
	public void save(Brand brand);
	public void delete(Brand brand);
	public void update(Brand brand);
	public List<Brand> selectAll();
	public Brand selectOne(Integer id);
}
