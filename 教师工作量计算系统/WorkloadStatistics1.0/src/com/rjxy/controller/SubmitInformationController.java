package com.rjxy.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.service.CheckService;
import com.rjxy.service.SubmitInformationService;
import com.rjxy.service.SubmitInformationService2;

@Controller
@RequestMapping("/submit")
public class SubmitInformationController {
	@RequestMapping("/A")
	public void aSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//设置编码请求格式
		req.setCharacterEncoding("utf-8");
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取信息
		String status = req.getParameter("status");
		status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
		//处理请求信息
		SubmitInformationService submitInformationService = new SubmitInformationService();
		String string = submitInformationService.SubSelectNameService(status);
		//响应处理信息
		resp.getWriter().write(string);
	}
	@RequestMapping("/B")
	public void bSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//设置编码请求格式
		req.setCharacterEncoding("utf-8");
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取信息
		String status = req.getParameter("status");
		status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
		//处理请求信息
		SubmitInformationService2 submitInformationService = new SubmitInformationService2();
		String string = submitInformationService.SubSelectNameService(status,req);
		//响应处理信息
		resp.getWriter().write(string);
	}
}
