package com.rjxy.domain;

import java.util.List;

public class Other {
	private double npeople;//ָ����ʦ����
	private String researchOption;//�жϽ�ʦ�Ƿ�μ��˽�ѧ�����о�
	private double periodical;//�����ڿ�������
	private double researchSubject1;//��ѧ�о���������
	private double paper;//����һ����������
	private double researchSubject2;//���Ҽ���ѧ�о�
	private String cumulativeOption;//�ж�˫������ʦ�������Ƿ��ۼ�
	private List<String> list;//˫������ʦ
	private String group;//�γ���
	private String flock;//�γ�Ⱥ
	private String course;//��д�Ľ̲ĵ�����
	private String courseOption;//�ж�
	private String specialString;//�����������д����̲ģ���ţ�õ�
	private double specialValue;//��ţ��д�̲Ķ�Ӧѧʱ
	//�洢�����ݿ�Ĳ���
	private String quantity;
	private String quantityed;
	private String uid;
	private double result=0;
	public Other() {
		super();
	}
	public Other(double npeople, String researchOption, double periodical, double researchSubject1, double paper,
			double researchSubject2, String cumulativeOption, List<String> list, String group, String flock,
			String course, String courseOption, String specialString, double specialValue, String quantity, String uid,
			double result,String quantityed) {
		super();
		this.npeople = npeople;
		this.researchOption = researchOption;
		this.periodical = periodical;
		this.researchSubject1 = researchSubject1;
		this.paper = paper;
		this.researchSubject2 = researchSubject2;
		this.cumulativeOption = cumulativeOption;
		this.list = list;
		this.group = group;
		this.flock = flock;
		this.course = course;
		this.courseOption = courseOption;
		this.specialString = specialString;
		this.specialValue = specialValue;
		this.quantity = quantity;
		this.uid = uid;
		this.result = result;
		this.quantityed = quantityed;
	}
	public double getNpeople() {
		return npeople;
	}
	public void setNpeople(double npeople) {
		this.npeople = npeople;
	}
	public String getResearchOption() {
		return researchOption;
	}
	public void setResearchOption(String researchOption) {
		this.researchOption = researchOption;
	}
	public double getPeriodical() {
		return periodical;
	}
	public void setPeriodical(double periodical) {
		this.periodical = periodical;
	}
	public double getResearchSubject1() {
		return researchSubject1;
	}
	public void setResearchSubject1(double researchSubject1) {
		this.researchSubject1 = researchSubject1;
	}
	public double getPaper() {
		return paper;
	}
	public void setPaper(double paper) {
		this.paper = paper;
	}
	public double getResearchSubject2() {
		return researchSubject2;
	}
	public void setResearchSubject2(double researchSubject2) {
		this.researchSubject2 = researchSubject2;
	}
	public String getCumulativeOption() {
		return cumulativeOption;
	}
	public void setCumulativeOption(String cumulativeOption) {
		this.cumulativeOption = cumulativeOption;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getFlock() {
		return flock;
	}
	public void setFlock(String flock) {
		this.flock = flock;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCourseOption() {
		return courseOption;
	}
	public void setCourseOption(String courseOption) {
		this.courseOption = courseOption;
	}
	public String getSpecialString() {
		return specialString;
	}
	public void setSpecialString(String specialString) {
		this.specialString = specialString;
	}
	public double getSpecialValue() {
		return specialValue;
	}
	public void setSpecialValue(double specialValue) {
		this.specialValue = specialValue;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	public String getQuantityed() {
		return quantityed;
	}
	public void setQuantityed(String quantityed) {
		this.quantityed = quantityed;
	}
	@Override
	public String toString() {
		return "Other [npeople=" + npeople + ", researchOption=" + researchOption + ", periodical=" + periodical
				+ ", researchSubject1=" + researchSubject1 + ", paper=" + paper + ", researchSubject2="
				+ researchSubject2 + ", cumulativeOption=" + cumulativeOption + ", list=" + list + ", group=" + group
				+ ", flock=" + flock + ", course=" + course + ", courseOption=" + courseOption + ", specialString="
				+ specialString + ", specialValue=" + specialValue + ", quantity=" + quantity + ", uid=" + uid
				+ ", result=" + result + "]";
	}


	
}
