package com.xingxue.www.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {
	//声明字符集变量encode,赋值null
	private String encode = null;

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
//        System.out.println("调用了构造方法");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//进行乱码处理
		request.setCharacterEncoding(encode);
		response.setContentType("text/html;charset="+encode);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		    encode  = fConfig.getInitParameter("encode");
		    
//		    System.out.println("init...");
		
	}

}
