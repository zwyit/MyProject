package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.CategoryDAO;
import com.xingxue.www.entity.Category;
import com.xingxue.www.util.JdbcUtil;

public class CategoryDAOImpl implements CategoryDAO {

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
		return JdbcUtil.findList(Category.class, "select * from t_category");
	}

	@Override
	public Category selectOne(Integer id) {
		return JdbcUtil.findOne(Category.class, "select * from t_category where id=?", id);
	}

}
