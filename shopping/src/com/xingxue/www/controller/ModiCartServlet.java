package com.xingxue.www.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xingxue.www.entity.Cart;
import com.xingxue.www.service.CartService;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.imp.CartServiceImpl;
import com.xingxue.www.service.imp.ProductServiceImpl;

/**
 * Servlet implementation class ModiCartServlet
 */
public class ModiCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService=new CartServiceImpl();
    private ProductService productService=new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModiCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����
		int temp=Integer.parseInt(request.getParameter("lag"));
//		System.out.println("��ӣ�"+temp);
		//��ȡ���ﳵid
		Integer id=Integer.parseInt(request.getParameter("id"));
//		System.out.println("���ﳵid:"+id);
		//��ȡ���ﳵ����
		Cart cart=cartService.selectOne(id);
		//��ȡ�û�id
//		int user_id=cart.getUser_id();
		//��ȡ��Ʒid
		Integer product_id=cart.getProduct_id();
		//��ȡ��Ʒ������count
		Integer count=productService.selectOne(product_id).getCount();
		//���ﳵ����������
		int num=cart.getNum();
		
		if(temp>0){
			if(num+1<=count){
				cart.setNum(cart.getNum()+1);
				cartService.update(cart);
			}
		}else{
			if(num-1>0){
				cart.setNum(cart.getNum()-1);
				cartService.update(cart);
			}else{
				cartService.delete(id);
			}
		}
		request.getRequestDispatcher("QueryCartServlet").forward(request, response);
	}

}
