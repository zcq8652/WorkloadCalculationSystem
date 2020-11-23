package com.rjxy.service;

import java.io.IOException;
import java.util.List;

import com.rjxy.domain.Count;
import com.rjxy.domain.Other;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class Check2Service {
	
	public String checkService(User user1) throws IOException {
		//�������ݿ�����
		SqlUtil sqlUtil = new SqlUtil();
		//��ȡ���ݿ�����Ҫ��˹������Ľ�ʦ��Ϣ
		List<User> users = sqlUtil.selectAllStatusTeacher_major(user1);
		//�ж��Ƿ���δ��˽�ʦ
		if (users.size()==0) {
			return "<p>�����������Ա</p>";
		}
		//��ȡ��һ����ʦ������
		User user = users.get(0);
		//��ѯ�Ľ�ʦ�Ĺ�����
		List<Count> counts = sqlUtil.selectAllCount(user);
		List<Other> others = sqlUtil.selectAllOther(user);
		//���ݴ洢�м���
		String string = "<table border=\"1\">\r\n" + 
				"  <tr>\r\n" + 
				"	  <th>����</th>\r\n" + 
				"	  <th>ְ��</th>\r\n" + 
				"	  <th>�γ�����</th>\r\n" + 
				"	  <th>�γ����</th>\r\n" + 
				"	  <th>��ѧʱ</th>\r\n" + 
				"	  <th>����ѧʱ</th>\r\n" + 
				"	  <th>ʵ��ѧʱ</th>\r\n" + 
				"	  <th>�Ͽΰ༶</th>\r\n" + 
				"	  <th>��ʱ</th>\r\n" + 
				"  </tr>";
		int i=0;
		//�������ݵ������������ʾ��̬��ʾǰ��
		if(counts.size()!=0) {
			for (Count count : counts) {
				if (i==0) {
					string+="  <tr>\r\n" + 
							"    <td rowspan=\"20\">"+user.getName()+"</td>\r\n" + 
							"    <td rowspan=\"20\">"+user.getDuty()+"</td>\r\n" + 
							"	<td>"+count.getCourse()+"</td>\r\n" + 
							"	<td>"+count.getCtype()+"</td>\r\n" + 
							"	<td>"+count.getTotal()+"</td>\r\n" + 
							"	<td>"+count.getReality()+"</td>\r\n" + 
							"	<td>"+count.getExperiment()+"</td>\r\n" + 
							"	<td>"+count.getClasss()+"</td>\r\n" + 
							"	<td>"+count.getQuantity()+"</td>\r\n" + 
							"  </tr>";
					i++;
				}else {
					string+="  <tr>\r\n" + 
							"	<td>"+count.getCourse()+"</td>\r\n" + 
							"	<td>"+count.getCtype()+"</td>\r\n" + 
							"	<td>"+count.getTotal()+"</td>\r\n" + 
							"	<td>"+count.getReality()+"</td>\r\n" + 
							"	<td>"+count.getExperiment()+"</td>\r\n" + 
							"	<td>"+count.getClasss()+"</td>\r\n" + 
							"	<td>"+count.getQuantity()+"</td>\r\n" + 
							"  </tr>";
				}
			}
		}
		if(others.size()!=0) {
			for (Other other : others) {
				string+="  <tr>\r\n" + 
						"	<td>"+other.getCourse()+"</td>\r\n" + 
						"	<td colspan=\"6\">"+other.getQuantity()+"</td>\r\n" + 
						"  </tr>";
			}
		}
		for (int j = 0; j < 20-counts.size()-others.size(); j++) {
			string+="  <tr>\r\n" + 
					"	<td> </td>\r\n" + 
					"	<td> </td>\r\n" + 
					"	<td> </td>\r\n" + 
					"	<td> </td>\r\n" + 
					"	<td> </td>\r\n" + 
					"	<td> </td>\r\n" + 
					"	<td> </td>\r\n" + 
					"  </tr>";
		}
		string+="</table></br>";
		string+="<span style=\"color:#336199; margin-left:8px;\">��ʦ����:</span><span style=\"color:orange;\">"+user.getName()+"</span></br>";
		string+="<input id=\"uid\" type=\"hidden\" value=\""+user.getUid()+"\">";
		string+="<span style=\"color:#336199; margin-left:8px;\">�Ƿ�ͨ�����:</span><input type=\"radio\" name=\"status\" value=\"1_2\" checked><span style=\"color:orange;\">��</span>";
		string+="<input type=\"radio\" name=\"status\" value=\"2_1\" style=\"margin-left:15px;\"><span style=\"color:orange;\">��</span></br>";
		string+="<span style=\"color:#336199; margin-left:8px;\">������������Ϣ����:</span></br>";
		string+="<textarea id=\"information\" rows=\"8\" cols=\"80\" style=\"margin:8px 0px 8px 8px;\">\r\n" + 
				"</textarea>";
		return string;
	}

}
