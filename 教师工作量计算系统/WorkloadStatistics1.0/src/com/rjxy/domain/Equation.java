package com.rjxy.domain;

public class Equation {
	private String type;//公式对应课程类型
	private String formula;//公式
	private String numberA;//公式编号
	public Equation() {
		super();
	}
	public Equation(String type, String formula, String numberA) {
		super();
		this.type = type;
		this.formula = formula;
		this.numberA = numberA;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public String getNumberA() {
		return numberA;
	}
	public void setNumberA(String numberA) {
		this.numberA = numberA;
	}
	@Override
	public String toString() {
		return "Equation [type=" + type + ", formula=" + formula + ", numberA=" + numberA + "]";
	}
}
