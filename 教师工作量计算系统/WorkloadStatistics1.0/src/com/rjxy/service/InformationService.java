package com.rjxy.service;

import java.io.IOException;

import com.rjxy.domain.Count;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class InformationService {
	public int passwordService(User user1,User user2) throws IOException {
		//对比信息
		//查看原秘密啊是否正确
		if(user1.getPassword().equals(user2.getPassword())) {
			//查看两次输入的密码是否一致
			if(user1.getPasswords().equals(user1.getRepassword())) {
				//修改数据库信息
				SqlUtil sqlUtil = new SqlUtil();
				//整合数据，便于修改
				user1.setUid(user2.getUid());
				user1.setPassword(user1.getPasswords());
				int option = sqlUtil.updateUserPassword(user1);
				//返回修改返回信息
				return option;
			}
		}
		//输入错误，返回错误信息
		return 0;		
	}

}
