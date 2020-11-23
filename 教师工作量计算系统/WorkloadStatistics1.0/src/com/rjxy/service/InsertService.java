package com.rjxy.service;

import java.io.IOException;
import java.sql.SQLTimeoutException;

import com.rjxy.domain.Count;
import com.rjxy.domain.Other;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class InsertService {
	public int ordinaryCourseInsert(Count count,User user) throws IOException {
			//存储数据添加到数据库是否成功
			int optionReality = 0;
			int optionExperiment = 0;
			SqlUtil sqlUtil = new SqlUtil();
			//整合数据，添加用户信息
			count.setDuty(user.getDuty());
			count.setUname(user.getName());
			count.setUid(user.getUid());
			//预先保留课程名称
			String courseString = count.getCourse();
			//分类存储理论课和实验课
			if(count.getRealityResult()!=0) {
				//分类课程名称
				count.setCourse(courseString+"(理论)");
				System.out.println(count.getCourse());
				//检索当前数据是否存在
				Count counts = sqlUtil.selectCount(count);
				//将数据从中间变量中提取出来
				count.setResult(count.getRealityResult());
				count.setQuantity(count.getRealityQuantity());
				//存在则修改，不存在则插入
				if (counts!=null) {
					optionReality = sqlUtil.updateCount(count);
				}else {
					optionReality = sqlUtil.insertCount(count);
				}
			}
			if(count.getExperimentResult()!=0) {
				//分类课程名称
				count.setCourse(courseString+"("+"实验"+")");
				//检索当前数据是否存在
				Count counts = sqlUtil.selectCount(count);
				//将数据从中间变量中提取出来
				count.setResult(count.getExperimentResult());
				count.setQuantity(count.getExperimentQuantity());
				//存在则修改，不存在则插入
				if (counts!=null) {
					optionExperiment = sqlUtil.updateCount(count);				
				}else {
					optionExperiment = sqlUtil.insertCount(count);
				}
			}
			//理论课和实验课任意一个存储成功都返回成功
			if (optionReality==1||optionExperiment==1) {
				return 1;
			}else {
				return 0;
			}
	}
	public int graduationProjectInsert(Count count,User user) throws IOException {
		//存储数据添加到数据库是否成功
		int option = 0;
		//创建数据库连接方式
		SqlUtil sqlUtil = new SqlUtil();
		//整合数据，添加用户信息
		count.setDuty(user.getDuty());
		count.setUname(user.getName());
		count.setUid(user.getUid());
		//判断计算结果是否为空，为空说明计算数据存在错误
		if(count.getResult()==0) {
			return 0;
		}
		//判断数据库是否存在该信息
		if (sqlUtil.selectCount(count)!=null) {
			option = sqlUtil.updateCount(count);
			return option;
		}else {
			option = sqlUtil.insertCount(count);
			return option;
		}
	}
	public int trainInsert(Count count,User user) throws IOException {
		//存储数据添加到数据库是否成功
		int option = 0;
		//创建数据库连接方式
		SqlUtil sqlUtil = new SqlUtil();
		//整合数据，添加用户信息
		count.setDuty(user.getDuty());
		count.setUname(user.getName());
		count.setUid(user.getUid());
		//判断计算结果是否为空，为空说明计算数据存在错误
		if(count.getResult()==0) {
			return 0;
		}
		//判断数据库是否存在该信息
		if (sqlUtil.selectCount(count)!=null) {
			option = sqlUtil.updateCount(count);
			return option;
		}else {
			option = sqlUtil.insertCount(count);
			return option;
		}
	}
	public int otherInsert(Other other,User user) throws IOException {
		//存储数据添加到数据库是否成功
		int option = 0;
		//创建数据库连接方式
		SqlUtil sqlUtil = new SqlUtil();
		//整合数据，添加用户信息
		other.setUid(user.getUid());
		//判断计算结果是否为空，为空说明计算数据存在错误
		if(other.getResult()==0) {
			return 0;
		}
		//判断数据库是否存在该信息
		if(sqlUtil.selectOther(other)!=null) {
			option = sqlUtil.updateOther(other);
			return option;
		}else {
			option = sqlUtil.insertOther(other);
			return option;
		}
	}
}
