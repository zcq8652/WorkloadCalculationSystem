package com.rjxy.domain;

public class Train {
	private String type;//�γ�����
	private double day;//У��д������
	private double nclass;//У��д���༶��
	private double teachers;//У��д��������ʦ��
	private double reality;//ʵѵ�ƻ�ѧʱ
	private int classStart;//�༶���ο�ʼ
	private int classFinish;//�༶���ν���
	private String peoplem;//�¼�����������
	private double npeople;//�¼�����
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
