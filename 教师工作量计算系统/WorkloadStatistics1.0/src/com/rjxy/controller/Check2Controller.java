package com.rjxy.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
import com.rjxy.service.Check2Service;

@Controller
@RequestMapping("/check2")
public class Check2Controller {
	@RequestMapping("/A")
	public void aCheckController(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//设置编码请求格式
		req.setCharacterEncoding("utf-8");
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//提取需审核工作量的教师的标准
		User user1 = (User) req.getSession().getAttribute("user");
		User user = new User();
		user.setMajor(user1.getMajor());
		user.setStatus("1_1");
		//处理请求信息
		Check2Service check2Service = new Check2Service();
		String string = check2Service.checkService(user);
		//响应处理信息
		resp.getWriter().write(string);
	}
	@RequestMapping("/B")
	public void bCheckController(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//设置编码请求格式
		req.setCharacterEncoding("utf-8");
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取信息
		String uid = req.getParameter("uid");
		uid = new String(uid.getBytes("ISO-8859-1"), "UTF-8");
		String status = req.getParameter("status");
		status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
		String information = URLDecoder.decode(req.getParameter("information"), "UTF-8");
		//information = new String(information.getBytes("ISO-8859-1"), "UTF-8");
		//处理请求信息
		//添加数据到存储中间类
		User user = new User();
		user.setUid(uid);
		user.setStatus(status);
		user.setInformation(information);
		//修改当前用户审核数据
		SqlUtil sqlUtil = new SqlUtil();
		sqlUtil.updateUserStatus(user);
		//提取需审核工作量的教师的标准
		User user1 = (User) req.getSession().getAttribute("user");
		User user2 = new User();
		user2.setMajor(user1.getMajor());
		user2.setStatus("1_1");
		//查找下一位待审核人员，返还数据到前端
		Check2Service check2Service = new Check2Service();
		String string = check2Service.checkService(user2);
		//响应处理信息
		resp.getWriter().write(string);
	}
}
