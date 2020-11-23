package com.rjxy.domain;

public class Count {
	private String uname;//教师姓名
	private String uid;//教师工号
	private String duty;//教师职称
	private String numberA;//公式编号
	private String course;//课程名称   
	private String classes;//新的代课班级
	private String classs;//代课班级
	private String classs_show;//前端显示代课班级
	private double total;//总学时
	private double reality;//理论课时
	private double experiment;//实验课时
	private double npeople;//学生人数
	private String type;//课程类别对应公式编号
	private String ctype="";//课程类别名称
	private double nclass;//校外写生所带班级数
	private double nday;//天数数
	private double ngroup;//组数
	private double nteacher;//校外写生代课老师
	private double nteam;//毕业设计团队组数
	private double nweekA;//毕业设计个人设计周数
	private double nweekB;//毕业设计团队设计周数
	private String quantity;//	课时
	private String realityQuantity;//理论课时中间存储量
	private String experimentQuantity;//实验课时中间存储量
	private double result=0;//计算结果
	private String resultString;//前端显示计算结果
	private double realityResult;//理论课计算学时
	private double experimentResult;//实验课计算学时
	private String judge;//用来判断前端提交的数据使用来计算还是用来存储
	public Count() {
		super();
	}
	public Count(String uname, String uid, String duty, String numberA, String course, String classes, String classs,
			String classs_show, double total, double reality, double experiment, double npeople, String type,
			String ctype, double nclass, double nday, double ngroup, double nteacher, double nteam, double nweekA,
			double nweekB, String quantity, String realityQuantity, String experimentQuantity, double result,
			String resultString, double realityResult, double experimentResult, String judge) {
		super();
		this.uname = uname;
		this.uid = uid;
		this.duty = duty;
		this.numberA = numberA;
		this.course = course;
		this.classes = classes;
		this.classs = classs;
		this.classs_show = classs_show;
		this.total = total;
		this.reality = reality;
		this.experiment = experiment;
		this.npeople = npeople;
		this.type = type;
		this.ctype = ctype;
		this.nclass = nclass;
		this.nday = nday;
		this.ngroup = ngroup;
		this.nteacher = nteacher;
		this.nteam = nteam;
		this.nweekA = nweekA;
		this.nweekB = nweekB;
		this.quantity = quantity;
		this.realityQuantity = realityQuantity;
		this.experimentQuantity = experimentQuantity;
		this.result = result;
		this.resultString = resultString;
		this.realityResult = realityResult;
		this.experimentResult = experimentResult;
		this.judge = judge;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getNumberA() {
		return numberA;
	}
	public void setNumberA(String numberA) {
		this.numberA = numberA;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getClasss() {
		return classs;
	}
	public void setClasss(String classs) {
		this.classs = classs;
	}
	public String getClasss_show() {
		return classs_show;
	}
	public void setClasss_show(String classs_show) {
		this.classs_show = classs_show;
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
	public double getNpeople() {
		return npeople;
	}
	public void setNpeople(double npeople) {
		this.npeople = npeople;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public double getNclass() {
		return nclass;
	}
	public void setNclass(double nclass) {
		this.nclass = nclass;
	}
	public double getNday() {
		return nday;
	}
	public void setNday(double nday) {
		this.nday = nday;
	}
	public double getNgroup() {
		return ngroup;
	}
	public void setNgroup(double ngroup) {
		this.ngroup = ngroup;
	}
	public double getNteacher() {
		return nteacher;
	}
	public void setNteacher(double nteacher) {
		this.nteacher = nteacher;
	}
	public double getNteam() {
		return nteam;
	}
	public void setNteam(double nteam) {
		this.nteam = nteam;
	}
	public double getNweekA() {
		return nweekA;
	}
	public void setNweekA(double nweekA) {
		this.nweekA = nweekA;
	}
	public double getNweekB() {
		return nweekB;
	}
	public void setNweekB(double nweekB) {
		this.nweekB = nweekB;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getRealityQuantity() {
		return realityQuantity;
	}
	public void setRealityQuantity(String realityQuantity) {
		this.realityQuantity = realityQuantity;
	}
	public String getExperimentQuantity() {
		return experimentQuantity;
	}
	public void setExperimentQuantity(String experimentQuantity) {
		this.experimentQuantity = experimentQuantity;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public String getResultString() {
		return resultString;
	}
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}
	public double getRealityResult() {
		return realityResult;
	}
	public void setRealityResult(double realityResult) {
		this.realityResult = realityResult;
	}
	public double getExperimentResult() {
		return experimentResult;
	}
	public void setExperimentResult(double experimentResult) {
		this.experimentResult = experimentResult;
	}
	public String getJudge() {
		return judge;
	}
	public void setJudge(String judge) {
		this.judge = judge;
	}
	@Override
	public String toString() {
		return "Count [uname=" + uname + ", uid=" + uid + ", duty=" + duty + ", numberA=" + numberA + ", course="
				+ course + ", classes=" + classes + ", classs=" + classs + ", classs_show=" + classs_show + ", total="
				+ total + ", reality=" + reality + ", experiment=" + experiment + ", npeople=" + npeople + ", type="
				+ type + ", ctype=" + ctype + ", nclass=" + nclass + ", nday=" + nday + ", ngroup=" + ngroup
				+ ", nteacher=" + nteacher + ", nteam=" + nteam + ", nweekA=" + nweekA + ", nweekB=" + nweekB
				+ ", quantity=" + quantity + ", realityQuantity=" + realityQuantity + ", experimentQuantity="
				+ experimentQuantity + ", result=" + result + ", resultString=" + resultString + ", realityResult="
				+ realityResult + ", experimentResult=" + experimentResult + ", judge=" + judge + "]";
	}

}
