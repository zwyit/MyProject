package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.entity.Product;
import com.xingxue.www.util.JdbcUtil;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void save(Product product) {
		JdbcUtil.update("insert into t_product values(t_product_seq.nextval,?,?,?,?,?,?,?,?,?)", product.getName(),product.getCode(),product.getProduct_des(),product.getPrice(),product.getCount(),product.getStatus(),product.getImg_path(),product.getCategory_id(),product.getBrand_id());
	}

	@Override
	public void delete(Product product) {
		JdbcUtil.update("delete from t_product where id=?", product.getId());
	}

	@Override
	public void update(Product product) {
//		JdbcUtil.update("update t_product set name=?,code=?,price=?,count=?,status=?,category_id=?,brand_id=?,product_des=? where id=?", product.getName(),product.getCode(),product.getPrice(),product.getCount(),product.getStatus(),product.getCategory_id(),product.getBrand_id(),product.getProduct_des(),product.getId());
		JdbcUtil.update("update t_product set name=?,code=?,price=?,count=?,status=?,category_id=?,brand_id=?,product_des=? where id=?", product.getName(),product.getCode(),product.getPrice(),product.getCount(),product.getStatus(),product.getCategory_id(),product.getBrand_id(),product.getProduct_des(),product.getId());
	}

	@Override
	public List<Product> sellectAll() {
		return JdbcUtil.findList(Product.class, "select * from t_product");
	}

	@Override
	public Product selectOne(Integer id) {
		return JdbcUtil.findOne(Product.class, "select * from t_product where id=?", id);
	}
	
/*	public static void main(String[] args) {
		List<Product> products=JdbcUtil.findList(Product.class, "select * from t_product");
		for(Product p:products){
			System.out.println(p);
		}
	}*/
}
