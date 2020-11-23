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
	
	//˫����
	//�õ�˫��������Ϣ
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
	//ɾ��˫������Ϣ
	@RequestMapping("/Delete/position")
	public String deletePosition(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deletePosition(id);
		//�õ�ɾ������Ϣ
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//�޸�˫������Ϣ
	@RequestMapping("/Update/position")
	public String updatePosition(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.updatePosition(id,name,time);
		//�õ��޸ĺ���Ϣ
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//���˫������Ϣ
	@RequestMapping("/Insert/position")
	public String insertPosition(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.insertPosition(id,name,time);
		//�õ���Ӻ���Ϣ
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBeanByOne(pageNow);
		List<PositionTable> positionTables = msgService.getPosition(pageBean);
		model.addAttribute("path","positionMsg.jsp");
		request.setAttribute("msg", positionTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	
	//�õ�������������Ϣ
	@RequestMapping("/Msg/parameters")
	public String getParameters(Model model,HttpServletRequest request) throws IOException {
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}
	//ɾ��������������Ϣ
	@RequestMapping("/Delete/parameters")
	public String deleteParameters(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deleteParameters(id);
		//�õ�ɾ������Ϣ
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}	
	//�޸�������������Ϣ
	@RequestMapping("/Update/parameters")
	public String updateParameters(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//���ܲ���
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.updateParameters(id,name,time);
		//�õ��޸ĺ���Ϣ
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}
	//���������������Ϣ
	@RequestMapping("/Insert/parameters")
	public String insertParameters(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//���ܲ���
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		msgService.insertParameters(id,name,time);
		//�õ���Ӻ���Ϣ
		List<Parameters> parameters = msgService.getParameters();
		model.addAttribute("path","parametersMsg.jsp");
		request.setAttribute("msg", parameters);
		return "main";
	}	
	
	
	//�õ��γ̱����Ϣ
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
	//ɾ���γ̱���Ϣ
	@RequestMapping("/Delete/courseTable")
	public String deleteCourseTable(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deleteCourseTable(id);
		//�õ�ɾ������Ϣ
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//�޸Ŀγ̱���Ϣ
	@RequestMapping("/Update/courseTable")
	public String updateCourseTable(Model model,HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("utf-8");
		//���ܲ���
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String timeTotal = request.getParameter("timeTotal");
		String timeReality = request.getParameter("timeReality");
		String timeExperiment = request.getParameter("timeExperiment");
		msgService.updateCourseTable(id,name,timeTotal,timeReality,timeExperiment);
		//�õ��޸ĺ���Ϣ
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
	//��ӿγ̱���Ϣ
	@RequestMapping("/Insert/courseTable")
	public String insertCourseTable(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String timeTotal = request.getParameter("timeTotal");
		String timeReality = request.getParameter("timeReality");
		String timeExperiment = request.getParameter("timeExperiment");
		msgService.insertCourseTable(id,name,timeTotal,timeReality,timeExperiment);
		//�õ���Ӻ���Ϣ
		String pageNow = request.getParameter("pageNow");
		PageBean pageBean = msgService.getPageBean(pageNow);
		List<CourseTable> courseTables = msgService.getCourse(pageBean);
		model.addAttribute("path","courseMsg.jsp");
		request.setAttribute("msg", courseTables);
		request.setAttribute("pageBean", pageBean);
		return "main";
	}	
		
		
	
	//�õ��γ̼��㹫ʽ��Ϣ
	@RequestMapping("/Msg/equation")
	public String getEquation(Model model,HttpServletRequest request) throws IOException {
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}
	//ɾ�����㹫ʽ��Ϣ
	@RequestMapping("/Delete/equation")
	public String deleteEquation(Model model,HttpServletRequest request) throws IOException {
		String id = request.getParameter("id");
		msgService.deleteEquation(id);
		//�õ�ɾ������Ϣ
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}	
	//�޸ļ��㹫ʽ��Ϣ
	@RequestMapping("/Update/equation")
	public String updateEquation(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String formula = request.getParameter("formula");
		msgService.updateEquation(id,type,formula);
		//�õ��޸ĺ���Ϣ
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}	
	//��Ӽ��㹫ʽ��Ϣ
	@RequestMapping("/Insert/equation")
	public String insertEquation(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String formula = request.getParameter("formula");
		msgService.insertEquation(id,type,formula);		//�õ���Ӻ���Ϣ
		List<Equation> equations = msgService.getEquation();
		model.addAttribute("path","equationMsg.jsp");
		request.setAttribute("msg", equations);
		return "main";
	}
	
	
	//�õ���ʱ��Ϣ
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
	
	//ɾ����ʱ��Ϣ
	@RequestMapping("/Delete/counts")
	public String deleteCounts(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		//�õ�ɾ������Ϣ
		String uid = user.getUid();
		//�γ�����
		//String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8"��
		String name = request.getParameter("name");
		//�ɵİ༶����
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
	//�޸Ŀ�ʱ��Ϣ
	@RequestMapping("/Update/counts")
	public String updateCounts(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		String uid = user.getUid();
		String name = request.getParameter("name");
		//�µ�����
		String classes = request.getParameter("classes");
		//�ɵİ༶����
		String classs = request.getParameter("classs");
		//���ܲ���
		msgService.updateCounts(uid,name,classes,classs);
		//�õ��޸ĺ���Ϣ
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
	
	//�õ�������Ϣ----------
	@RequestMapping("/Msg/direction")
	public String getDirection(Model model,HttpServletRequest request) throws IOException {
		List<Direction> directions = msgService.getDirection();
		model.addAttribute("path","directionMsg.jsp");
		request.setAttribute("msg", directions);
		return "main";
	}	
	
	//�޸ķ�����Ϣ
	@RequestMapping("/Update/direction")
	public String updateDirection(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String nameOld = request.getParameter("nameOld");
		msgService.updateDirection(id, name);
		msgService.updateUserMajor(name, nameOld);
		//�õ��޸ĺ���Ϣ
		List<Direction> directions = msgService.getDirection();
		model.addAttribute("path","directionMsg.jsp");
		request.setAttribute("msg", directions);
		return "main";
	}	
	
	//��ӷ�����Ϣ
	@RequestMapping("/Insert/direction")
	public String insertDirection(Model model,HttpServletRequest request) throws IOException {
		//���ܲ���
		String name = request.getParameter("name");
		msgService.insertDirection(name);		
		//�õ���Ӻ���Ϣ
		List<Direction> directions = msgService.getDirection();
		model.addAttribute("path","directionMsg.jsp");
		request.setAttribute("msg", directions);
		return "main";
	}
	
	@RequestMapping("/Update/other")
	public String updateOther(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		//�µ�
		String quantity = request.getParameter("quantity");
		//�ɵ�
		String quantityed = request.getParameter("quantityed");
		//���ܲ���
		msgService.updateOther(user.getUid(),quantity,quantityed);
		//�õ��޸ĺ���Ϣ
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
	//ɾ������
	@RequestMapping("/Delete/other")
	public String deleteOther(Model model,HttpServletRequest request) throws IOException {
		User user = (User) request.getSession().getAttribute("user");
		msgService.deleteOther(user);
		//�õ��޸ĺ���Ϣ
		List<Count> counts = msgService.getCounts(user);
		List<Other> others = msgService.getOther(user);
		model.addAttribute("path","countsMsg.jsp");
		request.setAttribute("msg", counts);
		request.setAttribute("msg1", others);
		return "main";
	}	
}
