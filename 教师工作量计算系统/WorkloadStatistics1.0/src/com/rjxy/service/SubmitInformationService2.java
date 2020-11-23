package com.rjxy.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.springframework.ui.Model;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class SubmitInformationService2 {
	//动态回填教师工作量的四种动态
	public void SubSelectService(Model model,HttpServletRequest req) throws IOException {
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//获取当前用户的方向
		User user = (User) req.getSession().getAttribute("user");
		model.addAttribute("check", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"1_1")));
		model.addAttribute("update", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"2_1")));
		model.addAttribute("pass_1", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"1_2"))+sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"2_2")));
		model.addAttribute("submit", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"0")));
		model.addAttribute("pass", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"3_2")));
	}
	//获取当前状态教师的name，整合字符串回填前端
	public String SubSelectNameService(String status,HttpServletRequest req) throws IOException {
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//获取当前用户的方向
		User user = (User) req.getSession().getAttribute("user");
		//整合字符串
		String strings = "";
		if(status.equals("2")) {
			List<String> nameList1 = sqlUtil.selectAllNameDirection(new User(user.getMajor(),"1_2"));
			for (String string : nameList1) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
			List<String> nameList2 = sqlUtil.selectAllNameDirection(new User(user.getMajor(),"2_2"));
			for (String string : nameList2) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}else {
			//获取教师name
			List<String> nameList = sqlUtil.selectAllNameDirection(new User(user.getMajor(),status));
			for (String string : nameList) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}
		return strings;
	}
}
