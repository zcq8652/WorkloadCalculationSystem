package com.rjxy.service;

import java.text.DecimalFormat;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import com.rjxy.domain.Count;
import com.rjxy.domain.Equation;

public class CalculateService {
	public void realityService(Count count,Equation equation) {
		//添加运算所需要的数据
		JexlContext jexlContext = new MapContext();
		jexlContext.set("npeople", count.getNpeople());
		jexlContext.set("reality", count.getReality());
		jexlContext.set("experiment", count.getExperiment());		
		jexlContext.set("nclass", count.getNclass());
		jexlContext.set("nday", count.getNday());
		jexlContext.set("nteacher", count.getNteacher());
		jexlContext.set("ngroup", count.getNgroup());
		jexlContext.set("nteam", count.getNteam());
		jexlContext.set("nweekA", count.getNweekA());
		jexlContext.set("nweekB", count.getNweekB());
		//设置字符串公式可计算化
		Expression expression = new JexlEngine().createExpression(equation.getFormula());
		//导入数据到公式进行计算
		double realityResult = (double) expression.evaluate(jexlContext);
		//设置double保留两位小数
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		realityResult = Double.valueOf(decimalFormat.format(realityResult));
		//保存计算结果
		count.setRealityResult(count.getRealityResult()+realityResult);
		//整合保存课时数据，以便存储到数据库
		FurmulaService furmulaService = new FurmulaService();
		if(count.getRealityQuantity()==null) {
			count.setRealityQuantity("");
			count.setRealityQuantity(count.getRealityQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(realityResult)+"<br>");
		}else {
			count.setRealityQuantity(count.getRealityQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(realityResult)+"<br>");
		}
	}
	public void experimentService(Count count,Equation equation) {
		//添加运算所需要的数据
		JexlContext jexlContext = new MapContext();
		jexlContext.set("npeople", count.getNpeople());
		jexlContext.set("reality", count.getReality());
		jexlContext.set("experiment", count.getExperiment());		
		jexlContext.set("nclass", count.getNclass());
		jexlContext.set("nday", count.getNday());
		jexlContext.set("nteacher", count.getNteacher());
		jexlContext.set("ngroup", count.getNgroup());
		jexlContext.set("nteam", count.getNteam());
		jexlContext.set("nweekA", count.getNweekA());
		jexlContext.set("nweekB", count.getNweekB());
		//设置字符串公式可计算化
		Expression expression = new JexlEngine().createExpression(equation.getFormula());
		//导入数据到公式进行计算
		double experimentResult = (double) expression.evaluate(jexlContext);
		//设置double保留两位小数
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		experimentResult = Double.valueOf(decimalFormat.format(experimentResult));
		//保存计算结果
		count.setExperimentResult(count.getExperimentResult()+experimentResult);
		//整合保存课时数据，以便存储到数据库
		FurmulaService furmulaService = new FurmulaService();
		if(count.getExperimentQuantity()==null) {
			count.setExperimentQuantity("");
			count.setExperimentQuantity(count.getExperimentQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(experimentResult)+"<br>");
		}else {
			count.setExperimentQuantity(count.getExperimentQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(experimentResult)+"<br>");
		}
	}
}
