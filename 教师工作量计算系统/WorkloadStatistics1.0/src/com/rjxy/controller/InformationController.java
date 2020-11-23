package com.rjxy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.Count;
import com.rjxy.domain.User;
import com.rjxy.service.InformationService;

@Controller
@RequestMapping("/Information")
public class InformationController {
	@RequestMapping("/A")
	public String passwordUpdate(User user,Model model,HttpServletRequest req) throws IOException {
		//获取当前用户信息
		User user2 = (User) req.getSession().getAttribute("user");
		InformationService informationService = new InformationService();
		int option = informationService.passwordService(user,user2);
		//判断是否修改成功，成功则重定向到登陆界面，失败返回提示失败
		if (option==1) {
			req.getSession().invalidate();
			return "redirect:toLogin";
		}else {
			//前端跳转信息
			model.addAttribute("path","information.jsp");
			req.setAttribute("option",option);
			return "main";
		}
	}
	@RequestMapping("/toLogin")
	public String toLoginController() {
		return "login";
	}
}
