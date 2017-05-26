package com.xingxue.www.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.dao.OrderDetailService;
import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.entity.Product;
import com.xingxue.www.service.OrderDetailServiceImpl;
import com.xingxue.www.service.OrderService;
import com.xingxue.www.service.ProductService;
import com.xingxue.www.service.imp.OrderServiceImpl;
import com.xingxue.www.service.imp.ProductServiceImpl;
import com.xingxue.www.util.DAOFactory;

public class CancleOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrderService orderService=new OrderServiceImpl();
    private OrderDetailService orderDetailService=new OrderDetailServiceImpl();
    private ProductService productService=new ProductServiceImpl();
//    private Or
    
    
    public CancleOrderServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取订单信息
		int id=Integer.parseInt(request.getParameter("id"));
		//获取订单
		Order order=orderService.selectOne(id);
		order.setStatus(0);
		//获取订单详情
		List<OrderDetail> orderDetails=orderDetailService.selectDetails(id);
		//订单中的商品返回库存
		for(OrderDetail o:orderDetails){
			Product product=productService.selectOne(o.getP_id());
			int count=product.getCount()+o.getP_num();
			product.setCount(count);
			productService.update(product);
		}
	}

}
