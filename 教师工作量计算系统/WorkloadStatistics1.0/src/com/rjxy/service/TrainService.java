package com.rjxy.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.rjxy.domain.ClassTable;
import com.rjxy.domain.Equation;
import com.rjxy.mybatis.SqlUtil;

public class TrainService {
	//获取课程表中的信息，数据回填到前端
	public void classTable1(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<ClassTable> classTables = sqlUtil.selectAllClassTable();
		HashMap<Integer, String> hobbys = new HashMap<Integer, String>();
		for (ClassTable classTable : classTables) {
			hobbys.put(Integer.parseInt(classTable.getClasss()), classTable.getClasss());
		}
		model.addAttribute("classStartMap", hobbys);
	}
	public void classTable2(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<ClassTable> classTables = sqlUtil.selectAllClassTable();
		HashMap<Integer, String> hobbys = new HashMap<Integer, String>();
		for (ClassTable classTable : classTables) {
			hobbys.put(Integer.parseInt(classTable.getClasss()), classTable.getClasss());
		}
		model.addAttribute("classFinishMap", hobbys);
	}
	public void equation(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<Equation> equations = sqlUtil.selectAllEquation();
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (Equation equation : equations) {
			hobbys.put(equation.getNumberA(), equation.getType());
		}
		model.addAttribute("typeMap", hobbys);
	}
}
