package com.rjxy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
/**
 * ����:
 * 		1.��ȡǰ��Ajax�첽��������
 * 		2.���ʺ�����ݿ�
 * 		3.У��������Ϣ
 * 		4.HttpSession�������ݿⷵ�ص���ȷ��Ϣ���û������½ʱУ��������Ϣֱ�Ӵ�HttpSession�л�ȡ������һ�ζ����ݿ�ķ���
 * 		5.��Ӧ������
 * @author eryue
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ñ��������ʽ
		req.setCharacterEncoding("utf-8");
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//��ȡ��Ϣ
		String uid = req.getParameter("uid");
		uid = new String(uid.getBytes("ISO-8859-1"), "UTF-8");
		//����������Ϣ
		SqlUtil sql = new SqlUtil();
		User user = sql.select_uid(uid);
		//��Ӧ������Ϣ
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.getWriter().write("{message:'YES'}");
		}else{
			resp.getWriter().write("{message:'NO'}");
		}
	}
}
