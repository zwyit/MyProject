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
		//��ȡ�û���
		//��ȡ��¼�û�����
//		String name=(String)request.getAttribute("username");
//		System.out.println(name);
		//��ȡ�鿴��Ʒ��id
		Integer id=Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		
		//��ȡ��Ʒ����
		Product product=productService.selectOne(id);
		System.out.println(product);
		request.setAttribute("product", product);
		//��ȡ��ƷƷ��
		Brand brand=brandService.selectOne(product.getBrand_id());
		System.out.println(brand);
		request.setAttribute("brand", brand);
		//��ȡ���
		Category category=categoryService.selectOne(product.getCategory_id());
		System.out.println(category);
		request.setAttribute("category", category);
		
		request.getRequestDispatcher("xq.jsp").forward(request,response);
	}

}
