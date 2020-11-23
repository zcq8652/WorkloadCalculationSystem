package com.rjxy.domain;

public class CourseTable {
	private String courseID;
	private String  course;
	private double total;
	private double reality;
	private double experiment;
	public CourseTable() {
		super();
	}
	public CourseTable(String courseID, String course, double total, double reality, double experiment) {
		super();
		this.courseID = courseID;
		this.course = course;
		this.total = total;
		this.reality = reality;
		this.experiment = experiment;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getReality() {
		return reality;
	}
	public void setReality(double reality) {
		this.reality = reality;
	}
	public double getExperiment() {
		return experiment;
	}
	public void setExperiment(double experiment) {
		this.experiment = experiment;
	}
	@Override
	public String toString() {
		return "CourseTable [courseID=" + courseID + ", course=" + course + ", total=" + total + ", reality=" + reality
				+ ", experiment=" + experiment + "]";
	}

}
