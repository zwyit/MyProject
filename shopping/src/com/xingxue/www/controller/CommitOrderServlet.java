package com.xingxue.www.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xingxue.www.entity.Cart;
import com.xingxue.www.entity.Order;
import com.xingxue.www.entity.OrderDetail;
import com.xingxue.www.entity.User;
import com.xingxue.www.service.CartService;
import com.xingxue.www.service.OrderService;
import com.xingxue.www.service.UserService;
import com.xingxue.www.service.imp.CartServiceImpl;
import com.xingxue.www.service.imp.OrderServiceImpl;
import com.xingxue.www.service.imp.UserServiceImpl;

/**
 * Servlet implementation class CommitOrderServlet
 */
public class CommitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CartService cartService=new CartServiceImpl();
    private UserService userService=new UserServiceImpl();
    private OrderService orderService=new OrderServiceImpl();
    
    
    public CommitOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户名
		String name=(String)request.getSession().getAttribute("username");
		User user=userService.selectOne(name);
		if(user==null){
			response.sendRedirect("login.jsp");
		}else{
			//封装订单对象
			Order order=new Order();
			//先查处购物记录，根据购物激励计算总金额
			List<Cart> list=cartService.selectAll(user.getId());
			double totalPrice=0;
			for(Cart cart:list){
				totalPrice=totalPrice+cart.getProduct().getPrice()*cart.getNum();
			}
			//地址 写死
			int addr_id=1;
			int status=1;//1.代付款 2.付款 3 .过期
			Date order_date=new Date();
			order.setAddr_id(addr_id);
			order.setOrder_date(order_date);
			order.setStatus(status);
			order.setTotal(totalPrice);
			order.setUser_id(user.getId());
			//封装订单明细集合
			List<OrderDetail> olist=new ArrayList<OrderDetail>();
			for(Cart cart:list){
				OrderDetail orderDetail=new OrderDetail(order.getId(),cart.getProduct_id(),cart.getProduct().getName(),cart.getProduct().getPrice(),cart.getNum());
				olist.add(orderDetail);
			}
			//封装后传给service
			orderService.order(order, olist);
			//运用session对订单信息进行存储
			request.getSession().setAttribute("order", order);
			request.getSession().setAttribute("olist", olist);
			//查看订单
			response.sendRedirect("QueryOrderListServlet");
		}
	}

}
