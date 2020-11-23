package com.rjxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.Count;
import com.rjxy.domain.Direction;
import com.rjxy.domain.OrdinaryCourse;
import com.rjxy.domain.Other;
import com.rjxy.domain.Train;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;
import com.rjxy.service.OrdinaryCourseService;
import com.rjxy.service.OtherService;
import com.rjxy.service.SubmitInformationService;
import com.rjxy.service.SubmitInformationService2;
import com.rjxy.service.TrainService;


@Controller
@RequestMapping("/Jsp")
public class JspController {
	@RequestMapping("/OrdinaryCourse")
	public String OrdinaryCourseController(Model model,HttpServletRequest req) throws IOException {
		//调用数据库数据，取得动态回填数据
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.courseTable(model);
		o.classTable1(model);
		o.classTable2(model);
		o.classTable3(model);
		o.classTable4(model);
		o.equation(model);
		model.addAttribute("path","OrdinaryCourse.jsp");
		model.addAttribute("OrdinaryCourse", new OrdinaryCourse());
		model.addAttribute("count", new Count());
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/Train")
	public String TrainController(Model model,HttpServletRequest req) throws IOException {
		//调用数据库数据，取得动态回填数据
		TrainService trainService = new TrainService();
		trainService.classTable1(model);
		trainService.classTable2(model);
		trainService.equation(model);
		model.addAttribute("path","Train.jsp");
		model.addAttribute("train", new Train());
		model.addAttribute("count", new Count());
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/GraduationProject")
	public String GraduationProjectController(Model model,HttpServletRequest req) throws IOException {
		//调用数据库数据，取得动态回填数据
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		model.addAttribute("path","GraduationProject.jsp");
		model.addAttribute("countQ", new Count());
		model.addAttribute("countH", new Count());
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/SocialPractice")
	public String SocialPracticeController(Model model,HttpServletRequest req) throws IOException {
		//调用数据库数据，取得动态回填数据
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		model.addAttribute("path","SocialPractice.jsp");
		model.addAttribute("countQ", new Count());
		model.addAttribute("countH", new Count());
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/Other")
	public String OtherController(Model model,HttpServletRequest req) throws IOException {
		//调用数据库数据，取得动态回填数据
		OtherService otherService = new OtherService();
		otherService.courseTable(model);
		otherService.positionTable(model);
		otherService.parameters(model);
		model.addAttribute("path","Other.jsp");
		model.addAttribute("otherQ", new Other());
		model.addAttribute("otherH", new Other());
		req.setAttribute("option",2);
		return "main";
	}	
	@RequestMapping("/Information")
	public String InformationController(Model model,HttpServletRequest req) {
		model.addAttribute("path","information.jsp");
		model.addAttribute("user", new User());
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/initial")
	public String InitialController(Model model,HttpServletRequest req) throws IOException{
		User user = (User)req.getSession().getAttribute("user");
		//获取当前用户的最新数据
		SqlUtil sqlUtil = new SqlUtil();
		User user2 = sqlUtil.select_uid(user.getUid());
		req.setAttribute("user", user2);
		model.addAttribute("path","Initial.jsp");
		return "main";
	}
	@RequestMapping("/submitInformation")
	public String SubmitInformationController(Model model) throws IOException {
		//回填四种状态的数量
		SubmitInformationService submitInformationService = new SubmitInformationService();
		submitInformationService.SubSelectService(model);
		model.addAttribute("path","SubmitInformation.jsp");
		return "main";
	}
	@RequestMapping("/submitInformation2")
	public String SubmitInformation2Controller(Model model,HttpServletRequest req) throws IOException {
		//回填四种状态的数量
		SubmitInformationService2 submitInformationService = new SubmitInformationService2();
		submitInformationService.SubSelectService(model,req);
		model.addAttribute("path","SubmitInformation2.jsp");
		return "main";
	}
	@RequestMapping("/check")
	public String CheckController(Model model) {
		model.addAttribute("path", "Check.jsp");
		return "main";
	}
	@RequestMapping("/check2")
	public String Check2Controller(Model model) {
		model.addAttribute("path", "Check2.jsp");
		return "main";
	}
	@RequestMapping("/toInitial")
	public String CourseDeatilToInitial(Model model,HttpServletRequest req) throws IOException {
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//获取当前用户最新状态
		User user = (User) req.getSession().getAttribute("user");
		//修改用户工作量状态
		User user2 = sqlUtil.select_uid(user.getUid());
		//根据用户当前状态选择目标状态
		if(user2.getStatus().equals("2_1")||user2.getStatus().equals("0")) {
			user2.setStatus("1_1");
			//修改数据库当前教师的工作量状态
			sqlUtil.updateUserStatusOne(user2);
		}else if(user2.getStatus().equals("2_2")) {
			user2.setStatus("1_2");
			//修改数据库当前教师的工作量状态
			sqlUtil.updateUserStatusOne(user2);
		}
		model.addAttribute("path","Initial.jsp");
		req.setAttribute("user", user2);
		return "main";
	}
	
	//注册用户
	@RequestMapping("/toRegister")
	public String toRegister(Model model,HttpServletRequest req) throws IOException{
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//获取现有方向
		List<Direction> list = sqlUtil.selectAllDirection();
		List<String> str = new ArrayList<String>();
		for(Direction dir:list){
			str.add(dir.getName());
		}
		model.addAttribute("path","register.jsp");
		model.addAttribute("user",new User());
		req.setAttribute("list", str);
		return "main";
	}
	
	//修改用户权限
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser(Model model,HttpServletRequest req) throws Exception{
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//获取现有用户
		List<User> users = sqlUtil.selectAllUser();
		model.addAttribute("path","updateUser.jsp");
		req.setAttribute("users", users);
		return "main";
		
	}
	
	//修改用户权限
	@RequestMapping("/toResetPassword")
	public String toResetPassword(Model model,HttpServletRequest req) throws Exception{
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//获取现有用户
		List<User> users = sqlUtil.selectAllUser();
		model.addAttribute("path","resetPassword.jsp");
		req.setAttribute("users", users);
		return "main";
		
	}
	
	
	
	
	
}
