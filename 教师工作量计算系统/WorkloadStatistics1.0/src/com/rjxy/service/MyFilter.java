package com.rjxy.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//��ֹҳ�滺��
		/*
		 * HttpServletResponse httpServletResponse = (HttpServletResponse) request;
		 * httpServletResponse.setHeader("Cache-Control",
		 * "no-cache, no-store, must-revalidate");
		 * httpServletResponse.setHeader("Pragma", "no-cache"); httpServletResponse
		 * .setDateHeader("Expires", 0); chain.doFilter(request, response)
		 */;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
