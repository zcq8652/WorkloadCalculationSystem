package com.rjxy.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.rjxy.domain.Direction;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class DirectionService {
	
	public List<Direction> getDirList(User user) throws IOException {
		List<Direction> myList = new ArrayList<Direction>();
		SqlUtil sqlUtil = new SqlUtil();
		if("Ժ��".equals(user.getPermissions()) || "��ѧ����".equals(user.getPermissions())) {
			myList = sqlUtil.selectAllDirection();
		} else if ("ϵ����".equals(user.getPermissions())) {
			Direction direction = new Direction();
			direction.setName(user.getMajor());
			myList.add(direction);
		} else {
			
		}
		return myList;
			
	}
}
