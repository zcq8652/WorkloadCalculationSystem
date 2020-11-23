package com.rjxy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.Count;
import com.rjxy.domain.OrdinaryCourse;
import com.rjxy.domain.Other;
import com.rjxy.domain.Train;
import com.rjxy.domain.User;
import com.rjxy.service.InsertService;
import com.rjxy.service.OrdinaryCourseService;
import com.rjxy.service.OtherService;
import com.rjxy.service.TrainService;

@Controller
@RequestMapping("/JspInsert")
public class JspInsertController {
	@RequestMapping("/A")
	public String aInsertController(Count count,Model model,HttpServletRequest req) throws IOException {
		//获取当前教师数据
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//前往存储功能服务器
		InsertService insertService = new InsertService();
		int option = insertService.ordinaryCourseInsert(count,user);
		//前端跳转信息，数据回填信息
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.courseTable(model);
		o.classTable1(model);
		o.classTable2(model);
		o.classTable3(model);
		o.classTable4(model);
		o.equation(model);
		req.setAttribute("option",option);
		model.addAttribute("path","OrdinaryCourse.jsp");
		model.addAttribute("OrdinaryCourse", new OrdinaryCourse());
		model.addAttribute("count", new Count());
		return "main";
	}
	@RequestMapping("/B")
	public String bInsertController(Count count,Model model,HttpServletRequest req) throws IOException {
		//获取当前教师数据
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//前往存储功能服务器
		InsertService insertService = new InsertService();
		int option = insertService.trainInsert(count, user);
		//调用数据库数据，取得动态回填数据
		TrainService trainService = new TrainService();
		trainService.classTable1(model);
		trainService.classTable2(model);
		trainService.equation(model);
		//前端跳转信息，数据回填信息
		model.addAttribute("option",option);
		model.addAttribute("train", new Train());
		model.addAttribute("count", new Count());
		model.addAttribute("path","Train.jsp");
		return "main";
	}
	@RequestMapping("/C")
	public String cInsertController(Count count,Model model,HttpServletRequest req) throws IOException {
		//获取当前教师数据
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//整合数据，检索当前数据是否存在，插入或修改
		InsertService insertService = new InsertService();
		int option = insertService.graduationProjectInsert(count,user);
		//调用数据库数据，取得动态回填数据
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		//前端跳转信息，数据回填信息
		model.addAttribute("option",option);
		model.addAttribute("countQ",new Count());
		model.addAttribute("countH",new Count());
		model.addAttribute("path","GraduationProject.jsp");
		return "main";
	}
	@RequestMapping("/D")
	public String dInsertController(Count count,Model model,HttpServletRequest req) throws IOException {
		//获取当前教师数据
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//整合数据，检索当前数据是否存在，插入或修改
		InsertService insertService = new InsertService();
		//相同的框架结构实体用已经存在的减少代码数量
		int option = insertService.graduationProjectInsert(count,user);
		//调用数据库数据，取得动态回填数据
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		//前端跳转信息，数据回填信息
		model.addAttribute("option",option);
		model.addAttribute("countQ",new Count());
		model.addAttribute("countH",new Count());
		model.addAttribute("path","SocialPractice.jsp");
		return "main";
	}
	@RequestMapping("/E")
	public String eInsertController(Other other,Model model,HttpServletRequest req) throws IOException {
		//获取当前教师数据
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//前往存储功能服务器
		InsertService insertService = new InsertService();
		int option = insertService.otherInsert(other, user);
		//调用数据库数据，取得动态回填数据
		OtherService otherService = new OtherService();
		otherService.courseTable(model);
		otherService.positionTable(model);
		otherService.parameters(model);
		//前端跳转信息，数据回填信息
		model.addAttribute("path", "Other.jsp");
		model.addAttribute("otherQ", new Other());
		model.addAttribute("otherH", new Other());
		req.setAttribute("option",option);
		return "main";
	}
}
