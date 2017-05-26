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

/**
 * Servlet implementation class DeleteBillServlet
 */
public class DeleteBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillService billService=new BillServiceImpl();
    public DeleteBillServlet() {
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
		//获取删除的ID
		Integer id=Integer.parseInt(request.getParameter("id"));
		//创建对象
		Bill bill=new Bill();
		bill.setId(id);
		billService.delete(bill);
		request.getRequestDispatcher("QueryBillListServlet?page=id").forward(request, response);
	}

}
