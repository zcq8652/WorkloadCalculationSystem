package com.rjxy.service;

import java.io.IOException;
import java.sql.SQLTimeoutException;

import com.rjxy.domain.Count;
import com.rjxy.domain.Other;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class InsertService {
	public int ordinaryCourseInsert(Count count,User user) throws IOException {
			//�洢������ӵ����ݿ��Ƿ�ɹ�
			int optionReality = 0;
			int optionExperiment = 0;
			SqlUtil sqlUtil = new SqlUtil();
			//�������ݣ�����û���Ϣ
			count.setDuty(user.getDuty());
			count.setUname(user.getName());
			count.setUid(user.getUid());
			//Ԥ�ȱ����γ�����
			String courseString = count.getCourse();
			//����洢���ۿκ�ʵ���
			if(count.getRealityResult()!=0) {
				//����γ�����
				count.setCourse(courseString+"(����)");
				System.out.println(count.getCourse());
				//������ǰ�����Ƿ����
				Count counts = sqlUtil.selectCount(count);
				//�����ݴ��м��������ȡ����
				count.setResult(count.getRealityResult());
				count.setQuantity(count.getRealityQuantity());
				//�������޸ģ������������
				if (counts!=null) {
					optionReality = sqlUtil.updateCount(count);
				}else {
					optionReality = sqlUtil.insertCount(count);
				}
			}
			if(count.getExperimentResult()!=0) {
				//����γ�����
				count.setCourse(courseString+"("+"ʵ��"+")");
				//������ǰ�����Ƿ����
				Count counts = sqlUtil.selectCount(count);
				//�����ݴ��м��������ȡ����
				count.setResult(count.getExperimentResult());
				count.setQuantity(count.getExperimentQuantity());
				//�������޸ģ������������
				if (counts!=null) {
					optionExperiment = sqlUtil.updateCount(count);				
				}else {
					optionExperiment = sqlUtil.insertCount(count);
				}
			}
			//���ۿκ�ʵ�������һ���洢�ɹ������سɹ�
			if (optionReality==1||optionExperiment==1) {
				return 1;
			}else {
				return 0;
			}
	}
	public int graduationProjectInsert(Count count,User user) throws IOException {
		//�洢������ӵ����ݿ��Ƿ�ɹ�
		int option = 0;
		//�������ݿ����ӷ�ʽ
		SqlUtil sqlUtil = new SqlUtil();
		//�������ݣ�����û���Ϣ
		count.setDuty(user.getDuty());
		count.setUname(user.getName());
		count.setUid(user.getUid());
		//�жϼ������Ƿ�Ϊ�գ�Ϊ��˵���������ݴ��ڴ���
		if(count.getResult()==0) {
			return 0;
		}
		//�ж����ݿ��Ƿ���ڸ���Ϣ
		if (sqlUtil.selectCount(count)!=null) {
			option = sqlUtil.updateCount(count);
			return option;
		}else {
			option = sqlUtil.insertCount(count);
			return option;
		}
	}
	public int trainInsert(Count count,User user) throws IOException {
		//�洢������ӵ����ݿ��Ƿ�ɹ�
		int option = 0;
		//�������ݿ����ӷ�ʽ
		SqlUtil sqlUtil = new SqlUtil();
		//�������ݣ�����û���Ϣ
		count.setDuty(user.getDuty());
		count.setUname(user.getName());
		count.setUid(user.getUid());
		//�жϼ������Ƿ�Ϊ�գ�Ϊ��˵���������ݴ��ڴ���
		if(count.getResult()==0) {
			return 0;
		}
		//�ж����ݿ��Ƿ���ڸ���Ϣ
		if (sqlUtil.selectCount(count)!=null) {
			option = sqlUtil.updateCount(count);
			return option;
		}else {
			option = sqlUtil.insertCount(count);
			return option;
		}
	}
	public int otherInsert(Other other,User user) throws IOException {
		//�洢������ӵ����ݿ��Ƿ�ɹ�
		int option = 0;
		//�������ݿ����ӷ�ʽ
		SqlUtil sqlUtil = new SqlUtil();
		//�������ݣ�����û���Ϣ
		other.setUid(user.getUid());
		//�жϼ������Ƿ�Ϊ�գ�Ϊ��˵���������ݴ��ڴ���
		if(other.getResult()==0) {
			return 0;
		}
		//�ж����ݿ��Ƿ���ڸ���Ϣ
		if(sqlUtil.selectOther(other)!=null) {
			option = sqlUtil.updateOther(other);
			return option;
		}else {
			option = sqlUtil.insertOther(other);
			return option;
		}
	}
}
