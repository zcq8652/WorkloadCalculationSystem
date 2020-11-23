<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<meta charset="utf-8">
<title>工作量统计系统</title>
</head>
<body>
<a href="Index/login">工作量统计系统</a>
<%if(request.getSession().getAttribute("option")!=null){ %>
	<script type="text/javascript">
		alert("当前浏览器已有用户登陆，请切换浏览器或电脑登陆");
	</script>
	<%} %>
</body>
</html>