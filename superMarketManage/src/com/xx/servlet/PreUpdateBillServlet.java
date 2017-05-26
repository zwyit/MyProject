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
 * Servlet implementation class PreUpdateBillServlet
 */
public class PreUpdateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BillService billService = new BillServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreUpdateBillServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		 
		Integer id = Integer.parseInt(request.getParameter("id"));
		Bill bill =  billService.selectOne(id);
		request.setAttribute("bill", bill);
		
		request.getRequestDispatcher("modify_bill.jsp").forward(request, response);
	}

}
