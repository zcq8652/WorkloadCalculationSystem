package com.rjxy.domain;

import java.util.Arrays;
import java.util.List;

public class OrdinaryCourse {
	private String course;//课程编号，用来获取课程理论课时和实验课时
	private List<String> classs;//单班班级
	private String equation;//班级类型，用来获取计算公式
	private String decide1;//判断是否有人数变动
	private String classs2;//人数变动班级
	private String npeople;//变动人数
	private String decide2;//判断是否存在合班
	private List<String> classes1_0 = null;//以下为合班预备队
	private List<String> classes1_1 = null;
	private List<String> classes1_2 = null;
	private List<String> classes1_3 = null;
	private List<String> classes2_0 = null;
	private List<String> classes2_1 = null;
	private List<String> classes2_2 = null;
	private List<String> classes2_3 = null;
	private List<String> classes3_0 = null;
	private List<String> classes3_1 = null;
	private List<String> classes3_2 = null;
	private List<String> classes3_3 = null;
	private List<String> classes4_0 = null;
	private List<String> classes4_1 = null;
	private List<String> classes4_2 = null;
	private List<String> classes4_3 = null;
	public OrdinaryCourse() {
		super();
	}
	public OrdinaryCourse(String course, List<String> classs, String equation, String decide1, String classs2,
			String npeople, String decide2, List<String> classes1_0, List<String> classes1_1, List<String> classes1_2,
			List<String> classes1_3, List<String> classes2_0, List<String> classes2_1, List<String> classes2_2,
			List<String> classes2_3, List<String> classes3_0, List<String> classes3_1, List<String> classes3_2,
			List<String> classes3_3, List<String> classes4_0, List<String> classes4_1, List<String> classes4_2,
			List<String> classes4_3) {
		super();
		this.course = course;
		this.classs = classs;
		this.equation = equation;
		this.decide1 = decide1;
		this.classs2 = classs2;
		this.npeople = npeople;
		this.decide2 = decide2;
		this.classes1_0 = classes1_0;
		this.classes1_1 = classes1_1;
		this.classes1_2 = classes1_2;
		this.classes1_3 = classes1_3;
		this.classes2_0 = classes2_0;
		this.classes2_1 = classes2_1;
		this.classes2_2 = classes2_2;
		this.classes2_3 = classes2_3;
		this.classes3_0 = classes3_0;
		this.classes3_1 = classes3_1;
		this.classes3_2 = classes3_2;
		this.classes3_3 = classes3_3;
		this.classes4_0 = classes4_0;
		this.classes4_1 = classes4_1;
		this.classes4_2 = classes4_2;
		this.classes4_3 = classes4_3;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public List<String> getClasss() {
		return classs;
	}
	public void setClasss(List<String> classs) {
		this.classs = classs;
	}
	public String getEquation() {
		return equation;
	}
	public void setEquation(String equation) {
		this.equation = equation;
	}
	public String getDecide1() {
		return decide1;
	}
	public void setDecide1(String decide1) {
		this.decide1 = decide1;
	}
	public String getClasss2() {
		return classs2;
	}
	public void setClasss2(String classs2) {
		this.classs2 = classs2;
	}
	public String getNpeople() {
		return npeople;
	}
	public void setNpeople(String npeople) {
		this.npeople = npeople;
	}
	public String getDecide2() {
		return decide2;
	}
	public void setDecide2(String decide2) {
		this.decide2 = decide2;
	}
	public List<String> getClasses1_0() {
		return classes1_0;
	}
	public void setClasses1_0(List<String> classes1_0) {
		this.classes1_0 = classes1_0;
	}
	public List<String> getClasses1_1() {
		return classes1_1;
	}
	public void setClasses1_1(List<String> classes1_1) {
		this.classes1_1 = classes1_1;
	}
	public List<String> getClasses1_2() {
		return classes1_2;
	}
	public void setClasses1_2(List<String> classes1_2) {
		this.classes1_2 = classes1_2;
	}
	public List<String> getClasses1_3() {
		return classes1_3;
	}
	public void setClasses1_3(List<String> classes1_3) {
		this.classes1_3 = classes1_3;
	}
	public List<String> getClasses2_0() {
		return classes2_0;
	}
	public void setClasses2_0(List<String> classes2_0) {
		this.classes2_0 = classes2_0;
	}
	public List<String> getClasses2_1() {
		return classes2_1;
	}
	public void setClasses2_1(List<String> classes2_1) {
		this.classes2_1 = classes2_1;
	}
	public List<String> getClasses2_2() {
		return classes2_2;
	}
	public void setClasses2_2(List<String> classes2_2) {
		this.classes2_2 = classes2_2;
	}
	public List<String> getClasses2_3() {
		return classes2_3;
	}
	public void setClasses2_3(List<String> classes2_3) {
		this.classes2_3 = classes2_3;
	}
	public List<String> getClasses3_0() {
		return classes3_0;
	}
	public void setClasses3_0(List<String> classes3_0) {
		this.classes3_0 = classes3_0;
	}
	public List<String> getClasses3_1() {
		return classes3_1;
	}
	public void setClasses3_1(List<String> classes3_1) {
		this.classes3_1 = classes3_1;
	}
	public List<String> getClasses3_2() {
		return classes3_2;
	}
	public void setClasses3_2(List<String> classes3_2) {
		this.classes3_2 = classes3_2;
	}
	public List<String> getClasses3_3() {
		return classes3_3;
	}
	public void setClasses3_3(List<String> classes3_3) {
		this.classes3_3 = classes3_3;
	}
	public List<String> getClasses4_0() {
		return classes4_0;
	}
	public void setClasses4_0(List<String> classes4_0) {
		this.classes4_0 = classes4_0;
	}
	public List<String> getClasses4_1() {
		return classes4_1;
	}
	public void setClasses4_1(List<String> classes4_1) {
		this.classes4_1 = classes4_1;
	}
	public List<String> getClasses4_2() {
		return classes4_2;
	}
	public void setClasses4_2(List<String> classes4_2) {
		this.classes4_2 = classes4_2;
	}
	public List<String> getClasses4_3() {
		return classes4_3;
	}
	public void setClasses4_3(List<String> classes4_3) {
		this.classes4_3 = classes4_3;
	}
	@Override
	public String toString() {
		return "OrdinaryCourse [course=" + course + ", classs=" + classs + ", equation=" + equation + ", decide1="
				+ decide1 + ", classs2=" + classs2 + ", npeople=" + npeople + ", decide2=" + decide2 + ", classes1_0="
				+ classes1_0 + ", classes1_1=" + classes1_1 + ", classes1_2=" + classes1_2 + ", classes1_3="
				+ classes1_3 + ", classes2_0=" + classes2_0 + ", classes2_1=" + classes2_1 + ", classes2_2="
				+ classes2_2 + ", classes2_3=" + classes2_3 + ", classes3_0=" + classes3_0 + ", classes3_1="
				+ classes3_1 + ", classes3_2=" + classes3_2 + ", classes3_3=" + classes3_3 + ", classes4_0="
				+ classes4_0 + ", classes4_1=" + classes4_1 + ", classes4_2=" + classes4_2 + ", classes4_3="
				+ classes4_3 + "]";
	}

}
