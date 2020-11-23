package com.rjxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 类Servlet功能，用户可通过URL直接进入登陆界面
 * 		示例：
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
