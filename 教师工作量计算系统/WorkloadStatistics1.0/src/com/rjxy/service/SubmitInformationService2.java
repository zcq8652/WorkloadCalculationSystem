package com.rjxy.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.springframework.ui.Model;

import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class SubmitInformationService2 {
	//��̬�����ʦ�����������ֶ�̬
	public void SubSelectService(Model model,HttpServletRequest req) throws IOException {
		//�������ݿ�����
		SqlUtil sqlUtil = new SqlUtil();
		//��ȡ��ǰ�û��ķ���
		User user = (User) req.getSession().getAttribute("user");
		model.addAttribute("check", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"1_1")));
		model.addAttribute("update", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"2_1")));
		model.addAttribute("pass_1", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"1_2"))+sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"2_2")));
		model.addAttribute("submit", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"0")));
		model.addAttribute("pass", sqlUtil.selectCountAllStatusDirection(new User(user.getMajor(),"3_2")));
	}
	//��ȡ��ǰ״̬��ʦ��name�������ַ�������ǰ��
	public String SubSelectNameService(String status,HttpServletRequest req) throws IOException {
		//�������ݿ�����
		SqlUtil sqlUtil = new SqlUtil();
		//��ȡ��ǰ�û��ķ���
		User user = (User) req.getSession().getAttribute("user");
		//�����ַ���
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
			//��ȡ��ʦname
			List<String> nameList = sqlUtil.selectAllNameDirection(new User(user.getMajor(),status));
			for (String string : nameList) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}
		return strings;
	}
}
