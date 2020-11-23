package com.rjxy.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
/**
 * 功能：
 * 		获取前端用户登陆数据
 * 		校验数据是否正确
 * 		反馈校验结果
 * @author eryue
 *
 */
public class LoginService {
	//public User loginService(User user) throws IOException {
		//SqlUtil sql = new SqlUtil();
		//User login_user = sql.select(user);
		//return login_user;
	//}
	public boolean loginService(User user,HttpServletRequest req) throws IOException {
		//用户登陆时自己输入账号时，如果该账号存在会自动存入session，调用session可以减少一次到数据库的请求
		HttpSession session = req.getSession();
		//session为空说明用户没有输入账号，需要调用数据库
		if(session.getAttribute("user")==null) {
			SqlUtil sql = new SqlUtil();
			User user2 = sql.select(user);
			if(user2!=null) {
				if(user.getPassword().equals(user2.getPassword())) {
					session.setAttribute("user", user2);
					return true;
				}
			}
			return false;
		}
		User users = (User) session.getAttribute("user");
		if(users.getPassword().equals(user.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
}
