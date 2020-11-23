<%@ page pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<title>服务器繁忙</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/wrong.css">
</head>
<body>
    <div class="all">
    	<div class="allSon">
    		<img src="images/logo.png" class="logoImg">
    	    <div class="text">
    		服务器繁忙,请稍后重试！
    	    </div>
    	</div>
    </div>
</body>
</html>