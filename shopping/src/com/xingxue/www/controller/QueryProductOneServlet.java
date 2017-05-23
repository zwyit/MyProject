package com.xingxue.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingxue.www.dao.ProductDAO;
import com.xingxue.www.entity.Brand;
import com.xingxue.www.entity.Category;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.BrandService;
import com.xingxue.www.service.CategoryService;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.imp.BrandServiceImpl;
import com.xingxue.www.service.imp.CategoryServiceImpl;
import com.xingxue.www.service.imp.ProductServiceImpl;

/**
 * Servlet implementation class QueryProductOneServlet
 */
public class QueryProductOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BrandService brandService=new BrandServiceImpl();
    private ProductService productService=new ProductServiceImpl();
    private CategoryService categoryService=new CategoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProductOneServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		//获取登录用户名字
//		String name=(String)request.getAttribute("username");
//		System.out.println(name);
		//获取查看商品的id
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		
		//获取商品对象
		Product product=productService.selectOne(id);
		System.out.println(product);
		request.setAttribute("product", product);
		//获取商品品牌
		Brand brand=brandService.selectOne(product.getBrand_id());
		System.out.println(brand);
		request.setAttribute("brand", brand);
		//获取类别
		Category category=categoryService.selectOne(product.getCategory_id());
		System.out.println(category);
		request.setAttribute("category", category);
		
		request.getRequestDispatcher("xq.jsp").forward(request,response);
	}

}
