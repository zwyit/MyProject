package com.xingxue.www.dao.imp;

import java.util.List;

import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.entity.Product;
import com.xingxue.www.util.JdbcUtilC3P0;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void save(Product product) {
		JdbcUtilC3P0.update("insert into t_product values(t_product_seq.nextval,?,?,?,?,?,?,?,?,?)", product.getName(),product.getCode(),product.getProduct_des(),product.getPrice(),product.getCount(),product.getStatus(),product.getImg_path(),product.getCategory_id(),product.getBrand_id());
	}

	@Override
	public void delete(Product product) {
		JdbcUtilC3P0.update("delete from t_product where id=?", product.getId());
	}

	@Override
	public void update(Product product) {
//		JdbcUtilC3P0.update("update t_product set name=?,code=?,price=?,count=?,status=?,category_id=?,brand_id=?,product_des=? where id=?", product.getName(),product.getCode(),product.getPrice(),product.getCount(),product.getStatus(),product.getCategory_id(),product.getBrand_id(),product.getProduct_des(),product.getId());
		JdbcUtilC3P0.update("update t_product set name=?,code=?,price=?,count=?,status=?,category_id=?,brand_id=?,product_des=? where id=?", product.getName(),product.getCode(),product.getPrice(),product.getCount(),product.getStatus(),product.getCategory_id(),product.getBrand_id(),product.getProduct_des(),product.getId());
	}

	@Override
	public List<Product> sellectAll() {
		return JdbcUtilC3P0.findList(Product.class, "select * from t_product");
	}
	
	/*public static void main(String[] args) {
		List<Product> products=JdbcUtilC3P0C3P0.findList(Product.class, "select * from t_product");
		for(Product p:products){
			System.out.println(p);
		}
	}*/
	
	@Override
	public Product selectOne(Integer id) {
		return JdbcUtilC3P0.findOne(Product.class, "select * from t_product where id=?", id);
	}

	@Override
	public List<Product> selectProductForPage(int page, int rows) {
		return JdbcUtilC3P0.findList(Product.class, page, rows, "select * from t_product");
	}

	@Override
	public int selectCount() {
		return JdbcUtilC3P0.findOne(Integer.class, "select count(*) from t_product");
	}
	
/*	public static void main(String[] args) {
		int num=(new ProductDAOImpl()).selectCount();
		System.out.println(num);
	}*/
}
