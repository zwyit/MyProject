package com.xingxue.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.entity.Product;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class AddProductServlet
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService=new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		//获取数据
		String name=request.getParameter("name");
		System.out.println(name);
		String code=request.getParameter("code");
		Double price=Double.valueOf(request.getParameter("price"));
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer status=Integer.parseInt(request.getParameter("status"));
		Integer category_id=Integer.parseInt(request.getParameter("category_id"));
		Integer brand_id=Integer.parseInt(request.getParameter("brand_id"));
		String product_des=request.getParameter("remark");
				
		Product product=new Product();
		product.setName(name);
		product.setCode(code);
		product.setPrice(price);
		product.setCount(count);
		product.setStatus(status);
		product.setCategory_id(category_id);
		product.setBrand_id(brand_id);
		product.setProduct_des(product_des);
		productService.save(product);
		
		request.getRequestDispatcher("QueryProductServlet").forward(request, response);
	}

}
