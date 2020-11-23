<%@ page pageEncoding="utf-8"
errorPage="wrong.jsp"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>注册用户</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
	<div class="all">
		<div class="title1">用户中心</div>
    	<div class="line"></div>
    	<form:form modelAttribute="user"  method="post" action="user/add">
    	<div class="reigster">
    		<div class="title2">注册用户</div>
    		<div class="register_box">
    			<div class="uid">
    				<div class="uid_name">工号</div>
    				<div class="uid_val">
    					<input type="text" name="uid" class="uid_textbox">
    				</div>
    			</div>
    			<div class="name">
    				<div class="name_name">姓名</div>
    				<div class="name_val">
    					<input type="text" name="name" class="name_textbox">
    				</div>
    			</div>
    			<div class="major">
    				<div class="major_name">方向</div>
    				<div class="major_val">
    					<form:select path="major" class="major_textbox">
    			    	     <form:options items="${list }"/> 
    				     </form:select>
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
    	<input type="submit" value="注册" class="button1">
    	<input type="reset" value="重置" class="button2">
    	</form:form>
	</div>
</body>
</html>