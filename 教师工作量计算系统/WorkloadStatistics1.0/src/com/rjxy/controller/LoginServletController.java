package com.rjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ��Servlet���ܣ��û���ͨ��URLֱ�ӽ����½����
 * 		ʾ����
 * 			localhost:8080/StudentsManage/login
 * @author er'yue
 *
 */

@Controller
@RequestMapping("/")
public class LoginServletController {
	@RequestMapping("/login")
	public String longin_login() {
		return "login";
	}
}
