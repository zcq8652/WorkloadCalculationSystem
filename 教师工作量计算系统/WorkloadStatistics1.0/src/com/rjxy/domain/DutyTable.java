package com.rjxy.domain;

public class DutyTable {
	private String dutyID;
	private String dutyName;
	private String dutyMoney;
	public DutyTable() {
		super();
	}
	public DutyTable(String dutyID, String dutyName, String dutyMoney) {
		super();
		this.dutyID = dutyID;
		this.dutyName = dutyName;
		this.dutyMoney = dutyMoney;
	}
	public String getDutyID() {
		return dutyID;
	}
	public void setDutyID(String dutyID) {
		this.dutyID = dutyID;
	}
	public String getDutyName() {
		return dutyName;
	}
	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}
	public String getDutyMoney() {
		return dutyMoney;
	}
	public void setDutyMoney(String dutyMoney) {
		this.dutyMoney = dutyMoney;
	}
	@Override
	public String toString() {
		return "DutyTable [dutyID=" + dutyID + ", dutyName=" + dutyName + ", dutyMoney=" + dutyMoney + "]";
	}
	
}
