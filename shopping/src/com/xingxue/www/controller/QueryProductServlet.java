package com.xingxue.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.imp.ProductServiceImpl;


public class QueryProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductService productService=new ProductServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置页面大小
		int rows=4;
		//获取登录用户名字
		request.getAttribute("username");
		//获取页
		int page=Integer.parseInt(request.getParameter("page"));
		//查询每页的数据
		List<Product> products=productService.selectProductForPage(page, rows);	
		//存取页
		request.setAttribute("page", page);
		//存每页的数据
		request.setAttribute("products", products);
		//totalPage记录总页数
		int totalPage=0;
		//totalCount记录总记录数
		int totalCount=0;
		//查询所有的商品的总数
		/*List<Product> products2=productService.sellectAll();*/
		int count=productService.selectCount();
		//对数据大小进行判断
		if(count!=0){
			//总记录数
			totalCount=count;
			System.out.println("总记录数:"+totalCount);
			//总页数
			totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
			System.out.println("总页数:"+totalPage);
			//存总记录数
			request.getSession().setAttribute("totalCount", totalCount);
			//存总页数
		    request.getSession().setAttribute("totalPage", totalPage);
		}else{
			//存总记录数
			request.getSession().setAttribute("totalCount", 0);
			//存总页数
		    request.getSession().setAttribute("totalPage", 0);
		}
		//转发
		request.getRequestDispatcher("index-nn.jsp").forward(request, response);
	}

}
