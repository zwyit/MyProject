package com.xingxue.www.dao;

import java.util.List;

import com.xingxue.www.entity.Product;
public interface ProductDAO {
	public void save(Product product);//���
	public void delete(Product product);//ɾ��
	public void update(Product product);//�޸�
	public List<Product> sellectAll();//��ѯ
	
	public Product selectOne(Integer id);//�޸�ʱ����
	
	/**
	 * @param pageҳ��
	 * @param rowsҳ���С
	 */
	public int selectCount();//��ѯ��¼������ ��ҳ��
	public List<Product> selectProductForPage(int page,int rows);
}
