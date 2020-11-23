package com.rjxy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rjxy.domain.Count;
import com.rjxy.domain.CourseTable;
import com.rjxy.domain.Direction;
import com.rjxy.domain.Equation;
import com.rjxy.domain.Other;
import com.rjxy.domain.PageBean;
import com.rjxy.domain.Parameters;
import com.rjxy.domain.PositionTable;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

/**
 * @author
 *	用于对参数的查询修改添加删除
 */
public class MsgService {
	
	private SqlUtil sqlUtil = new SqlUtil();
	//查询(双挑课)
	public List<PositionTable> getPosition(PageBean pageBean) throws IOException {
		List<PositionTable> positionTables = new ArrayList<>();
	 	positionTables = sqlUtil.selectAllPositionTableByPage(pageBean);
		return positionTables;
	}
	//身份类的pageBean
	public PageBean getPageBeanByOne(String pageNow) throws IOException {
		PageBean pageBean = new PageBean();
		if(pageNow != null) {
			pageBean.setPageNow(Integer.valueOf(pageNow));
		}
		int rowCount = sqlUtil.getPositionTableRow();
		pageBean.setPageSize(15);
		pageBean.setPageCount(((rowCount - 1)/pageBean.getPageSize() ) + 1);
		pageBean.setPageNow((pageBean.getPageNow()-1)*pageBean.getPageSize());
		pageBean.setRowCount(rowCount);
		return pageBean;
	}
	//删除(双挑课)
	public void deletePosition(String id) throws IOException {
		PositionTable positionTable = new PositionTable();
		positionTable.setPositionID(id);
		sqlUtil.deletePositionTable(positionTable);
	}
	//修改(双挑课)
	public void updatePosition(String id,String name,String time)  {
		PositionTable positionTable = new PositionTable(id,name,Double.valueOf(time));
		try {
			sqlUtil.updatePositionTable(positionTable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加(双挑课)
	public void insertPosition(String id,String name,String time)  {
		PositionTable positionTable = new PositionTable(id,name,Double.valueOf(time));
		try {
			sqlUtil.insertPositionTable(positionTable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//查询(其他身份)
	public List<Parameters> getParameters() throws IOException {
		List<Parameters> parameters = new ArrayList<>();
		parameters = sqlUtil.selectAllParameters();
		return parameters;
	}
	//删除(其他身份)
	public void deleteParameters(String id) throws IOException {
		Parameters parameters = new Parameters();
		parameters.setParametersID(id);
		sqlUtil.deleteParameters(parameters);
	}
	//修改(其他身份)
	public void updateParameters(String id,String name,String time)  {
		Parameters parameters = new Parameters(id,Double.valueOf(time),name);
		try {
			sqlUtil.updateParameters(parameters);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加(其他身份)
	public void insertParameters(String id,String name,String time)  {
		Parameters parameters = new Parameters(id,Double.valueOf(time),name);
		try {
			sqlUtil.insertParameters(parameters);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//课程类的pageBean
	public PageBean getPageBean(String pageNow) throws IOException {
		PageBean pageBean = new PageBean();
		if(pageNow != null) {
			pageBean.setPageNow(Integer.valueOf(pageNow));
		}
		int rowCount = sqlUtil.getCourseTableRow();
		pageBean.setPageSize(15);
		pageBean.setPageCount(((rowCount - 1)/pageBean.getPageSize() ) + 1);
		pageBean.setPageNow((pageBean.getPageNow()-1)*pageBean.getPageSize());
		pageBean.setRowCount(rowCount);
		return pageBean;
	}
	

	
	//查询(课程课)
	public List<CourseTable> getCourse(PageBean pageBean) throws IOException {
		List<CourseTable> CourseTables = new ArrayList<>();
		CourseTables = sqlUtil.selectAllCourseTableByPage(pageBean);
		return CourseTables;
	}
	//删除(课程课)
	public void deleteCourseTable(String id) throws IOException {
		CourseTable courseTable = new CourseTable();
		courseTable.setCourseID(id);
		sqlUtil.deleteCourseTable(courseTable);
	}
	//修改(课程课)
	public void updateCourseTable(String id,String name,String timeTotal,String timeReality,String timeExperiment)  {
		CourseTable courseTable = new CourseTable(id,name,Double.valueOf(timeTotal),Double.valueOf(timeReality),Double.valueOf(timeExperiment));
		try {
			sqlUtil.updateCourseTable(courseTable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加(课程课)
	public void insertCourseTable(String id,String name,String timeTotal,String timeReality,String timeExperiment)  {
		CourseTable courseTable = new CourseTable(id,name,Double.valueOf(timeTotal),Double.valueOf(timeReality),Double.valueOf(timeExperiment));
		try {
			sqlUtil.insertCourseTable(courseTable);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//查询(计算公式课)
	public List<Equation> getEquation() throws IOException {
		List<Equation> equations = new ArrayList<>();
		equations = sqlUtil.selectAllEquation();
		return equations;
	}
	//删除(计算公式课)
	public void deleteEquation(String id) throws IOException {
		Equation equation = new Equation();
		equation.setNumberA(id);
		sqlUtil.deleteEquation(equation);
	}
	//修改(计算公式课)
	public void updateEquation(String id,String type,String formula)  {
		Equation equation = new Equation(type,formula,id);
		try {
			sqlUtil.updateEquation(equation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加(计算公式课)
	public void insertEquation(String id,String type,String formula)  {
		Equation equation = new Equation(type,formula,id);
		try {
			sqlUtil.instertEquation(equation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//查询(课程)
	public List<Count> getCounts(User user) throws IOException {
		List<Count> equations = new ArrayList<>();
		equations = sqlUtil.selectAllCount(user);
		return equations;
	}
	//删除(课程)
	public void deleteCounts(String uid,String name, String classs){
		Count count = new Count();
		count.setUid(uid);
		count.setCourse(name);
		count.setClasss(classs);
		try {
			sqlUtil.deleteCountByOne(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//修改(课程)
	public void updateCounts(String uid,String name,String classes,String classs)  {
		Count count = new Count();
		count.setUid(uid);
		count.setCourse(name);
		count.setClasses(classes);
		count.setClasss(classs);
		try {
			sqlUtil.updateCountByOne(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//查询(方向)---
	public List<Direction> getDirection() throws IOException {
		List<Direction> directions = new ArrayList<>();
		directions = sqlUtil.selectAllDirection();
		return directions;
	}
	//修改(方向)
	public void updateDirection(String id,String name)  {
		Direction direction = new Direction(Integer.valueOf(id), name);
		try {
			sqlUtil.updateDirection(direction);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//添加(方向)
	public void insertDirection(String name)  {
		Direction direction = new Direction();
		direction.setName(name);
		try {
			sqlUtil.insertDirection(direction);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//修改用户的方向
	public void updateUserMajor(String name,String nameOld) {
		User user = new User();
		user.setMajor(name);
		user.setMajorOld(nameOld);
		try {
			sqlUtil.updateUserMajor(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询其它
	public List<Other> getOther(User user) throws IOException {
		List<Other> otherAl = sqlUtil.selectAllOther(user);

		return otherAl;
	}
	//更新其它
	public void updateOther(String uid,String quantity,String quantityed) throws IOException {
		Other other = new Other();
		other.setUid(uid);
		other.setQuantity(quantity);
		other.setQuantityed(quantityed);
		sqlUtil.updateOtherByOne(other);
	}
	//删除其他
	public void deleteOther(User user) throws IOException {
		sqlUtil.deleteAllOther(user.getUid());
	}
}
