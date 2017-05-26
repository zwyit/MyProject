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
		//������������
		request.setCharacterEncoding("utf-8");
		//�ռ��վ�
		//��ȡid
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:"+id);
		//��ȡ�˵����
		String code = request.getParameter("billNum");
		//��ȡ���׽��
		Double money = Double.valueOf(request.getParameter("money"));		
		//��ȡ��Ʒ����
		String productDesc = request.getParameter("discription");		
		//��ȡ����״̬
		Integer payStatus = Integer.parseInt(request.getParameter("isPay")); 
		
		Bill bill = new Bill();
		bill.setId(id);
		bill.setCode(code);
		bill.setMoney(money);
		bill.setProductDesc(productDesc);
		bill.setPayStatus(payStatus);

				
		//����service���޸ķ���
		billService.update(bill);
		//ת��
		request.getRequestDispatcher("QueryBillListServlet?page=1").forward(request, response);
		
	}

}
