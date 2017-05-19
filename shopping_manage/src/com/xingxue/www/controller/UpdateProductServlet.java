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
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService=new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取数据
		Integer id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String code=request.getParameter("code");
		Double price=Double.valueOf(request.getParameter("price"));
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer status=Integer.parseInt(request.getParameter("status"));
		Integer category_id=Integer.parseInt(request.getParameter("category_id"));
		Integer brand_id=Integer.parseInt(request.getParameter("brand_id"));
		String product_des=request.getParameter("product_des");
		
		Product product=new Product();
		product.setId(id);
		product.setName(name);
		product.setCode(code);
		product.setPrice(price);
		product.setCount(count);
		product.setStatus(status);
		product.setCategory_id(category_id);
		product.setBrand_id(brand_id);
		product.setProduct_des(product_des);
		
		productService.update(product);
		
		request.getRequestDispatcher("QueryProductServlet").forward(request, response);
	}

}
