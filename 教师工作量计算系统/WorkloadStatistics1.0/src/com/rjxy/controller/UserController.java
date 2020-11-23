package com.rjxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.Direction;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/add")
	public String add(User user,Model model,HttpServletRequest req) throws Exception {
		SqlUtil sql = new SqlUtil();
		user.setPassword("123456");
		user.setStatus("0");
		String duty = user.getPermissions();
		user.setDuty(duty.substring(duty.length()-2, duty.length()));
		sql.insertUser(user);
		List<Direction> list = sql.selectAllDirection();
		List<String> str = new ArrayList<String>();
		for(Direction dir:list){
			str.add(dir.getName());
		}
		model.addAttribute("path","register.jsp");
		model.addAttribute("user",new User());
		req.setAttribute("list", str);
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(User user,Model model,HttpServletRequest req) throws IOException {
		SqlUtil sql = new SqlUtil();
		String duty = user.getPermissions();
		user.setDuty(duty.substring(duty.length()-2, duty.length()));
		sql.updateUserPermissions(user);		
		//获取现有用户
		List<User> users = sql.selectAllUser();
		model.addAttribute("path","updateUser.jsp");
		req.setAttribute("users", users);
		return "main";
	}
	
	@RequestMapping("/reset")
	public String reset(User user,Model model,HttpServletRequest req) throws IOException {
		SqlUtil sql = new SqlUtil();
		user.setPassword("123456");
		sql.updateUserPassword(user);		
		//获取现有用户
		List<User> users = sql.selectAllUser();
		model.addAttribute("path","resetPassword.jsp");
		req.setAttribute("users", users);
		return "main";
	}
	
	
	

}
