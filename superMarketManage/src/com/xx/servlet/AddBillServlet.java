package com.xx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xx.entity.Bill;
import com.xx.service.BillService;
import com.xx.service.impl.BillServiceImpl;
import com.xx.util.DAOFactory;

/**
 * Servlet implementation class AddBillServlet
 */
public class AddBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BillService billService=new BillServiceImpl();
    
    public AddBillServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//转换编码格式
		request.setCharacterEncoding("utf-8");
		//获取数据
		//账单编号
		String code=request.getParameter("billNum");
		//交易金额
		Double money=Double.valueOf(request.getParameter("money"));
		//商品描述
		String productDesc=request.getParameter("discription");
		//是否付款
		Integer payStatus=Integer.parseInt(request.getParameter("isPay"));
		
		//创建bill对象
		Bill bill=new Bill();
		bill.setCode(code);
		bill.setMoney(money);
		bill.setProductDesc(productDesc);
		bill.setPayStatus(payStatus);
		//请求服务
		billService.save(bill);
		//请求跳转到QueryBillListServlet
		request.getRequestDispatcher("QueryBillListServlet?page=1").forward(request, response);
	}

}
