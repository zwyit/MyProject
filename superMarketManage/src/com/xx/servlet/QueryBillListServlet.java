package com.xx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xx.dao.BillDAO;
import com.xx.dao.impl.BillDAOImpl;
import com.xx.entity.Bill;
import com.xx.service.BillService;
import com.xx.service.impl.BillServiceImpl;


public class QueryBillListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillService billService = new BillServiceImpl();
       
    public QueryBillListServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ҳ���С
		int rows=2;
		System.out.println(rows);
		//��ȡҳ
		int page=Integer.parseInt(request.getParameter("page"));
		System.out.println(page);
		//����service�Ĳ�ѯ����  ��ѯÿҳ������
		List<Bill> bills=billService.selectBillForPage(page, rows);
		//������
		request.setAttribute("bills", bills);
		//��page
		request.setAttribute("page", page);
		//totalPage��ҳ��
		//tatalPage = totalCount%rows==0?totalCount/rows:totalCount/rows+1;
		//totalPage��¼��ҳ��
		int totalPage=0;
		//totalCount��¼�ܼ�¼��
		int totalCount=0;
		//����service�Ĳ�ѯ����  ��ѯ�˵���Ϣ
		List<Bill> bills2=billService.selectAll();
		//�ж����ݴ�С
		if(null!=bills2&&bills2.size()>0){
			//��ȡ�ܼ�¼��
			totalCount=bills2.size();
			//������ҳ��
			totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
			//���ܼ�¼��
			request.getSession().setAttribute("totalCount", totalCount);
			//����ҳ��
		    request.getSession().setAttribute("totalPage", totalPage);
		}else{
			//���ܼ�¼��
		    request.getSession().setAttribute("totalCount",0);
		    //����ҳ��
		    request.getSession().setAttribute("totalPage", 0);
		}
		
	   request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);	
	}
}
