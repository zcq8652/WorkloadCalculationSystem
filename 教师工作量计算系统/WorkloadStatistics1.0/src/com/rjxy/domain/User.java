package com.rjxy.domain;

public class User {
	private String uid;//工号
	private String name;//教师姓名
	private String password;//登陆密码
	private String permissions;//身份权限
	private String option;//是否自动登陆
	private String major;//代课方向
	private String majorOld; //曾经的代课方向
	private String duty;//教师职称
	private double time;//总课时
	private String passwords;//用于修改密码
	private String repassword;//确认修改密码
	private String status;//状态码
	private String information="";
	public User() {
		super();
	}
	
	public User(String major, String status) {
		super();
		this.major = major;
		this.status = status;
	}

	public User(String uid, String name, String password, String permissions, String option, String major, String duty,
			double time, String passwords, String repassword, String status, String information , String majorOld) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.permissions = permissions;
		this.option = option;
		this.major = major;
		this.majorOld = major;
		this.duty = duty;
		this.time = time;
		this.passwords = passwords;
		this.repassword = repassword;
		this.status = status;
		this.information = information;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getPasswords() {
		return passwords;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	public String getMajorOld() {
		return majorOld;
	}

	public void setMajorOld(String majorOld) {
		this.majorOld = majorOld;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password + ", permissions=" + permissions
				+ ", option=" + option + ", major=" + major + ", duty=" + duty + ", time=" + time + ", passwords="
				+ passwords + ", repassword=" + repassword + ", status=" + status + ", information=" + information
				+ "]";
	}


}
