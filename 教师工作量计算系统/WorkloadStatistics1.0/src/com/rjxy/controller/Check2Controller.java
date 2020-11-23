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
		//���ñ��������ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ����˹������Ľ�ʦ�ı�׼
		User user1 = (User) req.getSession().getAttribute("user");
		User user = new User();
		user.setMajor(user1.getMajor());
		user.setStatus("1_1");
		//����������Ϣ
		Check2Service check2Service = new Check2Service();
		String string = check2Service.checkService(user);
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
		//��ȡ����˹������Ľ�ʦ�ı�׼
		User user1 = (User) req.getSession().getAttribute("user");
		User user2 = new User();
		user2.setMajor(user1.getMajor());
		user2.setStatus("1_1");
		//������һλ�������Ա���������ݵ�ǰ��
		Check2Service check2Service = new Check2Service();
		String string = check2Service.checkService(user2);
		//��Ӧ������Ϣ
		resp.getWriter().write(string);
	}
}
