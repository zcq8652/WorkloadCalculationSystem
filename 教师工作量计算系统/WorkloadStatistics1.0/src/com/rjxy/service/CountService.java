package com.rjxy.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.apache.ibatis.jdbc.Null;

import com.rjxy.domain.ClassTable;
import com.rjxy.domain.Count;
import com.rjxy.domain.CourseTable;
import com.rjxy.domain.Equation;
import com.rjxy.domain.OrdinaryCourse;
import com.rjxy.domain.Other;
import com.rjxy.domain.Parameters;
import com.rjxy.domain.PositionTable;
import com.rjxy.domain.Train;
import com.rjxy.mybatis.SqlUtil;
import com.sun.javafx.collections.MappingChange.Map;


public class CountService {
	public void ordinaryCourseCount(OrdinaryCourse ordinaryCourse,Count count) throws IOException {
		//try catch 防止出现空指针
		try {
			System.out.println(ordinaryCourse);
			//创建数据库连接方式
			SqlUtil sqlUtil = new SqlUtil();
			//创建数据库数据接收类
			CourseTable courseTable = new CourseTable();
			Equation equation = new Equation();
			ClassTable classTable = new ClassTable();
			//根据前端数据，从数据库中调用需要用到的数据
			courseTable = sqlUtil.selectCourseTable(ordinaryCourse.getCourse());
			count.setCourse(courseTable.getCourse());
			count.setTotal(courseTable.getTotal());
			count.setReality(courseTable.getReality());
			count.setExperiment(courseTable.getExperiment());
			//通过公式编号获取对应课程课时计算公式
			equation = sqlUtil.selectEquation(ordinaryCourse.getEquation());
			//设置该编号公式对应的课程类型
			count.setCtype(equation.getType());
			//判断班级数，查找对应班级人数，分类计算
			List<String> classs = ordinaryCourse.getClasss();
			//存储班级人数，整合数据（真的好难--------------------受,难受+1）
			//班级人数
			List<Double> npeople1 = new ArrayList();
			for (String string : classs) {
				classTable = sqlUtil.selectClassTable(string);
				npeople1.add(classTable.getNpeople());
			}
			//班级新加人数
			List<Double> npeople2 = new ArrayList();
			if(ordinaryCourse.getNpeople().equals("无")) {
				//整合班级数据，用于运算和存储
				String classString="";
				for(int i=0;i<classs.size();i++) {
					classString+=classs.get(i)+"("+npeople1.get(i)+"人)";
				}
				count.setClasss(classString);
			}else {
				String[] strings = ordinaryCourse.getNpeople().split(",");
				for (String string : strings) {
					npeople2.add(Double.parseDouble(string));
				}
				//整合班级数据，用于运算和存储
				String classString="";
				for(int i=0;i<classs.size();i++) {
					if(npeople2.get(i)!=0) {
						classString+=classs.get(i)+"("+npeople1.get(i)+"人)("+npeople2.get(i)+"人)";
					}else {
						classString+=classs.get(i)+"("+npeople1.get(i)+"人)";
					}
				}
				count.setClasss(classString);
				//加和班级人数和特殊人数
				for (int i = 0; i < npeople1.size(); i++) {
					npeople1.set(i, npeople1.get(i)+npeople2.get(i));
				}
			}
			//将班级人数有大到小排序
			for (int i = 0; i < npeople1.size(); i++) {
				for (int j = i+1; j < npeople1.size()-i; j++) {
					if(npeople1.get(i)<npeople1.get(j)) {
						double d = npeople1.get(i);
						npeople1.set(i, npeople1.get(j));
						npeople1.set(j, d);
					}
				}
			}
			//判断该课程是否有实验课和理论课，分类计算存储
			//计算理论课课时
			if(courseTable.getReality()!=0) {
				//逐一计算各班级对应课时，首班用选择课程类型，后续班级用重复课类型
				for (int i = 0; i < npeople1.size(); i++) {
					if(i==0) {
						//设置班级人数
						count.setNpeople(npeople1.get(i));
						//导入数据到计算类计算结果，存储计算结果和计算过程
						CalculateService calculateService = new CalculateService();
						calculateService.realityService(count, equation);
					}else {
						if(npeople1.get(i)<=40) {
							//设置课程类型
							equation = sqlUtil.selectEquation("A0011");
							//设置班级人数
							count.setNpeople(npeople1.get(i));
							//导入数据到计算类计算结果，存储计算结果和计算过程
							CalculateService calculateService = new CalculateService();
							calculateService.realityService(count, equation);
						}else {
							//设置课程类型为重复班
							equation = sqlUtil.selectEquation("A004");
							//设置班级人数
							count.setNpeople(npeople1.get(i));
							//导入数据到计算类计算结果，存储计算结果和计算过程
							CalculateService calculateService = new CalculateService();
							calculateService.realityService(count, equation);
						}
					} 
				}
			}
			//实验课计算课时
			if (courseTable.getExperiment()!=0) {
				for (int i = 0; i < npeople1.size(); i++) {
					if(npeople1.get(i)<=50) {
						//设置课程类型
						equation = sqlUtil.selectEquation("B0011");
						//设置班级人数
						count.setNpeople(npeople1.get(i));
						//导入数据到计算类计算结果，存储计算结果和计算过程
						CalculateService calculateService = new CalculateService();
						calculateService.experimentService(count, equation);
					}else {
						//设置课程类型
						equation = sqlUtil.selectEquation("B0012");
						//设置班级人数
						count.setNpeople(npeople1.get(i));
						//导入数据到计算类计算结果，存储计算结果和计算过程
						CalculateService calculateService = new CalculateService();
						calculateService.experimentService(count, equation);
					}
				}
			}
			//设置double保留两位小数
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			//保存计算结果
			count.setRealityResult(Double.valueOf(decimalFormat.format(count.getRealityResult())));
			count.setExperimentResult(Double.valueOf(decimalFormat.format(count.getExperimentResult())));
			//整合保存课时数据，以便存储到数据库
			count.setResultString("理论课时("+count.getRealityResult()+"),实验课时("+count.getExperimentResult()+")");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void ordinaryCourseCount_1(OrdinaryCourse ordinaryCourse,Count count) throws IOException {
		try {
			//从头再来,稳住别慌
			//参数接收前端数据(已完成)
			//整合班级数据(难受+2)
				//从数据库中获取所需班级数据
					//建立数据库连接
			System.out.println(ordinaryCourse);
					SqlUtil sqlUtil = new SqlUtil();
					//创建数据库数据接收类
					CourseTable courseTable = new CourseTable();
					Equation equation = new Equation();
					ClassTable classTable = new ClassTable();
					//根据前端数据，从数据库中调用需要用到的数据
					courseTable = sqlUtil.selectCourseTable(ordinaryCourse.getCourse());
					count.setCourse(courseTable.getCourse());
					count.setTotal(courseTable.getTotal());
					count.setReality(courseTable.getReality());
					count.setExperiment(courseTable.getExperiment());
					//通过公式编号获取对应课程课时计算公式
					equation = sqlUtil.selectEquation(ordinaryCourse.getEquation());
					//设置该编号公式对应的课程类型
					count.setCtype(equation.getType());
					//获取对应班级对应人数
					List<Double> npeople = new ArrayList();
					List<String> speople = new ArrayList();
					//特殊List用来存放人数变化时的数据
					List<String> npeople2 = new ArrayList<String>();
					//判断班级人数是否存在变化
					if(ordinaryCourse.getDecide1().equals("1")) {
						//变动人数
						List<Double> npeople1 = new ArrayList<Double>();
						String[] strings1 = ordinaryCourse.getNpeople().split(",");
						for (String string : strings1) {
							npeople1.add(Double.parseDouble(string));
						}
						System.out.println(npeople1);
						//变动班级
						List<String> classs2 = new ArrayList<String>();
						String[] strings2 = ordinaryCourse.getClasss2().split(",");
						for (String string : strings2) {
							classs2.add(string);
						}
						System.out.println(classs2);
						//整合单班班级，遍历中查看是否存在人数变动班级
						for (String string : ordinaryCourse.getClasss()) {
							int a = 0;
							for (int i = 0; i < classs2.size(); i++) {
								if(classs2.get(i).equals(string)) {
									classTable = sqlUtil.selectClassTable(string);
									npeople.add(classTable.getNpeople()+npeople1.get(i));
									npeople2.add("("+String.valueOf(classTable.getNpeople())+"人)(+"+String.valueOf(npeople1.get(i))+")");
									speople.add(classTable.getClasss());
									a = 1;
									break;
								}
							}
							if(a == 0) {
								classTable = sqlUtil.selectClassTable(string);
								npeople.add(classTable.getNpeople());
								npeople2.add("("+String.valueOf(classTable.getNpeople())+"人)");
								speople.add(classTable.getClasss());
							}
						}
						//依此判断各个预备队是否存在数据
						if(ordinaryCourse.getClasses1_0().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses1_0()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}
						if(ordinaryCourse.getClasses1_1().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses1_1()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses1_2().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses1_2()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses1_3().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses1_3()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses2_0().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses2_0()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses2_1().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses2_1()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses2_2().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses2_2()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses2_3().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses2_3()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses3_0().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses3_0()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses3_1().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses3_1()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses3_2().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses3_2()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses3_3().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses3_3()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses4_0().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses4_0()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses4_1().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses4_1()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses4_2().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses4_2()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}						
						if(ordinaryCourse.getClasses4_3().size()!=0) {
							String classs = "";
							double people = 0;
							double npoeple_1 = 0;	
							double npoeple_2 = 0;
							for (String string : ordinaryCourse.getClasses4_3()) {
								int a = 0;
								for (int i = 0; i < classs2.size(); i++) {
									if(classs2.get(i).equals(string)) {
										classTable = sqlUtil.selectClassTable(string);
										classs = classs+classTable.getClasss()+",";
										people += classTable.getNpeople()+npeople1.get(i);
										npoeple_1 += npeople1.get(i);
										npoeple_2 += classTable.getNpeople();
										a = 1;
										break;
									}
								}
								if(a == 0) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
									npoeple_2+=classTable.getNpeople();
								}
							}
							npeople.add(people);
							npeople2.add("("+npoeple_2+"人)(+"+npoeple_1+")");
							speople.add(classs);
						}
					}else {
						//单班人数
						for (String string : ordinaryCourse.getClasss()) {
							classTable = sqlUtil.selectClassTable(string);
							npeople.add(classTable.getNpeople());
							speople.add(classTable.getClasss());
						}
						//合班人数，先判断是否存在合班
						if (true) {
							//依此判断各个预备队是否存在数据
							if(ordinaryCourse.getClasses1_0().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses1_0()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses1_1().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses1_1()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses1_2().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses1_2()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses1_3().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses1_2()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses2_0().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses2_0()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses2_1().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses2_1()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses2_2().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses2_2()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses2_3().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses2_3()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses3_0().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses3_0()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses3_1().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses3_1()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses3_2().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses3_2()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses3_3().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses3_3()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses4_0().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses4_0()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses4_1().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses4_1()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses4_2().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses4_2()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
							if(ordinaryCourse.getClasses4_3().size()!=0) {
								String classs = "";
								double people = 0;
								for (String string : ordinaryCourse.getClasses4_3()) {
									classTable = sqlUtil.selectClassTable(string);
									classs = classs+classTable.getClasss()+",";
									people += classTable.getNpeople();
								}
								npeople.add(people);
								speople.add(classs);
							}
						}
					}
					System.out.println(npeople);
					System.out.println(speople);
					System.out.println(npeople2);
				//找寻人数最多的班级，放在最前
					int j = 0;
					double max = npeople.get(0);
					for (int i = 0; i < npeople.size(); i++) {
						if (max < npeople.get(i)) {
							max = npeople.get(i);
							j = i;
						}
					}
					if(j!=0) {
						npeople.set(j, npeople.get(0));
						npeople.set(0, max);
						String string = speople.get(0);
						speople.set(0, speople.get(j));
						speople.set(j, string);
						if(ordinaryCourse.getDecide1().equals("1")) {
							String string1 = npeople2.get(0);
							npeople2.set(0, npeople2.get(j));
							npeople2.set(j, string1);
						}
					}
				//整合班级和人数，用于存储
					if(ordinaryCourse.getDecide1().equals("1")) {
						String string1 = "";
						String string2 = "";
						for (int i = 0; i < speople.size(); i++) {
							if(i == speople.size()-1) {
								string1 = string1+speople.get(i)+npeople2.get(i);
								string2 = string2+speople.get(i)+npeople2.get(i)+",";
							}else {
								string1 = string1+speople.get(i)+npeople2.get(i)+"<br>";
								string2 = string2+speople.get(i)+npeople2.get(i)+",";
							}
						}
						count.setClasss(string1);
						count.setClasss_show(string2);
					}else {
						String string1 = "";
						String string2 = "";
						for (int i = 0; i < speople.size(); i++) {
							if(i == speople.size()-1) {
								string1 = string1+speople.get(i)+"("+npeople.get(i)+"人)";
								string2 = string2+speople.get(i)+"("+npeople.get(i)+"人)";
							}else {
								string1 = string1+speople.get(i)+"("+npeople.get(i)+"人)<br>";
								string2 = string2+speople.get(i)+"("+npeople.get(i)+"人),";
							}
						}
						count.setClasss(string1);
						count.setClasss_show(string2);
					}
					System.out.println(count);
				//判断该课程是否有实验课和理论课，分类计算存储
					//计算理论课课时
					if(courseTable.getReality()!=0) {
						//逐一计算各班级对应课时，首班用选择课程类型，后续班级用重复课类型
						for (int i = 0; i < npeople.size(); i++) {
							if(i==0) {
								//设置班级人数
								count.setNpeople(npeople.get(i));
								//导入数据到计算类计算结果，存储计算结果和计算过程
								CalculateService calculateService = new CalculateService();
								calculateService.realityService(count, equation);
							}else {
								if(npeople.get(i)<=40) {
									//设置课程类型
									equation = sqlUtil.selectEquation("A0011");
									//设置班级人数
									count.setNpeople(npeople.get(i));
									//导入数据到计算类计算结果，存储计算结果和计算过程
									CalculateService calculateService = new CalculateService();
									calculateService.realityService(count, equation);
								}else {
									//设置课程类型为重复班
									equation = sqlUtil.selectEquation("A004");
									//设置班级人数
									count.setNpeople(npeople.get(i));
									//导入数据到计算类计算结果，存储计算结果和计算过程
									CalculateService calculateService = new CalculateService();
									calculateService.realityService(count, equation);
								}
							} 
						}
					}
					//实验课计算课时
					if (courseTable.getExperiment()!=0) {
						for (int i = 0; i < npeople.size(); i++) {
							if(npeople.get(i)<=50) {
								//设置课程类型
								equation = sqlUtil.selectEquation("B0011");
								//设置班级人数
								count.setNpeople(npeople.get(i));
								//导入数据到计算类计算结果，存储计算结果和计算过程
								CalculateService calculateService = new CalculateService();
								calculateService.experimentService(count, equation);
							}else {
								//设置课程类型
								equation = sqlUtil.selectEquation("B0012");
								//设置班级人数
								count.setNpeople(npeople.get(i));
								//导入数据到计算类计算结果，存储计算结果和计算过程
								CalculateService calculateService = new CalculateService();
								calculateService.experimentService(count, equation);
							}
						}
					}
					//设置double保留两位小数
					DecimalFormat decimalFormat = new DecimalFormat("#.00");
					//保存计算结果
					count.setRealityResult(Double.valueOf(decimalFormat.format(count.getRealityResult())));
					count.setExperimentResult(Double.valueOf(decimalFormat.format(count.getExperimentResult())));
					//整合保存课时数据，以便存储到数据库
					count.setResultString("理论课时("+count.getRealityResult()+"),实验课时("+count.getExperimentResult()+")");

		} catch (Exception e) {
			// TODO: handle exception
		}
			}
	public void graduationProjectCount(Count count,Count count2) throws IOException {
		//防止出现空指针
		try {
			//建立数据库连接
			SqlUtil sqlUtil = new SqlUtil();
			//创建数据库数据接收类
			Equation equation = new Equation();
			//整合数据，从数据库中获取计算所需要的数据
			equation = sqlUtil.selectEquation(count.getNumberA());
			//导入数据到计算类计算结果，存储计算结果和计算过程
			CalculateService calculateService = new CalculateService();
			calculateService.realityService(count, equation);
			//整合前端显示给用户的数据和需要存储到数据库的数据
			count2.setCourse(equation.getType());
			count2.setResult(count.getRealityResult());
			count2.setClasss("团队("+count.getNteam()+"队"+count.getNweekB()+"周)个人("+count.getNpeople()+"人"+count.getNweekA()+"周)");
			count2.setQuantity(count.getRealityQuantity());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void socialPracticeCount(Count count,Count count2) throws IOException {
		//防止出现空指针
		try {
			//建立数据库连接
			SqlUtil sqlUtil = new SqlUtil();
			//创建数据库数据接收类
			Equation equation = new Equation();
			//整合数据，从数据库中获取计算所需要的数据
			equation = sqlUtil.selectEquation(count.getNumberA());
			//导入数据到计算类计算结果，存储计算结果和计算过程
			CalculateService calculateService = new CalculateService();
			calculateService.realityService(count, equation);
			//整合前端显示给用户的数据和需要存储到数据库的数据
			count2.setCourse(equation.getType());
			count2.setResult(count.getRealityResult());
			count2.setClasss(equation.getType()+"("+count.getNday()+"天)("+count.getNgroup()+"组)");
			count2.setQuantity(count.getRealityQuantity());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void trainCount(Train train,Count count) throws IOException {
		//防止出现空指针
		try {
			//建立数据库连接
			SqlUtil sqlUtil = new SqlUtil();
			//创建数据库数据接收类
			ClassTable classTable = new ClassTable();
			Equation equation = new Equation();
			//整合数据，从数据库中获取计算所需要的数据
			equation = sqlUtil.selectEquation(train.getType());
			//整合数据
			count.setCourse(equation.getType());
			//根据用户选择的类型整合
			if (train.getDay()!=0) {
				count.setNday(train.getDay());
				count.setNclass(train.getNclass());
				count.setNteacher(train.getTeachers());
				count.setClasss("天数("+train.getDay()+"天)班数("+train.getNclass()+")代课老师数("+train.getTeachers()+"人)");
			}
			if (train.getReality()!=0) {
				count.setExperiment(train.getReality());
				//依此查询班级区段中各个班级的人数
				double npeople = 0;
				int start = train.getClassStart();
				int finish = train.getClassFinish();
				List<String> classsList =  new ArrayList();
				for (int i = start; i <= finish; i++) {
					classsList.add(String.valueOf(i));
				}
				for (String string : classsList) {
					classTable = sqlUtil.selectClassTable(string);
					npeople += classTable.getNpeople();
				}
				//判断是否有新加人数
				if (train.getNpeople()==0) {
					count.setClasss(start+"—"+finish+"("+npeople+"人)");
				}else {
					count.setClasss(start+"—"+finish+"("+npeople+"人)("+train.getNpeople()+")");
				}
				count.setNpeople(npeople+train.getNpeople());
			}
			//导入数据到计算类计算结果，存储计算结果和计算过程
			CalculateService calculateService = new CalculateService();
			calculateService.realityService(count, equation);
			//转移中间数据
			count.setResult(count.getRealityResult());
			count.setQuantity(count.getRealityQuantity());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void otherCount(Other other,Other other2) throws IOException {
		//防止出现空指针
		try {
			//创建数据库连接方式
			SqlUtil sqlUtil = new SqlUtil();
			//创建数据库数据接收类
			Equation equation = new Equation();
			CourseTable courseTable = new CourseTable();
			Parameters parameters = new Parameters();
			PositionTable positionTable = new PositionTable();
			//整合数据，从数据库中获取计算所需要的数据
			equation = sqlUtil.selectEquation("E001");
			//由于功能零散，计算点比较多，分步计算，累加求和
			//初始化数据
			other2.setQuantity("");
			//指导进修教师和青年教师的工作量
			if(other.getNpeople()!=0) {
				//传参给可计算中间类
				Count count = new Count();
				count.setNpeople(other.getNpeople());
				//导入数据到计算类计算结果，存储计算结果和计算过程
				CalculateService calculateService = new CalculateService();
				calculateService.realityService(count, equation);
				other2.setResult(count.getRealityResult());
				other2.setQuantity(equation.getType()+"("+other.getNpeople()+"人)("+count.getRealityResult()+"学时)+");
			}
			//教学方法研究工作量
			if(other.getResearchOption().equals("1")) {
				parameters = sqlUtil.selectParameters("researchA");
				other2.setResult(other2.getResult()+parameters.getParametersValue());
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"学时)+");
			}
			//核心期刊
			if(other.getPeriodical()!=0) {
				parameters = sqlUtil.selectParameters("researchB");
				//暂存奖励学时
				double d = parameters.getParametersValue()*other.getPeriodical();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"篇)"+"("+d+"学时)+");
			}
			//教学研究课题
			if(other.getResearchSubject1()!=0) {
				parameters = sqlUtil.selectParameters("researchC");
				//暂存奖励学时
				double d = parameters.getParametersValue()*other.getResearchSubject1();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"篇)"+"("+d+"学时)+");
			}
			//国家一级论文
			if(other.getPaper()!=0) {
				parameters = sqlUtil.selectParameters("researchD");
				//暂存奖励学时
				double d = parameters.getParametersValue()*other.getPaper();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"篇)"+"("+d+"学时)+");
			}
			//国家下达的教学研究课题
			if(other.getResearchSubject2()!=0) {
				parameters = sqlUtil.selectParameters("researchE");
				//暂存奖励学时
				double d = parameters.getParametersValue()*other.getResearchSubject2();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"篇)"+"("+d+"学时)+");
			}
			//双肩挑教师的教学工作量
			//判断是否身兼多职的教师累积不计
			if(other.getCumulativeOption().equals("1")) {
				//调用数据库数据，遍历最大值
				 double max = 0;
				 List<String> list = other.getList();
				 for (String string : list) {
					positionTable = sqlUtil.selectPositionTable(string);
					other2.setQuantity(other2.getQuantity()+positionTable.getPositionName());
					max = positionTable.getPositionTime()>max?positionTable.getPositionTime():max;
				}
				 if(max!=0) {
					 other2.setQuantity(other2.getQuantity()+"("+max+"学时)+");
					 other2.setResult(other2.getResult()+max);
				 }
			}
			if(other.getCumulativeOption().equals("0")) {
				 List<String> list = other.getList();
				 for (String string : list) {
					 positionTable = sqlUtil.selectPositionTable(string);
					 other2.setQuantity(other2.getQuantity()+positionTable.getPositionName()+"("+positionTable.getPositionTime()+"学时)+");
					 other2.setResult(other2.getResult()+positionTable.getPositionTime());
				}
			}
			//课程组和课程群工作量
			if(other.getGroup()!=null) {
				parameters = sqlUtil.selectParameters(other.getGroup());
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"学时)+");
				other2.setResult(other2.getResult()+parameters.getParametersValue());
			}
			if(other.getFlock()!=null) {
				parameters = sqlUtil.selectParameters(other.getFlock());
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"学时)+");
				other2.setResult(other2.getResult()+parameters.getParametersValue());
			}
			//编写教材教学工作量
			if(other.getCourse().equals("请选择")) {
				//无操作
			}else {
				//获取数据库数据
				courseTable = sqlUtil.selectCourseTable(other.getCourse());
				parameters = sqlUtil.selectParameters("textbookA");
				//判断是否获得国家级规划教材或省级以上优秀教材
				if(other.getCourseOption().equals("1")) {
					//附加奖励学时
					Parameters parameters2 = sqlUtil.selectParameters("textbookB");
					//暂时存储奖励学时
					double d = courseTable.getReality()*parameters.getParametersValue()+courseTable.getReality()*parameters2.getParametersValue();
					other2.setQuantity(other2.getQuantity()+"编写教材:"+courseTable.getCourse()+"("+d+"学时)");
					other2.setResult(other2.getResult()+d);
				}
				if(other.getCourseOption().equals("0")) {
					//暂时存储奖励学时
					double d = courseTable.getReality()*parameters.getParametersValue();
					other2.setQuantity(other2.getQuantity()+"编写教材:"+courseTable.getCourse()+"("+d+"学时)");
					other2.setResult(other2.getResult()+d);
				}
			}
			//大牛专用，剩余编写教材工作量
			if(!other.getSpecialString().equals(null)) {
				other2.setQuantity(other2.getQuantity()+"编写教材:"+other.getSpecialString()+"("+other.getSpecialValue()+"学时)");
				other2.setResult(other2.getResult()+other.getSpecialValue());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
