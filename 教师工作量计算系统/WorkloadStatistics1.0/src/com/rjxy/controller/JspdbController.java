package com.rjxy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.domain.Count;
import com.rjxy.domain.OrdinaryCourse;
import com.rjxy.domain.Other;
import com.rjxy.domain.Train;
import com.rjxy.service.CountService;
import com.rjxy.service.OrdinaryCourseService;
import com.rjxy.service.OtherService;
import com.rjxy.service.TrainService;

@Controller
@RequestMapping("/Jspdb")
public class JspdbController {
	@RequestMapping("/A")
	public String OrdinaryCourseController(OrdinaryCourse ordinaryCourse,Model model,HttpServletRequest req) throws IOException {
		//����Count��������ʾ��������ǰ�˺���ӵ����ݿ�
		Count count = new Count();
		//ǰ�����������
		CountService countService = new CountService();
		//countService.ordinaryCourseCount(ordinaryCourse,count);
		countService.ordinaryCourseCount_1(ordinaryCourse,count);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.courseTable(model);
		o.classTable1(model);
		o.classTable2(model);
		o.classTable3(model);
		o.classTable4(model);
		o.equation(model);
		model.addAttribute("path","OrdinaryCourse.jsp");
		model.addAttribute("OrdinaryCourse", new OrdinaryCourse());
		model.addAttribute("count",count);
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/B")
	public String TrainController(Train train,Model model,HttpServletRequest req) throws IOException {
		//��������ǰ����ʾ���洢��
		Count count = new Count();
		//ǰ�����������
		CountService countService = new CountService();
		countService.trainCount(train, count);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		TrainService trainService = new TrainService();
		trainService.classTable1(model);
		trainService.classTable2(model);
		trainService.equation(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("path","Train.jsp");
		model.addAttribute("train", new Train());
		model.addAttribute("count",count);
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/C")
	public String GraduationProjectController(Count count,Model model,HttpServletRequest req) throws IOException {
		//��ʾ��ǰ�˺ʹ洢�����ݿ�����ݴ洢��
		Count count2 = new Count();
		//ǰ�����������
		CountService countService = new CountService();
		countService.graduationProjectCount(count,count2);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("path","GraduationProject.jsp");
		model.addAttribute("countQ",new Count());
		model.addAttribute("countH",count2);
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/D")
	public String SocialPracticeController(Count count,Model model,HttpServletRequest req) throws IOException {
		//��ʾ��ǰ�˺ʹ洢�����ݿ�����ݴ洢��
		Count count2 = new Count();
		//ǰ�����������
		CountService countService = new CountService();
		countService.socialPracticeCount(count, count2);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		OrdinaryCourseService o = new OrdinaryCourseService();
		o.equation(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("path","SocialPractice.jsp");
		model.addAttribute("countQ",new Count());
		model.addAttribute("countH",count2);
		req.setAttribute("option",2);
		return "main";
	}
	@RequestMapping("/E")
	public String OtherController(Other other,Model model,HttpServletRequest req) throws IOException {
		//��������ǰ����ʾ���洢��
		Other other2 = new Other();
		//ǰ�����������
		CountService countService = new CountService();
		countService.otherCount(other, other2);
		//�������ݿ����ݣ�ȡ�ö�̬��������
		OtherService otherService = new OtherService();
		otherService.courseTable(model);
		otherService.positionTable(model);
		otherService.parameters(model);
		//ǰ����ת��Ϣ�����ݻ�����Ϣ
		model.addAttribute("path","Other.jsp");
		model.addAttribute("otherQ",new Other());
		model.addAttribute("otherH", other2);
		req.setAttribute("option",2);
		return "main";
	}
}
