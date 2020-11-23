<%@page import="com.rjxy.domain.PageBean"%>
<%@page import="com.rjxy.domain.CourseTable"%>
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
	<title>课程修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/courseMsg.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myCode2.js"></script>
</head>
<body>
    <div class="all">
    	<div class="title1">课程修改</div>
    	<div class="line"></div>
    	<div class="table_box">
	    			<span class="t1">编号</span>
	    			<span class="t2">课程名</span>
	    			<span class="t3">总课时</span>
	    			<span class="t4">理论课时</span>
	    			<span class="t5">实验课时</span>
	    			<span class="t6">操作</span>
    	     <table border="1" style="border-style:solid ;border-collapse: collapse">
    	     	<tr style="display:none">
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			<% ArrayList<CourseTable> courseTables = (ArrayList<CourseTable>)request.getAttribute("msg");
			PageBean pageBean = (PageBean)request.getAttribute("pageBean");
			   for(int i = 0 ; i < courseTables.size() ; i++) {
				   CourseTable courseTable = courseTables.get(i);  
			%>
			<form action="Update/courseTable" method="post" class="myForm">
				<tr>
					<td class="id"><input type="text" class="id_box" name="id" value="<%=courseTable.getCourseID() %>" style="border:none;" readonly="true"></td>
					<td class="name"><input type="text" class="name_box" name="name" value="<%=courseTable.getCourse() %>" style="border:none;" readonly="true"></td>
					<td class="timeTotal"><input type="text" class="timeTotal_box" name="timeTotal" value="<%=courseTable.getTotal() %>" style="border:none;" readonly="true"></td>
					<td class="timeReality"><input type="text" class="timeReality_box" name="timeReality" value="<%=courseTable.getReality() %>" style="border:none;" readonly="true"></td>
					<td class="timeExperiment"><input type="text" class="timeExperiment_box" name="timeExperiment" value="<%=courseTable.getExperiment() %>" style="border:none;" readonly="true"></td>
					<td class="btn"><input type="submit" class="myBtn" value="修改"><a href="Delete/courseTable?id=<%=courseTable.getCourseID()%>" class="del">删除</a></td>
					<%-- <td><a href="Delete/courseTable?id=<%=courseTable.getCourseID()%>">删除</a></td> --%>
				</tr>
			</form>
			<%
			   }
			%>
				<form action="Insert/courseTable" method="post">
					<tr>
						<td class="id"><input type="text" name="id" class="id_box2"></td>
						<td class="name"><input type="text" name="name" class="name_box2"></td>
						<td class="timeTotal"><input type="text" name="timeTotal" class="timeTotal_box2"></td>
						<td class="timeReality"><input type="text" name="timeReality" class="timeReality_box2"></td>
						<td class="timeExperiment"><input type="text" name="timeExperiment" class="timeExperiment_box2"></td>
						<td class="btn"><input type="submit" value="添加" class="btn2"></td>
					</tr>
				</form>
				<tr>
					<td colspan="6">
						<% for(int i = 1 ; i <= pageBean.getPageCount() ; i++ ) {%>
							<% if(pageBean.getPageNow() == i) {%> 
								<a href="Msg/course?pageNow=<%=i %>"><span style="color:red"><%=i %></span></a>
							<% }else{ %>
								<a href="Msg/course?pageNow=<%=i %>"><%=i %></a>
						<% }} %>
					</td>
				</tr>
			</table>
    	</div>
    </div>
</body>
</html>