package com.rjxy.domain;

public class PositionTable {
	private String positionID;
	private String positionName;
	private double positionTime;
	public PositionTable() {
		super();
	}
	public PositionTable(String positionID, String positionName, double positionTime) {
		super();
		this.positionID = positionID;
		this.positionName = positionName;
		this.positionTime = positionTime;
	}
	public String getPositionID() {
		return positionID;
	}
	public void setPositionID(String positionID) {
		this.positionID = positionID;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public double getPositionTime() {
		return positionTime;
	}
	public void setPositionTime(double positionTime) {
		this.positionTime = positionTime;
	}
	@Override
	public String toString() {
		return "PositionTable [positionID=" + positionID + ", positionName=" + positionName + ", positionTime="
				+ positionTime + "]";
	}

	
}
