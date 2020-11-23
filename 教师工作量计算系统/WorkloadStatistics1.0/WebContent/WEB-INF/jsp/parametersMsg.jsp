<%@page import="com.rjxy.domain.Parameters"%>
<%@page import="java.util.ArrayList"%>
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

    <base href="<%=basePath%>">
	<title>其他信息修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/parametersMsg.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myCode.js"></script>
</head>
<body>
    <div class="all">
    	<div class="title1">其他身份修改</div>
    	<div class="line"></div>
    	<div class="table_box">
	    			<span class="t1">编号</span>
	    			<span class="t2">身份</span>
	    			<span class="t3">奖励课时量</span>
	    			<span class="t4">操作</span>
    	     <table border="1" style="border-style:solid ;border-collapse: collapse">
    	         <tr style="display:none">
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			<% ArrayList<Parameters> parameters = (ArrayList<Parameters>)request.getAttribute("msg");
			   for(int i = 0 ; i < parameters.size() ; i++) {
				   Parameters parameter = parameters.get(i);  
			%>
			<form action="Update/parameters" method="post" class="myForm">
				<tr>
					<td class="id"><input type="text" class="id_box" name="id" value="<%=parameter.getParametersID() %>" style="border:none;" readonly="true"></td>
					<td class="name"><input type="text" class="name_box" name="name" value="<%=parameter.getParametersName() %>" style="border:none;" readonly="true"></td>
					<td class="time"><input type="text" class="time_box" name="time" value="<%=parameter.getParametersValue() %>" style="border:none;" readonly="true"></td>
					<td class="btn1"><input type="submit" class="myBtn" value="修改"><a href="Delete/parameters?id=<%=parameter.getParametersID()%>" class="del">删除</a></td>
					<%-- <td><a href="Delete/parameters?id=<%=parameter.getParametersID()%>">删除</a></td> --%>
				</tr>
			</form>
			<%
			   }
			%>
				<form action="Insert/parameters" method="post">
					<tr>
						<td><input type="text" name="id" class="id_box2"></td>
						<td><input type="text" name="name" class="name_box2"></td>
						<td><input type="text" name="time" class="time_box2"></td>
						<td class="btn"><input type="submit" value="添加" class="btn2"></td>
					</tr>
				</form>
			</table>
    	</div>
    </div>
</body>
</html>