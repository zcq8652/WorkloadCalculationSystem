package com.rjxy.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
import com.rjxy.service.CheckService;

@Controller
@RequestMapping("/check")
public class CheckController {
	@RequestMapping("/A")
	public void aCheckController(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//���ñ��������ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//����������Ϣ
		CheckService checkService = new CheckService();
		String string = checkService.checkService();
		//��Ӧ������Ϣ
		resp.getWriter().write(string);
	}
	@RequestMapping("/B")
	public void bCheckController(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//���ñ��������ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ϣ
		String uid = req.getParameter("uid");
		uid = new String(uid.getBytes("ISO-8859-1"), "UTF-8");
		String status = req.getParameter("status");
		status = new String(status.getBytes("ISO-8859-1"), "UTF-8");
		String information = URLDecoder.decode(req.getParameter("information"), "UTF-8");
		//information = new String(information.getBytes("ISO-8859-1"), "UTF-8");
		//����������Ϣ
		//������ݵ��洢�м���
		User user = new User();
		user.setUid(uid);
		user.setStatus(status);
		user.setInformation(information);
		//�޸ĵ�ǰ�û��������
		SqlUtil sqlUtil = new SqlUtil();
		sqlUtil.updateUserStatus(user);
		//������һλ�������Ա���������ݵ�ǰ��
		CheckService checkService = new CheckService();
		String string = checkService.checkService();
		//��Ӧ������Ϣ
		resp.getWriter().write(string);
	}
}
