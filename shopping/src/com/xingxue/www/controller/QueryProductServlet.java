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
		//����ҳ���С
		int rows=4;
		//��ȡ��¼�û�����
		request.getAttribute("username");
		//��ȡҳ
		int page=Integer.parseInt(request.getParameter("page"));
		//��ѯÿҳ������
		List<Product> products=productService.selectProductForPage(page, rows);	
		//��ȡҳ
		request.setAttribute("page", page);
		//��ÿҳ������
		request.setAttribute("products", products);
		//totalPage��¼��ҳ��
		int totalPage=0;
		//totalCount��¼�ܼ�¼��
		int totalCount=0;
		//��ѯ���е���Ʒ������
		/*List<Product> products2=productService.sellectAll();*/
		int count=productService.selectCount();
		//�����ݴ�С�����ж�
		if(count!=0){
			//�ܼ�¼��
			totalCount=count;
			System.out.println("�ܼ�¼��:"+totalCount);
			//��ҳ��
			totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
			System.out.println("��ҳ��:"+totalPage);
			//���ܼ�¼��
			request.getSession().setAttribute("totalCount", totalCount);
			//����ҳ��
		    request.getSession().setAttribute("totalPage", totalPage);
		}else{
			//���ܼ�¼��
			request.getSession().setAttribute("totalCount", 0);
			//����ҳ��
		    request.getSession().setAttribute("totalPage", 0);
		}
		//ת��
		request.getRequestDispatcher("index-nn.jsp").forward(request, response);
	}

}
