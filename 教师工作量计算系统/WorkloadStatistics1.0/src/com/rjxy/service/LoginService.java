package com.rjxy.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
/**
 * ���ܣ�
 * 		��ȡǰ���û���½����
 * 		У�������Ƿ���ȷ
 * 		����У����
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
		//�û���½ʱ�Լ������˺�ʱ��������˺Ŵ��ڻ��Զ�����session������session���Լ���һ�ε����ݿ������
		HttpSession session = req.getSession();
		//sessionΪ��˵���û�û�������˺ţ���Ҫ�������ݿ�
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
