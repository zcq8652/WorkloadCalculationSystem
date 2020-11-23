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
		//�����������Ҫ������
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
		//�����ַ�����ʽ�ɼ��㻯
		Expression expression = new JexlEngine().createExpression(equation.getFormula());
		//�������ݵ���ʽ���м���
		double realityResult = (double) expression.evaluate(jexlContext);
		//����double������λС��
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		realityResult = Double.valueOf(decimalFormat.format(realityResult));
		//���������
		count.setRealityResult(count.getRealityResult()+realityResult);
		//���ϱ����ʱ���ݣ��Ա�洢�����ݿ�
		FurmulaService furmulaService = new FurmulaService();
		if(count.getRealityQuantity()==null) {
			count.setRealityQuantity("");
			count.setRealityQuantity(count.getRealityQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(realityResult)+"<br>");
		}else {
			count.setRealityQuantity(count.getRealityQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(realityResult)+"<br>");
		}
	}
	public void experimentService(Count count,Equation equation) {
		//�����������Ҫ������
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
		//�����ַ�����ʽ�ɼ��㻯
		Expression expression = new JexlEngine().createExpression(equation.getFormula());
		//�������ݵ���ʽ���м���
		double experimentResult = (double) expression.evaluate(jexlContext);
		//����double������λС��
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		experimentResult = Double.valueOf(decimalFormat.format(experimentResult));
		//���������
		count.setExperimentResult(count.getExperimentResult()+experimentResult);
		//���ϱ����ʱ���ݣ��Ա�洢�����ݿ�
		FurmulaService furmulaService = new FurmulaService();
		if(count.getExperimentQuantity()==null) {
			count.setExperimentQuantity("");
			count.setExperimentQuantity(count.getExperimentQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(experimentResult)+"<br>");
		}else {
			count.setExperimentQuantity(count.getExperimentQuantity()+furmulaService.countService(count, equation.getFormula())+"="+String.valueOf(experimentResult)+"<br>");
		}
	}
}
