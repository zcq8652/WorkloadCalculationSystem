package com.rjxy.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


import com.rjxy.domain.User;
public class ListenerServlet implements HttpSessionListener {
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//ServletContext servletContext = se.getSession().getServletContext();
		//User user = (User) se.getSession().getAttribute("user");
		//servletContext.setAttribute(user.getUid(), user.getUid());
		//System.out.println("我被创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		User user = (User) se.getSession().getAttribute("user");
		ServletContext servletContext = se.getSession().getServletContext();
		servletContext.removeAttribute(user.getUid());
		System.out.println("销毁了");
	}

}
