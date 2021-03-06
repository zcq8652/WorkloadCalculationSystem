<%@ page pageEncoding="utf-8"
errorPage="wrong.jsp"
%>
<%@page import="com.rjxy.domain.*,java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>权限修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
	<div class="all">
		<div class="title1">用户中心</div>
    	<div class="line"></div>
    	<form method="post" action="user/update">
    	<div class="reigster">
    		<div class="title2">权限修改</div>
    		<div class="register_box">
    			<div class="major">
    				<div class="major_name">姓名</div>
    				<div class="major_val">
    					<select name="uid" class="major_textbox">
    			    	     <%List<User> users = (List<User>)request.getAttribute("users"); 
    			    	     	for(User user:users){
    			    	     %>
    			    	     	<option value="<%=user.getUid() %>"><%=user.getName() %></option>
    			    	     <%
    			    	     	}
    			    	     %>
    				     </select>
    				</div>
    			</div>
    			<div class="job">
    				<div class="job_name">职位</div>
    				<div class="job_val">
    					<select name="permissions" class="job_textbox">
    						<option value="一般教师">一般教师</option>
    						<option value="系主任">系主任</option>
    						<option value="教学秘书">教学秘书</option>
    						<option value="院长">院长</option>
    					</select>
    				</div>
    			</div>
    		</div>
    	</div>
    	<input type="submit" value="提交" class="button1">
    	</form>
	</div>
</body>
</html>