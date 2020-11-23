package com.rjxy.servlet;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
/**
 * Cookie
 * 		����˷��͵Ĳ�ͬ��������ݹ�������
 * 		ʹ�ã�
 * 			����Cookie����
 * 			����Cookie(��ѡ)
 * 			��ӦCookie��Ϣ���ͻ���
 * 		ע�⣺
 *			һ��Cookie����洢һ������
 *		�ص㣺
 *			����������ݴ洢����
 *			�洢�������ڷ�������
 *			��ʱ�洢��������رռ�ʧЧ
 *			��ʱ�洢��������Cookie����Ч�ڣ��洢��Ӳ����
 *			Ĭ��Cookie��Ϣ�洢��֮��ÿ�����󶼻ḽ��������������Ч·��
 *		��ȡ��
 *			��ȡCookie��Ϣ����
 *			���������ȡCookie��Ϣ
 * @author eryue
 *
 */
public class CookieServlet {
	public void setCookie(HttpServletRequest req,HttpServletResponse resp,String name,String value,int time,String path) {
		//����Cookie����
		Cookie c = new Cookie(name,value);
		//����Cookie
			//������Чʱ��
			c.setMaxAge(time);
			//������Ч·��
			c.setPath(req.getContextPath());
		//��ӦCookie��Ϣ���ͻ���
		resp.addCookie(c);
	}
	public boolean getCookie(HttpServletRequest req) throws IOException {
		//��ȡCookil��Ϣ
		Cookie[] c = req.getCookies();
		//����Cookil��Ϣ
		if(c!=null) {
			String uid="";
			//����Cookil��Ϣ
			for(Cookie ck:c) {
				if("uid".equals(ck.getName())) {
					uid=ck.getValue();
				}
			}
			//У��UID�Ƿ����
			if("".equals(uid)) {
				return false;
			}else {
				//У��UID�û���Ϣ
				SqlUtil sql = new SqlUtil();
				User user = sql.select_uid(uid);
				if(user!=null) {
					//һ���û���ͬ�������ݹ���(session)
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;	
	}
	
}
