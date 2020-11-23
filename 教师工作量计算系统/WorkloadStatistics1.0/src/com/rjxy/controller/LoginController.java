package com.rjxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.rjxy.domain.Direction;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
import com.rjxy.service.DirectionService;
import com.rjxy.service.LoginService;
import com.rjxy.service.SubmitInformationService;
import com.rjxy.servlet.CookieServlet;


@Controller
@RequestMapping("/Login")
public class LoginController {
	@RequestMapping("/main")
	public String mainController(User user,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
		//处理请求信息判断该用户是否存在
		LoginService loginService = new LoginService();
		boolean option = loginService.loginService(user, req);
		//响应处理结果
		if(option) {
			//判断该用户是否已经在线
			ServletContext servletContext = req.getServletContext();
			String judge = (String) servletContext.getAttribute(user.getUid());
			//用户存在且未登陆
			if (judge==null) {
				//判断用户是否选择自动登陆
				if(user.getOption()!=null) {
					//自动登陆，创建Cookie保存用户信息
					CookieServlet cookieServlet = new CookieServlet();
					cookieServlet.setCookie(req,resp, "uid", user.getUid(), 3*24*3600,"Index/login");
				}
				//添加用户上线信息到ServletContext
				servletContext.setAttribute(user.getUid(), user.getUid());
				//添加用户信息
				User user2 = (User) req.getSession().getAttribute("user");
				req.getSession().setAttribute("permissions", user2.getPermissions());
				//创建网站计数器
					//获取计数器数据
//					ServletContext servletContext = req.getSession().getServletContext();
//					if(servletContext.getAttribute("nums")!=null) {
//						int nums = (int) servletContext.getAttribute("nums");
//						nums+=1;
//						servletContext.setAttribute("nums", nums);
//					}else {
//						servletContext.setAttribute("nums", 1);
//					}
				//重定向
				return "redirect:toMain";
			}else {
				//用户存在但是已登陆
				req.setAttribute("option", "1");
				return "login";
			}

		}else {
			return "login";
		}
	}
	@RequestMapping("/toMain")
	public String toMainController(Model model,HttpServletRequest req) throws IOException {
		User user = (User)req.getSession().getAttribute("user");
		req.setAttribute("user", user);
		model.addAttribute("path", "Initial.jsp");
		return "main";
	}
	@RequestMapping("/exit")
	public String Exit(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:toLogin";
	}
	@RequestMapping("/toLogin")
	public String toLoginController() {
		return "login";
	}
	
	@RequestMapping("/getDirection")
	public void getDirection(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		DirectionService directionService = new DirectionService();
		User user = (User)request.getSession().getAttribute("user");
		List<Direction> dirList = directionService.getDirList(user);
		String root = JSONObject.toJSONString(dirList);
		out.print(root);
	}
	
}