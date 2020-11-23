package com.rjxy.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.rjxy.domain.ClassTable;
import com.rjxy.domain.CourseTable;
import com.rjxy.domain.Equation;
import com.rjxy.mybatis.SqlUtil;

public class OrdinaryCourseService {
	//获取课程表中的信息，数据回填到前端
	public void courseTable(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<CourseTable> courseTables = sqlUtil.selectAllCourseTable();
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (CourseTable courseTable : courseTables) {
			hobbys.put(courseTable.getCourseID(), courseTable.getCourse());
		}
		model.addAttribute("courseMap", hobbys);
	}
	public void classTable1(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<ClassTable> classTables = sqlUtil.selectGradeAllClassTable("一");
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (ClassTable classTable : classTables) {
			hobbys.put(classTable.getClasss(), classTable.getClasss());
		}
		model.addAttribute("class1", hobbys);
	}
	public void classTable2(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<ClassTable> classTables = sqlUtil.selectGradeAllClassTable("二");
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (ClassTable classTable : classTables) {
			hobbys.put(classTable.getClasss(), classTable.getClasss());
		}
		model.addAttribute("class2", hobbys);
	}
	public void classTable3(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<ClassTable> classTables = sqlUtil.selectGradeAllClassTable("三");
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (ClassTable classTable : classTables) {
			hobbys.put(classTable.getClasss(), classTable.getClasss());
		}
		model.addAttribute("class3", hobbys);
	}
	public void classTable4(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<ClassTable> classTables = sqlUtil.selectGradeAllClassTable("四");
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (ClassTable classTable : classTables) {
			hobbys.put(classTable.getClasss(), classTable.getClasss());
		}
		model.addAttribute("class4", hobbys);
	}
	public void equation(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<Equation> equations = sqlUtil.selectAllEquation();
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (Equation equation : equations) {
			hobbys.put(equation.getNumberA(), equation.getType());
		}
		model.addAttribute("equation", hobbys);
	}
}
