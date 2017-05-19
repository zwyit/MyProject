package com.xingxue.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class QueryProductServlet
 */
public class QueryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService=new ProductServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProductServlet() {
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
		//查数据
		List<Product> products=productService.sellectAll();
		//存数据
		request.setAttribute("products", products);
		//转发
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

}
