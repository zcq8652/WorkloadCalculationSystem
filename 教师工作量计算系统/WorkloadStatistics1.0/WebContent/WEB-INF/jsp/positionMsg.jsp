<%@page import="com.rjxy.domain.*"%>
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
	<title>双肩挑修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/positionMsg.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myCode.js"></script>
</head>
<body>
    <div class="all">
    	<div class="title1">双肩挑</div>
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
			<% ArrayList<PositionTable> positionTables = (ArrayList<PositionTable>)request.getAttribute("msg");
			   for(int i = 0 ; i < positionTables.size() ; i++) {
				 	PositionTable positionTable = positionTables.get(i);  
			%>
			<form action="Update/position" method="post" class="myForm">
				<tr>
					<td class="id"><input type="text" class="id_box" name="id" value="<%=positionTable.getPositionID() %>" style="border:none;" readonly="true"></td>
					<td class="name"><input type="text" class="name_box" name="name" value="<%=positionTable.getPositionName() %>" style="border:none;" readonly="true"></td>
					<td class="time"><input type="text" class="time_box" name="time" value="<%=positionTable.getPositionTime() %>" style="border:none;" readonly="true"></td>
					<td class="btn1"><input type="submit" class="myBtn" value="修改"><a href="Delete/position?id=<%=positionTable.getPositionID()%>" class="del">删除</a></td>
					<%-- <td><a href="Delete/position?id=<%=positionTable.getPositionID()%>">删除</a></td> --%>
				</tr>
			</form>
			<%
			   }
			%>
				<form action="Insert/position" method="post">
					<tr>
						<td><input type="text" class="id_box2" name="id" ></td>
						<td><input type="text" class="name_box2" name="name"></td>
						<td><input type="text" class="time_box2" name="time"></td>
						<td class="btn"><input type="submit" value="添加" class="btn2"></td>
					</tr>
				</form>
				<tr>
					<td colspan="4">
						<% 
						PageBean pageBean = (PageBean)request.getAttribute("pageBean");
						for(int i = 1 ; i <= pageBean.getPageCount() ; i++ ) {%>
							<% if(pageBean.getPageNow() == i) {%> 
								<a href="Msg/position?pageNow=<%=i %>"><span style="color:red"><%=i %></span></a>
							<% }else{ %>
								<a href="Msg/position?pageNow=<%=i %>"><%=i %></a>
						<% }} %>
					</td>
				</tr>
			</table>
    	</div>
    </div>
</body>
</html>