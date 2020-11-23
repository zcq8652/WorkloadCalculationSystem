package com.rjxy.service;

import java.io.IOException;
import java.util.List;

import com.rjxy.domain.Count;
import com.rjxy.domain.Other;
import com.rjxy.domain.User;
import com.rjxy.mybatis.SqlUtil;

public class Check2Service {
	
	public String checkService(User user1) throws IOException {
		//创建数据库连接
		SqlUtil sqlUtil = new SqlUtil();
		//提取数据库中需要审核工作量的教师信息
		List<User> users = sqlUtil.selectAllStatusTeacher_major(user1);
		//判断是否还有未审核教师
		if (users.size()==0) {
			return "<p>暂无需审核人员</p>";
		}
		//获取第一个教师的数据
		User user = users.get(0);
		//查询改教师的工作量
		List<Count> counts = sqlUtil.selectAllCount(user);
		List<Other> others = sqlUtil.selectAllOther(user);
		//数据存储中间量
		String string = "<table border=\"1\">\r\n" + 
				"  <tr>\r\n" + 
				"	  <th>姓名</th>\r\n" + 
				"	  <th>职称</th>\r\n" + 
				"	  <th>课程名称</th>\r\n" + 
				"	  <th>课程类别</th>\r\n" + 
				"	  <th>总学时</th>\r\n" + 
				"	  <th>理论学时</th>\r\n" + 
				"	  <th>实验学时</th>\r\n" + 
				"	  <th>上课班级</th>\r\n" + 
				"	  <th>课时</th>\r\n" + 
				"  </tr>";
		int i=0;
		//整合数据到表格中用来显示动态显示前端
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
		string+="<span style=\"color:#336199; margin-left:8px;\">教师名称:</span><span style=\"color:orange;\">"+user.getName()+"</span></br>";
		string+="<input id=\"uid\" type=\"hidden\" value=\""+user.getUid()+"\">";
		string+="<span style=\"color:#336199; margin-left:8px;\">是否通过审核:</span><input type=\"radio\" name=\"status\" value=\"1_2\" checked><span style=\"color:orange;\">是</span>";
		string+="<input type=\"radio\" name=\"status\" value=\"2_1\" style=\"margin-left:15px;\"><span style=\"color:orange;\">否</span></br>";
		string+="<span style=\"color:#336199; margin-left:8px;\">工作量错误信息描述:</span></br>";
		string+="<textarea id=\"information\" rows=\"8\" cols=\"80\" style=\"margin:8px 0px 8px 8px;\">\r\n" + 
				"</textarea>";
		return string;
	}

}
