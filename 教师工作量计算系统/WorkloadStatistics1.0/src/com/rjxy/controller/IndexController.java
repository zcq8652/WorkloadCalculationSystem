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
		//判断当前浏览器是否存在登陆用户，存在用户则不予登陆
		if(req.getSession().getAttribute("user")!=null) {
			req.getSession().setAttribute("option", "1");
			return "redirect:/index.jsp";
		}
		//处理请求信息
			//创建Cookie服务对象
			CookieServlet cookieServlet = new CookieServlet();
			//校验Cookie是否存在，Cookie存储用户是否存在
			boolean option = cookieServlet.getCookie(req);
		//响应处理结果
		if(option) {
			//判断该用户是否已经在线
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			ServletContext servletContext = req.getServletContext();
			String judge = (String) servletContext.getAttribute(user.getUid());
			if (judge==null) {
				//添加用户上线信息到ServletContext
				servletContext.setAttribute(user.getUid(), user.getUid());
				//添加用户信息
				User user2 = (User) req.getSession().getAttribute("user");
				req.getSession().setAttribute("permissions", user2.getPermissions());
				//重定向
				return "redirect:toMain";
			}else {
				//用户存在但是已登陆
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
