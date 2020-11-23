package com.rjxy.domain;

public class Train {
	private String type;//课程类型
	private double day;//校外写生天数
	private double nclass;//校外写生班级数
	private double teachers;//校外写生代课老师数
	private double reality;//实训计划学时
	private int classStart;//班级区段开始
	private int classFinish;//班级区段结束
	private String peoplem;//新加人数的描述
	private double npeople;//新加人数
	public Train() {
		super();
	}
	public Train(String type, double day, double nclass, double teachers, double reality, int classStart,
			int classFinish, String peoplem, double npeople) {
		super();
		this.type = type;
		this.day = day;
		this.nclass = nclass;
		this.teachers = teachers;
		this.reality = reality;
		this.classStart = classStart;
		this.classFinish = classFinish;
		this.peoplem = peoplem;
		this.npeople = npeople;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getDay() {
		return day;
	}
	public void setDay(double day) {
		this.day = day;
	}
	public double getNclass() {
		return nclass;
	}
	public void setNclass(double nclass) {
		this.nclass = nclass;
	}
	public double getTeachers() {
		return teachers;
	}
	public void setTeachers(double teachers) {
		this.teachers = teachers;
	}
	public double getReality() {
		return reality;
	}
	public void setReality(double reality) {
		this.reality = reality;
	}
	public int getClassStart() {
		return classStart;
	}
	public void setClassStart(int classStart) {
		this.classStart = classStart;
	}
	public int getClassFinish() {
		return classFinish;
	}
	public void setClassFinish(int classFinish) {
		this.classFinish = classFinish;
	}
	public String getPeoplem() {
		return peoplem;
	}
	public void setPeoplem(String peoplem) {
		this.peoplem = peoplem;
	}
	public double getNpeople() {
		return npeople;
	}
	public void setNpeople(double npeople) {
		this.npeople = npeople;
	}
	@Override
	public String toString() {
		return "Train [type=" + type + ", day=" + day + ", nclass=" + nclass + ", teachers=" + teachers + ", reality="
				+ reality + ", classStart=" + classStart + ", classFinish=" + classFinish + ", peoplem=" + peoplem
				+ ", npeople=" + npeople + "]";
	}


}
