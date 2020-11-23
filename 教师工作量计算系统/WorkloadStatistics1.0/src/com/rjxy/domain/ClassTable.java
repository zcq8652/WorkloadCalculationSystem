package com.rjxy.domain;

public class ClassTable {
	private String grade;
	private String classs;
	private double npeople;
	public ClassTable() {
		super();
	}
	public ClassTable(String grade, String classs, double npeople) {
		super();
		this.grade = grade;
		this.classs = classs;
		this.npeople = npeople;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public double getNpeople() {
		return npeople;
	}
	public void setNpeople(double npeople) {
		this.npeople = npeople;
	}
	@Override
	public String toString() {
		return "ClassTable [grade=" + grade + ", classs=" + classs + ", npeople=" + npeople + "]";
	}	
}
