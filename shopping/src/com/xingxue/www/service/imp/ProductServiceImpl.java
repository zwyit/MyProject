package com.xingxue.www.service.imp;

import java.util.List;

import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtil;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO=DAOFactory.getProductDAO();
	@Override
	public void save(Product product) {
		try{
			productDAO.save(product);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void delete(Product product) {
		try{
			productDAO.delete(product);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public void update(Product product) {
		try{
			productDAO.update(product);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Product> sellectAll() {
		try{
			return productDAO.sellectAll();
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public Product selectOne(Integer id) {
		try{
			return productDAO.selectOne(id);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public List<Product> selectProductForPage(int page, int rows) {
		try{
			return productDAO.selectProductForPage(page, rows);
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public int selectCount() {
		try{
			return productDAO.selectCount();
		}finally{
			JdbcUtil.close();
		}
	}

}
