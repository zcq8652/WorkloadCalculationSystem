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
 * 功能:
 * 		1.获取前端Ajax异步请求数据
 * 		2.访问后端数据库
 * 		3.校验请求信息
 * 		4.HttpSession保存数据库返回的正确信息，用户点击登陆时校验密码信息直接从HttpSession中获取，减少一次对数据库的访问
 * 		5.响应处理结果
 * @author eryue
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码请求格式
		req.setCharacterEncoding("utf-8");
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取信息
		String uid = req.getParameter("uid");
		uid = new String(uid.getBytes("ISO-8859-1"), "UTF-8");
		//处理请求信息
		SqlUtil sql = new SqlUtil();
		User user = sql.select_uid(uid);
		//响应处理信息
		if(user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			resp.getWriter().write("{message:'YES'}");
		}else{
			resp.getWriter().write("{message:'NO'}");
		}
	}
}
