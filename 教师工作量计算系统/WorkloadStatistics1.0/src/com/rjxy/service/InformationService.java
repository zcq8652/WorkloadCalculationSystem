package com.rjxy.service;

import java.io.IOException;

import com.rjxy.domain.Count;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class InformationService {
	public int passwordService(User user1,User user2) throws IOException {
		//�Ա���Ϣ
		//�鿴ԭ���ܰ��Ƿ���ȷ
		if(user1.getPassword().equals(user2.getPassword())) {
			//�鿴��������������Ƿ�һ��
			if(user1.getPasswords().equals(user1.getRepassword())) {
				//�޸����ݿ���Ϣ
				SqlUtil sqlUtil = new SqlUtil();
				//�������ݣ������޸�
				user1.setUid(user2.getUid());
				user1.setPassword(user1.getPasswords());
				int option = sqlUtil.updateUserPassword(user1);
				//�����޸ķ�����Ϣ
				return option;
			}
		}
		//������󣬷��ش�����Ϣ
		return 0;		
	}

}
