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
		//���ñ��������ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ϣ
		String status = req.getParameter("status");
		status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
		//����������Ϣ
		SubmitInformationService submitInformationService = new SubmitInformationService();
		String string = submitInformationService.SubSelectNameService(status);
		//��Ӧ������Ϣ
		resp.getWriter().write(string);
	}
	@RequestMapping("/B")
	public void bSubmit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//���ñ��������ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ϣ
		String status = req.getParameter("status");
		status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
		//����������Ϣ
		SubmitInformationService2 submitInformationService = new SubmitInformationService2();
		String string = submitInformationService.SubSelectNameService(status,req);
		//��Ӧ������Ϣ
		resp.getWriter().write(string);
	}
}
