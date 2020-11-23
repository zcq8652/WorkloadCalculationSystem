package com.rjxy.service;

import java.io.IOException;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.springframework.ui.Model;

import com.rjxy.mybatis.SqlUtil;

public class SubmitInformationService {
	//动态回填教师工作量的四种动态
	public void SubSelectService(Model model) throws IOException {
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		model.addAttribute("check", sqlUtil.selectCountAllStatus("1_2"));
		model.addAttribute("update", sqlUtil.selectCountAllStatus("2_2"));
		model.addAttribute("pass", sqlUtil.selectCountAllStatus("3_2"));
		model.addAttribute("submit", sqlUtil.selectCountAllStatus("0"));
		model.addAttribute("pass_1", sqlUtil.selectCountAllStatus("1_1")+sqlUtil.selectCountAllStatus("2_1"));
	}
	//获取当前状态教师的name，整合字符串回填前端
	public String SubSelectNameService(String status) throws IOException {
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//整合字符串
		String strings = "";
		if(status.equals("1")) {
			//获取教师name
			List<String> nameList1 = sqlUtil.selectAllName("1_1");
			for (String string : nameList1) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
			List<String> nameList2 = sqlUtil.selectAllName("2_1");
			for (String string : nameList2) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}else {
			//获取教师name
			List<String> nameList = sqlUtil.selectAllName(status);
			for (String string : nameList) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}
		return strings;
	}
}
