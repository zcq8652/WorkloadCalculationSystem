package com.rjxy.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.ui.Model;

import com.rjxy.domain.CourseTable;
import com.rjxy.domain.Parameters;
import com.rjxy.domain.PositionTable;
import com.rjxy.mybatis.SqlUtil;

public class OtherService {
	//获取课程表中的信息，数据回填到前端
	public void positionTable(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<PositionTable> positionTables = sqlUtil.selectAllPositionTable();
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (PositionTable positionTable : positionTables) {
			hobbys.put(positionTable.getPositionID(), positionTable.getPositionName());
		}
		model.addAttribute("positionMap", hobbys);
	}
	public void courseTable(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		List<CourseTable> courseTables = sqlUtil.selectAllCourseTable();
		HashMap<String, String> hobbys = new HashMap<String, String>();
		for (CourseTable courseTable : courseTables) {
			hobbys.put(courseTable.getCourseID(), courseTable.getCourse());
		}
		model.addAttribute("courseMap", hobbys);
	}
	public void parameters(Model model) throws IOException {
		SqlUtil sqlUtil = new SqlUtil();
		Parameters parameters = sqlUtil.selectParameters("textbookA");
		model.addAttribute("textbookA", parameters.getParametersValue());
		parameters = sqlUtil.selectParameters("textbookB");
		model.addAttribute("textbookB", parameters.getParametersValue());
	}
}
