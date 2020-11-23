<%@ page pageEncoding="utf-8"
errorPage="wrong.jsp"
import="com.rjxy.domain.User"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<title>提交情况</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/Initial.css">
</head>
<body>
<% User user = (User)request.getAttribute("user");
   String status = user.getStatus();
   String information = user.getInformation();    
%>
    <div class="all">
    	<div class="initialBox1">
    	     <div class="text1">课时状态</div> 
             <div class="line1"></div>
             <div class="textBox1">
             <%	if(status.equals("0")){%> 
		<p>本学期尚未提交课时表</p>
             <%} if(status.equals("1_1")) {%>
		<p>课时表已提交，系主任正在审核中.........</p>
		     <%} if(status.equals("1_2")) {%>
		<p>课时表已提交，教学秘书正在审核中.........</p>
             <%} if(status.equals("2_1")) {%>   
		<p>系主任驳回，请阅读下方错误信息并重新计算错误项</p>
		     <%} if(status.equals("2_2")) {%>   
		<p>教学秘书驳回，请阅读下方错误信息并重新计算错误项</p>
             <%} if(status.equals("3_2")) {%>   
		<p>教学秘书审核通过</p>
             <%} %>
             </div> 
    	</div>
    	<div class="initialBox2">
    		<div class="text2">信息提示</div>   
            <div class="line2"></div>
            <textarea class="textBox2"><%= information %></textarea> 
    	</div>
    </div>
</body>
</html>