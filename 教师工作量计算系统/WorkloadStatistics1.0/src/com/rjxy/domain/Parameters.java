package com.rjxy.domain;

public class Parameters {
	private String parametersID;
	private double parametersValue;
	private String parametersName;
	public Parameters() {
		super();
	}
	public Parameters(String parametersID, double parametersValue, String parametersName) {
		super();
		this.parametersID = parametersID;
		this.parametersValue = parametersValue;
		this.parametersName = parametersName;
	}
	public String getParametersID() {
		return parametersID;
	}
	public void setParametersID(String parametersID) {
		this.parametersID = parametersID;
	}
	public double getParametersValue() {
		return parametersValue;
	}
	public void setParametersValue(double parametersValue) {
		this.parametersValue = parametersValue;
	}
	public String getParametersName() {
		return parametersName;
	}
	public void setParametersName(String parametersName) {
		this.parametersName = parametersName;
	}
	@Override
	public String toString() {
		return "Parameters [parametersID=" + parametersID + ", parametersValue=" + parametersValue + ", parametersName="
				+ parametersName + "]";
	}

	
}
