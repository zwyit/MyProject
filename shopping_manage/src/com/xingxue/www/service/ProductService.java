package com.xingxue.www.service;

import java.util.List;

import com.xingxue.www.entity.Product;

public interface ProductService {
	public void save(Product product);//���
	public void delete(Product product);//ɾ��
	public void update(Product product);//�޸�
	public List<Product> sellectAll();//��ѯ
	
	public Product selectOne(Integer id);//�޸�ʱ����
}
