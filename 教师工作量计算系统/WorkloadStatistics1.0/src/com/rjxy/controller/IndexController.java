package com.rjxy.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.User;
import com.rjxy.servlet.CookieServlet;

@Controller
@RequestMapping("/Index")
public class IndexController {
	@RequestMapping("/login")
	public String loginController(HttpServletRequest req) throws IOException {
		//�жϵ�ǰ������Ƿ���ڵ�½�û��������û������½
		if(req.getSession().getAttribute("user")!=null) {
			req.getSession().setAttribute("option", "1");
			return "redirect:/index.jsp";
		}
		//����������Ϣ
			//����Cookie�������
			CookieServlet cookieServlet = new CookieServlet();
			//У��Cookie�Ƿ���ڣ�Cookie�洢�û��Ƿ����
			boolean option = cookieServlet.getCookie(req);
		//��Ӧ������
		if(option) {
			//�жϸ��û��Ƿ��Ѿ�����
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			ServletContext servletContext = req.getServletContext();
			String judge = (String) servletContext.getAttribute(user.getUid());
			if (judge==null) {
				//����û�������Ϣ��ServletContext
				servletContext.setAttribute(user.getUid(), user.getUid());
				//����û���Ϣ
				User user2 = (User) req.getSession().getAttribute("user");
				req.getSession().setAttribute("permissions", user2.getPermissions());
				//�ض���
				return "redirect:toMain";
			}else {
				//�û����ڵ����ѵ�½
				req.setAttribute("option", "1");
				return "login";
			}
		}
		return "login";
	}
	@RequestMapping("/toMain")
	public String toMainController() {
		return "main";
	}

}
