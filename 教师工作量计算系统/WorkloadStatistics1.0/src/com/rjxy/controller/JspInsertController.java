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
		//��ȡ��ǰ��ʦ����
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//ǰ���洢���ܷ�����
		InsertService insertService = new InsertService();
		int option = insertService.ordinaryCourseInsert(count,user);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
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
		//��ȡ��ǰ��ʦ����
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//ǰ���洢���ܷ�����
		InsertService insertService = new InsertService();
		int option = insertService.trainInsert(count, user);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		TrainService trainService = new TrainService();
		trainService.classTable1(model);
		trainService.classTable2(model);
		trainService.equation(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("option",option);
		model.addAttribute("train", new Train());
		model.addAttribute("count", new Count());
		model.addAttribute("path","Train.jsp");
		return "main";
	}
	@RequestMapping("/C")
	public String cInsertController(Count count,Model model,HttpServletRequest req) throws IOException {
		//��ȡ��ǰ��ʦ����
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//�������ݣ�������ǰ�����Ƿ���ڣ�������޸�
		InsertService insertService = new InsertService();
		int option = insertService.graduationProjectInsert(count,user);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("option",option);
		model.addAttribute("countQ",new Count());
		model.addAttribute("countH",new Count());
		model.addAttribute("path","GraduationProject.jsp");
		return "main";
	}
	@RequestMapping("/D")
	public String dInsertController(Count count,Model model,HttpServletRequest req) throws IOException {
		//��ȡ��ǰ��ʦ����
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//�������ݣ�������ǰ�����Ƿ���ڣ�������޸�
		InsertService insertService = new InsertService();
		//��ͬ�Ŀ�ܽṹʵ�����Ѿ����ڵļ��ٴ�������
		int option = insertService.graduationProjectInsert(count,user);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("option",option);
		model.addAttribute("countQ",new Count());
		model.addAttribute("countH",new Count());
		model.addAttribute("path","SocialPractice.jsp");
		return "main";
	}
	@RequestMapping("/E")
	public String eInsertController(Other other,Model model,HttpServletRequest req) throws IOException {
		//��ȡ��ǰ��ʦ����
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		//ǰ���洢���ܷ�����
		InsertService insertService = new InsertService();
		int option = insertService.otherInsert(other, user);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		OtherService otherService = new OtherService();
		otherService.courseTable(model);
		otherService.positionTable(model);
		otherService.parameters(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("path", "Other.jsp");
		model.addAttribute("otherQ", new Other());
		model.addAttribute("otherH", new Other());
		req.setAttribute("option",option);
		return "main";
	}
}
