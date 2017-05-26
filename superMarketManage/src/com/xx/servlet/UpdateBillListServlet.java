package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xx.entity.Bill;
import com.xx.service.BillService;
import com.xx.service.impl.BillServiceImpl;

/**
 * Servlet implementation class UpdateBillListServlet
 */
public class UpdateBillListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BillService billService=new BillServiceImpl();
    
    public UpdateBillListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理请求乱码
		request.setCharacterEncoding("utf-8");
		//收集收据
		//获取id
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		//获取账单编号
		String code = request.getParameter("billNum");
		//获取交易金额
		Double money = Double.valueOf(request.getParameter("money"));		
		//获取商品描述
		String productDesc = request.getParameter("discription");		
		//获取付款状态
		Integer payStatus = Integer.parseInt(request.getParameter("isPay")); 
		
		Bill bill = new Bill();
		bill.setId(id);
		bill.setCode(code);
		bill.setMoney(money);
		bill.setProductDesc(productDesc);
		bill.setPayStatus(payStatus);

				
		//调用service的修改方法
		billService.update(bill);
		//转发
		request.getRequestDispatcher("QueryBillListServlet?page=1").forward(request, response);
		
	}

}
