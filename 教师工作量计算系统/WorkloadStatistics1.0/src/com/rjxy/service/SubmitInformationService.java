package com.rjxy.service;

import java.io.IOException;
import java.util.List;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.springframework.ui.Model;

import com.rjxy.mybatis.SqlUtil;

public class SubmitInformationService {
	//��̬�����ʦ�����������ֶ�̬
	public void SubSelectService(Model model) throws IOException {
		//�������ݿ�����
		SqlUtil sqlUtil = new SqlUtil();
		model.addAttribute("check", sqlUtil.selectCountAllStatus("1_2"));
		model.addAttribute("update", sqlUtil.selectCountAllStatus("2_2"));
		model.addAttribute("pass", sqlUtil.selectCountAllStatus("3_2"));
		model.addAttribute("submit", sqlUtil.selectCountAllStatus("0"));
		model.addAttribute("pass_1", sqlUtil.selectCountAllStatus("1_1")+sqlUtil.selectCountAllStatus("2_1"));
	}
	//��ȡ��ǰ״̬��ʦ��name�������ַ�������ǰ��
	public String SubSelectNameService(String status) throws IOException {
		//�������ݿ�����
		SqlUtil sqlUtil = new SqlUtil();
		//�����ַ���
		String strings = "";
		if(status.equals("1")) {
			//��ȡ��ʦname
			List<String> nameList1 = sqlUtil.selectAllName("1_1");
			for (String string : nameList1) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
			List<String> nameList2 = sqlUtil.selectAllName("2_1");
			for (String string : nameList2) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}else {
			//��ȡ��ʦname
			List<String> nameList = sqlUtil.selectAllName(status);
			for (String string : nameList) {
				strings+="<span style=\"margin:10px 10px 10px 20px;color: orange\">"+string+"</span>";
			}
		}
		return strings;
	}
}
