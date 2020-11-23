package com.rjxy.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.Count;
import com.rjxy.domain.CourseTable;
import com.rjxy.domain.Direction;
import com.rjxy.domain.Equation;
import com.rjxy.domain.Other;
import com.rjxy.domain.PageBean;
import com.rjxy.domain.Parameters;
import com.rjxy.domain.PositionTable;
import com.rjxy.domain.User;
import com.rjxy.service.MsgService;

@Controller
public class MsgController {
	
	private MsgService msgService = new MsgService();
	
	//双肩挑
	//得到双肩挑的信息
	@RequestMapping("/Msg/position")
	public String getPosition(Model model,HttpServletRequest request) throws IOException {
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		if(pageNow != null) {
			pageBean.setPageNow(Integer.valueOf(pageNow));
		} else {
			pageBean.setPageNow(1);
		}				
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//删除双肩挑信息
	@RequestMapping("/Delete/position")
	public String deletePosition(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deletePosition(id);
		//得到删除后信息
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//修改双肩挑信息
	@RequestMapping("/Update/position")
	public String updatePosition(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.updatePosition(id,name,time);
		//得到修改后信息
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//添加双肩挑信息
	@RequestMapping("/Insert/position")
	public String insertPosition(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.insertPosition(id,name,time);
		//得到添加后信息
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	
	//得到其他工作量信息
	@RequestMapping("/Msg/parameters")
	public String getParameters(Model model,HttpServletRequest request) throws IOException {
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}
	//删除其他工作量信息
	@RequestMapping("/Delete/parameters")
	public String deleteParameters(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deleteParameters(id);
		//得到删除后信息
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}	
	//修改其他工作量信息
	@RequestMapping("/Update/parameters")
	public String updateParameters(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//接受参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.updateParameters(id,name,time);
		//得到修改后信息
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}
	//添加其他工作量信息
	@RequestMapping("/Insert/parameters")
	public String insertParameters(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//接受参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.insertParameters(id,name,time);
		//得到添加后信息
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}	
	
	
	//得到课程表的信息
	@RequestMapping("/Msg/course")
	public String getCourseTable(Model model,HttpServletRequest request) throws IOException {
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		if(pageNow != null) {
			pageBean.setPageNow(Integer.valueOf(pageNow));
		} else {
			pageBean.setPageNow(1);
		}	
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//删除课程表信息
	@RequestMapping("/Delete/courseTable")
	public String deleteCourseTable(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deleteCourseTable(id);
		//得到删除后信息
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//修改课程表信息
	@RequestMapping("/Update/courseTable")
	public String updateCourseTable(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//接受参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String timeTotal = request.getParameter("timeTotal");
		String timeReality = request.getParameter("timeReality");
		String timeExperiment = request.getParameter("timeExperiment");
		msgService.updateCourseTable(id,name,timeTotal,timeReality,timeExperiment);
		//得到修改后信息
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//添加课程表信息
	@RequestMapping("/Insert/courseTable")
	public String insertCourseTable(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String timeTotal = request.getParameter("timeTotal");
		String timeReality = request.getParameter("timeReality");
		String timeExperiment = request.getParameter("timeExperiment");
		msgService.insertCourseTable(id,name,timeTotal,timeReality,timeExperiment);
		//得到添加后信息
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
		
		
	
	//得到课程计算公式信息
	@RequestMapping("/Msg/equation")
	public String getEquation(Model model,HttpServletRequest request) throws IOException {
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}
	//删除计算公式信息
	@RequestMapping("/Delete/equation")
	public String deleteEquation(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deleteEquation(id);
		//得到删除后信息
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}	
	//修改计算公式信息
	@RequestMapping("/Update/equation")
	public String updateEquation(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String formula = request.getParameter("formula");
		msgService.updateEquation(id,type,formula);
		//得到修改后信息
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}	
	//添加计算公式信息
	@RequestMapping("/Insert/equation")
	public String insertEquation(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String formula = request.getParameter("formula");
		msgService.insertEquation(id,type,formula);		//得到添加后信息
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}
	
	
	//得到课时信息
	@RequestMapping("/Msg/counts")
	public String getCounts(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}
	
	//删除课时信息
	@RequestMapping("/Delete/counts")
	public String deleteCounts(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		//得到删除后信息
		String uid = user.getUid();
		//课程名称
		//String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8"；
		String name = request.getParameter("name");
		//旧的班级内容
		//String classs = new String(request.getParameter("classs").getBytes("iso-8859-1"),"utf-8");
		
		String classs = request.getParameter("classs");
		msgService.deleteCounts(uid,name,classs);
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
	//修改课时信息
	@RequestMapping("/Update/counts")
	public String updateCounts(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		String uid = user.getUid();
		String name = request.getParameter("name");
		//新的内容
		String classes = request.getParameter("classes");
		//旧的班级内容
		String classs = request.getParameter("classs");
		//接受参数
		msgService.updateCounts(uid,name,classes,classs);
		//得到修改后信息
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
	
	//得到方向信息----------
	@RequestMapping("/Msg/direction")
	public String getDirection(Model model,HttpServletRequest request) throws IOException {
		List<Direction> directions = msgService.getDirection();
		model.addAttribute("path","directionMsg.jsp");
		request.setAttribute("msg", directions);
		return "main";
	}	
	
	//修改方向信息
	@RequestMapping("/Update/direction")
	public String updateDirection(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String nameOld = request.getParameter("nameOld");
		msgService.updateDirection(id, name);
		msgService.updateUserMajor(name, nameOld);
		//得到修改后信息
		List<Direction> directions = msgService.getDirection();
		model.addAttribute("path","directionMsg.jsp");
		request.setAttribute("msg", directions);
		return "main";
	}	
	
	//添加方向信息
	@RequestMapping("/Insert/direction")
	public String insertDirection(Model model,HttpServletRequest request) throws IOException {
		//接受参数
		String name = request.getParameter("name");
		msgService.insertDirection(name);		
		//得到添加后信息
		List<Direction> directions = msgService.getDirection();
		model.addAttribute("path","directionMsg.jsp");
		request.setAttribute("msg", directions);
		return "main";
	}
	
	@RequestMapping("/Update/other")
	public String updateOther(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		//新的
		String quantity = request.getParameter("quantity");
		//旧的
		String quantityed = request.getParameter("quantityed");
		//接受参数
		msgService.updateOther(user.getUid(),quantity,quantityed);
		//得到修改后信息
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
	//删除其它
	@RequestMapping("/Delete/other")
	public String deleteOther(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		msgService.deleteOther(user);
		//得到修改后信息
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
}
