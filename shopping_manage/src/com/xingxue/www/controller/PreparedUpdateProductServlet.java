package com.xingxue.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.REUtil;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class PreparedUpdateProductServlet
 */
public class PreparedUpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService=new ProductServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreparedUpdateProductServlet() {
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
		//ªÒ»°ID
		Integer id=Integer.parseInt(request.getParameter("id"));
		Product product=productService.selectOne(id);
		request.setAttribute("product", product);
		request.getRequestDispatcher("product_update.jsp").forward(request, response);
	}

}
