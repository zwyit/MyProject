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
		//ת�������ʽ
		request.setCharacterEncoding("utf-8");
		//��ȡ����
		//�˵����
		String code=request.getParameter("billNum");
		//���׽��
		Double money=Double.valueOf(request.getParameter("money"));
		//��Ʒ����
		String productDesc=request.getParameter("discription");
		//�Ƿ񸶿�
		Integer payStatus=Integer.parseInt(request.getParameter("isPay"));
		
		//����bill����
		Bill bill=new Bill();
		bill.setCode(code);
		bill.setMoney(money);
		bill.setProductDesc(productDesc);
		bill.setPayStatus(payStatus);
		//�������
		billService.save(bill);
		//������ת��QueryBillListServlet
		request.getRequestDispatcher("QueryBillListServlet?page=1").forward(request, response);
	}

}
