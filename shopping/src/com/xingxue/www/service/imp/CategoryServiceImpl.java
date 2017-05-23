package com.xingxue.www.service.imp;

import java.util.List;

import com.xingxue.www.dao.CategoryDAO;
import com.xingxue.www.entity.Category;
import com.xingxue.www.service.CategoryService;
import com.xingxue.www.util.DAOFactory;
import com.xingxue.www.util.JdbcUtil;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO=DAOFactory.getCategoryDAO();
	
	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> selectAll() {
		try{
			return categoryDAO.selectAll();
		}finally{
			JdbcUtil.close();
		}
	}

	@Override
	public Category selectOne(Integer id) {
		try{
			return categoryDAO.selectOne(id);
		}finally{
			JdbcUtil.close();
		}
	}

}
