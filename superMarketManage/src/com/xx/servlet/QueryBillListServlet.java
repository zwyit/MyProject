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
		//设置页面大小
		int rows=2;
		System.out.println(rows);
		//获取页
		int page=Integer.parseInt(request.getParameter("page"));
		System.out.println(page);
		//调用service的查询方法  查询每页的数据
		List<Bill> bills=billService.selectBillForPage(page, rows);
		//存数据
		request.setAttribute("bills", bills);
		//存page
		request.setAttribute("page", page);
		//totalPage总页数
		//tatalPage = totalCount%rows==0?totalCount/rows:totalCount/rows+1;
		//totalPage记录总页数
		int totalPage=0;
		//totalCount记录总记录数
		int totalCount=0;
		//调用service的查询方法  查询账单信息
		List<Bill> bills2=billService.selectAll();
		//判断数据大小
		if(null!=bills2&&bills2.size()>0){
			//获取总记录数
			totalCount=bills2.size();
			//计算总页数
			totalPage=totalCount%rows==0?totalCount/rows:totalCount/rows+1;
			//存总记录数
			request.getSession().setAttribute("totalCount", totalCount);
			//存总页数
		    request.getSession().setAttribute("totalPage", totalPage);
		}else{
			//存总记录数
		    request.getSession().setAttribute("totalCount",0);
		    //存总页数
		    request.getSession().setAttribute("totalPage", 0);
		}
		
	   request.getRequestDispatcher("admin_bill_list.jsp").forward(request, response);	
	}
}
