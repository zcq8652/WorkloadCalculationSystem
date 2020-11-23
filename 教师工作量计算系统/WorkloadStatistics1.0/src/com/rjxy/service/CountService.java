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
		//try catch ��ֹ���ֿ�ָ��
		try {
			System.out.println(ordinaryCourse);
			//�������ݿ����ӷ�ʽ
			SqlUtil sqlUtil = new SqlUtil();
			//�������ݿ����ݽ�����
			CourseTable courseTable = new CourseTable();
			Equation equation = new Equation();
			ClassTable classTable = new ClassTable();
			//����ǰ�����ݣ������ݿ��е�����Ҫ�õ�������
			courseTable = sqlUtil.selectCourseTable(ordinaryCourse.getCourse());
			count.setCourse(courseTable.getCourse());
			count.setTotal(courseTable.getTotal());
			count.setReality(courseTable.getReality());
			count.setExperiment(courseTable.getExperiment());
			//ͨ����ʽ��Ż�ȡ��Ӧ�γ̿�ʱ���㹫ʽ
			equation = sqlUtil.selectEquation(ordinaryCourse.getEquation());
			//���øñ�Ź�ʽ��Ӧ�Ŀγ�����
			count.setCtype(equation.getType());
			//�жϰ༶�������Ҷ�Ӧ�༶�������������
			List<String> classs = ordinaryCourse.getClasss();
			//�洢�༶�������������ݣ���ĺ���--------------------��,����+1��
			//�༶����
			List<Double> npeople1 = new ArrayList();
			for (String string : classs) {
				classTable = sqlUtil.selectClassTable(string);
				npeople1.add(classTable.getNpeople());
			}
			//�༶�¼�����
			List<Double> npeople2 = new ArrayList();
			if(ordinaryCourse.getNpeople().equals("��")) {
				//���ϰ༶���ݣ���������ʹ洢
				String classString="";
				for(int i=0;i<classs.size();i++) {
					classString+=classs.get(i)+"("+npeople1.get(i)+"��)";
				}
				count.setClasss(classString);
			}else {
				String[] strings = ordinaryCourse.getNpeople().split(",");
				for (String string : strings) {
					npeople2.add(Double.parseDouble(string));
				}
				//���ϰ༶���ݣ���������ʹ洢
				String classString="";
				for(int i=0;i<classs.size();i++) {
					if(npeople2.get(i)!=0) {
						classString+=classs.get(i)+"("+npeople1.get(i)+"��)("+npeople2.get(i)+"��)";
					}else {
						classString+=classs.get(i)+"("+npeople1.get(i)+"��)";
					}
				}
				count.setClasss(classString);
				//�ӺͰ༶��������������
				for (int i = 0; i < npeople1.size(); i++) {
					npeople1.set(i, npeople1.get(i)+npeople2.get(i));
				}
			}
			//���༶�����д�С����
			for (int i = 0; i < npeople1.size(); i++) {
				for (int j = i+1; j < npeople1.size()-i; j++) {
					if(npeople1.get(i)<npeople1.get(j)) {
						double d = npeople1.get(i);
						npeople1.set(i, npeople1.get(j));
						npeople1.set(j, d);
					}
				}
			}
			//�жϸÿγ��Ƿ���ʵ��κ����ۿΣ��������洢
			//�������ۿο�ʱ
			if(courseTable.getReality()!=0) {
				//��һ������༶��Ӧ��ʱ���װ���ѡ��γ����ͣ������༶���ظ�������
				for (int i = 0; i < npeople1.size(); i++) {
					if(i==0) {
						//���ð༶����
						count.setNpeople(npeople1.get(i));
						//�������ݵ���������������洢�������ͼ������
						CalculateService calculateService = new CalculateService();
						calculateService.realityService(count, equation);
					}else {
						if(npeople1.get(i)<=40) {
							//���ÿγ�����
							equation = sqlUtil.selectEquation("A0011");
							//���ð༶����
							count.setNpeople(npeople1.get(i));
							//�������ݵ���������������洢�������ͼ������
							CalculateService calculateService = new CalculateService();
							calculateService.realityService(count, equation);
						}else {
							//���ÿγ�����Ϊ�ظ���
							equation = sqlUtil.selectEquation("A004");
							//���ð༶����
							count.setNpeople(npeople1.get(i));
							//�������ݵ���������������洢�������ͼ������
							CalculateService calculateService = new CalculateService();
							calculateService.realityService(count, equation);
						}
					} 
				}
			}
			//ʵ��μ����ʱ
			if (courseTable.getExperiment()!=0) {
				for (int i = 0; i < npeople1.size(); i++) {
					if(npeople1.get(i)<=50) {
						//���ÿγ�����
						equation = sqlUtil.selectEquation("B0011");
						//���ð༶����
						count.setNpeople(npeople1.get(i));
						//�������ݵ���������������洢�������ͼ������
						CalculateService calculateService = new CalculateService();
						calculateService.experimentService(count, equation);
					}else {
						//���ÿγ�����
						equation = sqlUtil.selectEquation("B0012");
						//���ð༶����
						count.setNpeople(npeople1.get(i));
						//�������ݵ���������������洢�������ͼ������
						CalculateService calculateService = new CalculateService();
						calculateService.experimentService(count, equation);
					}
				}
			}
			//����double������λС��
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			//���������
			count.setRealityResult(Double.valueOf(decimalFormat.format(count.getRealityResult())));
			count.setExperimentResult(Double.valueOf(decimalFormat.format(count.getExperimentResult())));
			//���ϱ����ʱ���ݣ��Ա�洢�����ݿ�
			count.setResultString("���ۿ�ʱ("+count.getRealityResult()+"),ʵ���ʱ("+count.getExperimentResult()+")");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void ordinaryCourseCount_1(OrdinaryCourse ordinaryCourse,Count count) throws IOException {
		try {
			//��ͷ����,��ס���
			//��������ǰ������(�����)
			//���ϰ༶����(����+2)
				//�����ݿ��л�ȡ����༶����
					//�������ݿ�����
			System.out.println(ordinaryCourse);
					SqlUtil sqlUtil = new SqlUtil();
					//�������ݿ����ݽ�����
					CourseTable courseTable = new CourseTable();
					Equation equation = new Equation();
					ClassTable classTable = new ClassTable();
					//����ǰ�����ݣ������ݿ��е�����Ҫ�õ�������
					courseTable = sqlUtil.selectCourseTable(ordinaryCourse.getCourse());
					count.setCourse(courseTable.getCourse());
					count.setTotal(courseTable.getTotal());
					count.setReality(courseTable.getReality());
					count.setExperiment(courseTable.getExperiment());
					//ͨ����ʽ��Ż�ȡ��Ӧ�γ̿�ʱ���㹫ʽ
					equation = sqlUtil.selectEquation(ordinaryCourse.getEquation());
					//���øñ�Ź�ʽ��Ӧ�Ŀγ�����
					count.setCtype(equation.getType());
					//��ȡ��Ӧ�༶��Ӧ����
					List<Double> npeople = new ArrayList();
					List<String> speople = new ArrayList();
					//����List������������仯ʱ������
					List<String> npeople2 = new ArrayList<String>();
					//�жϰ༶�����Ƿ���ڱ仯
					if(ordinaryCourse.getDecide1().equals("1")) {
						//�䶯����
						List<Double> npeople1 = new ArrayList<Double>();
						String[] strings1 = ordinaryCourse.getNpeople().split(",");
						for (String string : strings1) {
							npeople1.add(Double.parseDouble(string));
						}
						System.out.println(npeople1);
						//�䶯�༶
						List<String> classs2 = new ArrayList<String>();
						String[] strings2 = ordinaryCourse.getClasss2().split(",");
						for (String string : strings2) {
							classs2.add(string);
						}
						System.out.println(classs2);
						//���ϵ���༶�������в鿴�Ƿ���������䶯�༶
						for (String string : ordinaryCourse.getClasss()) {
							int a = 0;
							for (int i = 0; i < classs2.size(); i++) {
								if(classs2.get(i).equals(string)) {
									classTable = sqlUtil.selectClassTable(string);
									npeople.add(classTable.getNpeople()+npeople1.get(i));
									npeople2.add("("+String.valueOf(classTable.getNpeople())+"��)(+"+String.valueOf(npeople1.get(i))+")");
									speople.add(classTable.getClasss());
									a = 1;
									break;
								}
							}
							if(a == 0) {
								classTable = sqlUtil.selectClassTable(string);
								npeople.add(classTable.getNpeople());
								npeople2.add("("+String.valueOf(classTable.getNpeople())+"��)");
								speople.add(classTable.getClasss());
							}
						}
						//�����жϸ���Ԥ�����Ƿ��������
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
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
							npeople2.add("("+npoeple_2+"��)(+"+npoeple_1+")");
							speople.add(classs);
						}
					}else {
						//��������
						for (String string : ordinaryCourse.getClasss()) {
							classTable = sqlUtil.selectClassTable(string);
							npeople.add(classTable.getNpeople());
							speople.add(classTable.getClasss());
						}
						//�ϰ����������ж��Ƿ���ںϰ�
						if (true) {
							//�����жϸ���Ԥ�����Ƿ��������
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
				//��Ѱ�������İ༶��������ǰ
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
				//���ϰ༶�����������ڴ洢
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
								string1 = string1+speople.get(i)+"("+npeople.get(i)+"��)";
								string2 = string2+speople.get(i)+"("+npeople.get(i)+"��)";
							}else {
								string1 = string1+speople.get(i)+"("+npeople.get(i)+"��)<br>";
								string2 = string2+speople.get(i)+"("+npeople.get(i)+"��),";
							}
						}
						count.setClasss(string1);
						count.setClasss_show(string2);
					}
					System.out.println(count);
				//�жϸÿγ��Ƿ���ʵ��κ����ۿΣ��������洢
					//�������ۿο�ʱ
					if(courseTable.getReality()!=0) {
						//��һ������༶��Ӧ��ʱ���װ���ѡ��γ����ͣ������༶���ظ�������
						for (int i = 0; i < npeople.size(); i++) {
							if(i==0) {
								//���ð༶����
								count.setNpeople(npeople.get(i));
								//�������ݵ���������������洢�������ͼ������
								CalculateService calculateService = new CalculateService();
								calculateService.realityService(count, equation);
							}else {
								if(npeople.get(i)<=40) {
									//���ÿγ�����
									equation = sqlUtil.selectEquation("A0011");
									//���ð༶����
									count.setNpeople(npeople.get(i));
									//�������ݵ���������������洢�������ͼ������
									CalculateService calculateService = new CalculateService();
									calculateService.realityService(count, equation);
								}else {
									//���ÿγ�����Ϊ�ظ���
									equation = sqlUtil.selectEquation("A004");
									//���ð༶����
									count.setNpeople(npeople.get(i));
									//�������ݵ���������������洢�������ͼ������
									CalculateService calculateService = new CalculateService();
									calculateService.realityService(count, equation);
								}
							} 
						}
					}
					//ʵ��μ����ʱ
					if (courseTable.getExperiment()!=0) {
						for (int i = 0; i < npeople.size(); i++) {
							if(npeople.get(i)<=50) {
								//���ÿγ�����
								equation = sqlUtil.selectEquation("B0011");
								//���ð༶����
								count.setNpeople(npeople.get(i));
								//�������ݵ���������������洢�������ͼ������
								CalculateService calculateService = new CalculateService();
								calculateService.experimentService(count, equation);
							}else {
								//���ÿγ�����
								equation = sqlUtil.selectEquation("B0012");
								//���ð༶����
								count.setNpeople(npeople.get(i));
								//�������ݵ���������������洢�������ͼ������
								CalculateService calculateService = new CalculateService();
								calculateService.experimentService(count, equation);
							}
						}
					}
					//����double������λС��
					DecimalFormat decimalFormat = new DecimalFormat("#.00");
					//���������
					count.setRealityResult(Double.valueOf(decimalFormat.format(count.getRealityResult())));
					count.setExperimentResult(Double.valueOf(decimalFormat.format(count.getExperimentResult())));
					//���ϱ����ʱ���ݣ��Ա�洢�����ݿ�
					count.setResultString("���ۿ�ʱ("+count.getRealityResult()+"),ʵ���ʱ("+count.getExperimentResult()+")");

		} catch (Exception e) {
			// TODO: handle exception
		}
			}
	public void graduationProjectCount(Count count,Count count2) throws IOException {
		//��ֹ���ֿ�ָ��
		try {
			//�������ݿ�����
			SqlUtil sqlUtil = new SqlUtil();
			//�������ݿ����ݽ�����
			Equation equation = new Equation();
			//�������ݣ������ݿ��л�ȡ��������Ҫ������
			equation = sqlUtil.selectEquation(count.getNumberA());
			//�������ݵ���������������洢�������ͼ������
			CalculateService calculateService = new CalculateService();
			calculateService.realityService(count, equation);
			//����ǰ����ʾ���û������ݺ���Ҫ�洢�����ݿ������
			count2.setCourse(equation.getType());
			count2.setResult(count.getRealityResult());
			count2.setClasss("�Ŷ�("+count.getNteam()+"��"+count.getNweekB()+"��)����("+count.getNpeople()+"��"+count.getNweekA()+"��)");
			count2.setQuantity(count.getRealityQuantity());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void socialPracticeCount(Count count,Count count2) throws IOException {
		//��ֹ���ֿ�ָ��
		try {
			//�������ݿ�����
			SqlUtil sqlUtil = new SqlUtil();
			//�������ݿ����ݽ�����
			Equation equation = new Equation();
			//�������ݣ������ݿ��л�ȡ��������Ҫ������
			equation = sqlUtil.selectEquation(count.getNumberA());
			//�������ݵ���������������洢�������ͼ������
			CalculateService calculateService = new CalculateService();
			calculateService.realityService(count, equation);
			//����ǰ����ʾ���û������ݺ���Ҫ�洢�����ݿ������
			count2.setCourse(equation.getType());
			count2.setResult(count.getRealityResult());
			count2.setClasss(equation.getType()+"("+count.getNday()+"��)("+count.getNgroup()+"��)");
			count2.setQuantity(count.getRealityQuantity());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void trainCount(Train train,Count count) throws IOException {
		//��ֹ���ֿ�ָ��
		try {
			//�������ݿ�����
			SqlUtil sqlUtil = new SqlUtil();
			//�������ݿ����ݽ�����
			ClassTable classTable = new ClassTable();
			Equation equation = new Equation();
			//�������ݣ������ݿ��л�ȡ��������Ҫ������
			equation = sqlUtil.selectEquation(train.getType());
			//��������
			count.setCourse(equation.getType());
			//�����û�ѡ�����������
			if (train.getDay()!=0) {
				count.setNday(train.getDay());
				count.setNclass(train.getNclass());
				count.setNteacher(train.getTeachers());
				count.setClasss("����("+train.getDay()+"��)����("+train.getNclass()+")������ʦ��("+train.getTeachers()+"��)");
			}
			if (train.getReality()!=0) {
				count.setExperiment(train.getReality());
				//���˲�ѯ�༶�����и����༶������
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
				//�ж��Ƿ����¼�����
				if (train.getNpeople()==0) {
					count.setClasss(start+"��"+finish+"("+npeople+"��)");
				}else {
					count.setClasss(start+"��"+finish+"("+npeople+"��)("+train.getNpeople()+")");
				}
				count.setNpeople(npeople+train.getNpeople());
			}
			//�������ݵ���������������洢�������ͼ������
			CalculateService calculateService = new CalculateService();
			calculateService.realityService(count, equation);
			//ת���м�����
			count.setResult(count.getRealityResult());
			count.setQuantity(count.getRealityQuantity());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void otherCount(Other other,Other other2) throws IOException {
		//��ֹ���ֿ�ָ��
		try {
			//�������ݿ����ӷ�ʽ
			SqlUtil sqlUtil = new SqlUtil();
			//�������ݿ����ݽ�����
			Equation equation = new Equation();
			CourseTable courseTable = new CourseTable();
			Parameters parameters = new Parameters();
			PositionTable positionTable = new PositionTable();
			//�������ݣ������ݿ��л�ȡ��������Ҫ������
			equation = sqlUtil.selectEquation("E001");
			//���ڹ�����ɢ�������Ƚ϶࣬�ֲ����㣬�ۼ����
			//��ʼ������
			other2.setQuantity("");
			//ָ�����޽�ʦ�������ʦ�Ĺ�����
			if(other.getNpeople()!=0) {
				//���θ��ɼ����м���
				Count count = new Count();
				count.setNpeople(other.getNpeople());
				//�������ݵ���������������洢�������ͼ������
				CalculateService calculateService = new CalculateService();
				calculateService.realityService(count, equation);
				other2.setResult(count.getRealityResult());
				other2.setQuantity(equation.getType()+"("+other.getNpeople()+"��)("+count.getRealityResult()+"ѧʱ)+");
			}
			//��ѧ�����о�������
			if(other.getResearchOption().equals("1")) {
				parameters = sqlUtil.selectParameters("researchA");
				other2.setResult(other2.getResult()+parameters.getParametersValue());
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ѧʱ)+");
			}
			//�����ڿ�
			if(other.getPeriodical()!=0) {
				parameters = sqlUtil.selectParameters("researchB");
				//�ݴ潱��ѧʱ
				double d = parameters.getParametersValue()*other.getPeriodical();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ƪ)"+"("+d+"ѧʱ)+");
			}
			//��ѧ�о�����
			if(other.getResearchSubject1()!=0) {
				parameters = sqlUtil.selectParameters("researchC");
				//�ݴ潱��ѧʱ
				double d = parameters.getParametersValue()*other.getResearchSubject1();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ƪ)"+"("+d+"ѧʱ)+");
			}
			//����һ������
			if(other.getPaper()!=0) {
				parameters = sqlUtil.selectParameters("researchD");
				//�ݴ潱��ѧʱ
				double d = parameters.getParametersValue()*other.getPaper();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ƪ)"+"("+d+"ѧʱ)+");
			}
			//�����´�Ľ�ѧ�о�����
			if(other.getResearchSubject2()!=0) {
				parameters = sqlUtil.selectParameters("researchE");
				//�ݴ潱��ѧʱ
				double d = parameters.getParametersValue()*other.getResearchSubject2();
				other2.setResult(other2.getResult()+d);
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ƪ)"+"("+d+"ѧʱ)+");
			}
			//˫������ʦ�Ľ�ѧ������
			//�ж��Ƿ�����ְ�Ľ�ʦ�ۻ�����
			if(other.getCumulativeOption().equals("1")) {
				//�������ݿ����ݣ��������ֵ
				 double max = 0;
				 List<String> list = other.getList();
				 for (String string : list) {
					positionTable = sqlUtil.selectPositionTable(string);
					other2.setQuantity(other2.getQuantity()+positionTable.getPositionName());
					max = positionTable.getPositionTime()>max?positionTable.getPositionTime():max;
				}
				 if(max!=0) {
					 other2.setQuantity(other2.getQuantity()+"("+max+"ѧʱ)+");
					 other2.setResult(other2.getResult()+max);
				 }
			}
			if(other.getCumulativeOption().equals("0")) {
				 List<String> list = other.getList();
				 for (String string : list) {
					 positionTable = sqlUtil.selectPositionTable(string);
					 other2.setQuantity(other2.getQuantity()+positionTable.getPositionName()+"("+positionTable.getPositionTime()+"ѧʱ)+");
					 other2.setResult(other2.getResult()+positionTable.getPositionTime());
				}
			}
			//�γ���Ϳγ�Ⱥ������
			if(other.getGroup()!=null) {
				parameters = sqlUtil.selectParameters(other.getGroup());
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ѧʱ)+");
				other2.setResult(other2.getResult()+parameters.getParametersValue());
			}
			if(other.getFlock()!=null) {
				parameters = sqlUtil.selectParameters(other.getFlock());
				other2.setQuantity(other2.getQuantity()+parameters.getParametersName()+"("+parameters.getParametersValue()+"ѧʱ)+");
				other2.setResult(other2.getResult()+parameters.getParametersValue());
			}
			//��д�̲Ľ�ѧ������
			if(other.getCourse().equals("��ѡ��")) {
				//�޲���
			}else {
				//��ȡ���ݿ�����
				courseTable = sqlUtil.selectCourseTable(other.getCourse());
				parameters = sqlUtil.selectParameters("textbookA");
				//�ж��Ƿ��ù��Ҽ��滮�̲Ļ�ʡ����������̲�
				if(other.getCourseOption().equals("1")) {
					//���ӽ���ѧʱ
					Parameters parameters2 = sqlUtil.selectParameters("textbookB");
					//��ʱ�洢����ѧʱ
					double d = courseTable.getReality()*parameters.getParametersValue()+courseTable.getReality()*parameters2.getParametersValue();
					other2.setQuantity(other2.getQuantity()+"��д�̲�:"+courseTable.getCourse()+"("+d+"ѧʱ)");
					other2.setResult(other2.getResult()+d);
				}
				if(other.getCourseOption().equals("0")) {
					//��ʱ�洢����ѧʱ
					double d = courseTable.getReality()*parameters.getParametersValue();
					other2.setQuantity(other2.getQuantity()+"��д�̲�:"+courseTable.getCourse()+"("+d+"ѧʱ)");
					other2.setResult(other2.getResult()+d);
				}
			}
			//��ţר�ã�ʣ���д�̲Ĺ�����
			if(!other.getSpecialString().equals(null)) {
				other2.setQuantity(other2.getQuantity()+"��д�̲�:"+other.getSpecialString()+"("+other.getSpecialValue()+"ѧʱ)");
				other2.setResult(other2.getResult()+other.getSpecialValue());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
