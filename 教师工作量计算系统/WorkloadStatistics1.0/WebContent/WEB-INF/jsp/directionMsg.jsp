<%@page import="com.rjxy.domain.Direction"%>
<%@page import="com.rjxy.domain.PositionTable"%>
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
	<title>方向修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/positionMsg.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myCode1.js"></script>
</head>
<body>
    <div class="all">
    	<div class="title1">方向</div>
    	<div class="line"></div>
    	<div class="table_box">
	    			<span class="t1">编号</span>
	    			<span class="t2">方向名称</span>
	    			<span class="t3">操作</span>
    	    <table border="1" style="border-style:solid ;border-collapse: collapse">
    	        <tr style="display:none">
					<th></th>
					<th></th>
					<th></th>
				</tr>
			<% ArrayList<Direction> directions = (ArrayList<Direction>)request.getAttribute("msg");
			   for(int i = 0 ; i < directions.size() ; i++) {
				 	Direction direction = directions.get(i);  
			%>
			<form action="Update/direction" method="post" class="myForm">
				
				<tr>			
					<td class="id"><input type="text" class="id_box" name="id" value="<%=direction.getId() %>" style="border:none;" readonly="true"></td>				
					<input type="hidden" name="nameOld" value="<%=direction.getName() %>" >
					<td class="name"><input type="text" class="name_box" name="name" value="<%=direction.getName() %>" style="border:none;" readonly="true"></td>
					<td class="btn"><input type="submit" class="myBtn" value="修改"></td>
					<%-- <td><a href="Delete/position?id=<%=positionTable.getPositionID()%>">删除</a></td> --%>
				</tr>
			</form>
			<%
			   }
			%>
				<form action="Insert/direction" method="post">
					<tr>
						<td><input type="text" class="id_box2" name="id" ></td>
						<td><input type="text" class="name_box2" name="name"></td>
						<td class="btn1"><input type="submit" value="添加" class="btn2"></td>
					</tr>
				</form>
			</table>
    	</div>
    </div>
</body>
</html>