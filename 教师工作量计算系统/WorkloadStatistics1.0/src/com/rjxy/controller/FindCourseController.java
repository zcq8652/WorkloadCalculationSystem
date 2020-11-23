package com.rjxy.controller;

import com.rjxy.domain.*;
import com.rjxy.mybatis.SqlUtil;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/find")
public class FindCourseController {
	private User user;
	
	//得到自己的课时
	@RequestMapping("/myCourse")
	public String getMyCourse(Model model,HttpServletRequest request) throws IOException {
		//得到user
		User user =  (User) request.getSession().getAttribute("user");
		SqlUtil sqlUtil = new SqlUtil();
		List<Count> myCounts = sqlUtil.selectAllCount(user);
		List<Other> myOthers = sqlUtil.selectAllOther(user);
		//存放用户信息与对应课程课时
		Map<User, Map<List<Count>,List<Other>>> allMap= new HashMap<>();
		//存放课时信息
		Map<List<Count>,List<Other>> countsMap = new HashMap<>();
		countsMap.put(myCounts,myOthers);
		allMap.put(user, countsMap);
		//得到自己的课时时间
		double mytime = sqlUtil.countTime(user)+sqlUtil.countOther(user);
		//设置double保留两位小数
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		mytime = Double.valueOf(decimalFormat.format(mytime));
		request.setAttribute("allMap", allMap);
		request.setAttribute("time", mytime);
		model.addAttribute("path","CourseDeatil.jsp");
		return "main";
	}
	
	//得到方向的课时
	@RequestMapping("/typeCourse")
	public String getMajorCourse(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//String major = new String(request.getParameter("major").getBytes("ISO-8859-1"),"utf-8");
		String major = request.getParameter("major");
		SqlUtil sqlUtil = new SqlUtil();
		List<User> userAl = sqlUtil.selectAllMajorTeacher(major);
		Map<User, Map<List<Count>,List<Other>>> allMap= new HashMap<>();
		for(int i = 0 ; i < userAl.size() ; i ++) {
			User user = userAl.get(i);
			Map<List<Count>,List<Other>> countsMap = new HashMap<>();
			List<Count> myCounts = sqlUtil.selectAllCount(user);
			List<Other> myOthers = sqlUtil.selectAllOther(user);
			double mytime = sqlUtil.countTime(user) + sqlUtil.countOther(user);
			//设置double保留两位小数
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			mytime = Double.valueOf(decimalFormat.format(mytime));
			user.setTime(mytime);
			countsMap.put(myCounts, myOthers);
			allMap.put(user, countsMap);
		}
		request.setAttribute("allMap", allMap);
		model.addAttribute("path","MajorDetail.jsp");
		return "main";
	}
	
	//得到方向的课时或者总
	@RequestMapping("/allCourse")
	public String getAllCourse(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		SqlUtil sqlUtil = new SqlUtil();
		List<User> userAl = sqlUtil.selectAllUser();
		Map<User, Map<List<Count>,List<Other>>> allMap= new HashMap<>();
		for(int i = 0 ; i < userAl.size() ; i ++) {
			User user = userAl.get(i);
			Map<List<Count>,List<Other>> countsMap = new HashMap<>();
			List<Count> myCounts = sqlUtil.selectAllCount(user);
			List<Other> myOthers = sqlUtil.selectAllOther(user);
			double mytime = sqlUtil.countTime(user) + sqlUtil.countOther(user);
			//设置double保留两位小数
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			mytime = Double.valueOf(decimalFormat.format(mytime));
			user.setTime(mytime);
			countsMap.put(myCounts, myOthers);
			allMap.put(user, countsMap);
		}
		request.setAttribute("allMap", allMap);
		model.addAttribute("path","AllDetail.jsp");
		return "main";
	}
}
