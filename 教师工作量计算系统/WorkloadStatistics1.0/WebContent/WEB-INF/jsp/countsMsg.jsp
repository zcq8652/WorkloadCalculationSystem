<%@page import="java.net.URLEncoder"%>
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
	<title>代课修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/countsMsg.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myCode3.js"></script>
</head>
<body>
    <div class="all">
    	<div class="title1">代课修改</div>
    	<div class="line"></div>
    	<div class="table_box">
					<span class="t1">课程名称</span>
					<span class="t2">课程类别</span>
					<span class="t3">总学时</span>
					<span class="t4">理论学时</span>
					<span class="t5">实验学时</span>
					<span class="t6">上课班级</span>
					<span class="t7">课时</span>
	    			<span class="t8">操作</span>
    	    <table border="1" style="border-style:solid ;border-collapse: collapse">
    	       	<tr style="display:none">
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			<% ArrayList<Count> counts = (ArrayList<Count>)request.getAttribute("msg");
			   for(int i = 0 ; i < counts.size() ; i++) {
				   Count count = counts.get(i);  
			%>
			<form action="Update/counts" method="post" class="myForm">
				<tr>
					<td class="name"><input type="text" class="name_box" name="name" value="<%=count.getCourse() %>" style="border:none;" readonly="true"></td>
					<td class="type"><input type="text" class="type_box" name="type" value="<%=count.getCtype() %>" style="border:none;" readonly="true"></td>
					<td class="timeTotal"><input type="text" class="timeTotal_box" name="timeTotal" value="<%=count.getTotal() %>" style="border:none;" readonly="true"></td>
					<td class="timeReality"><input type="text" class="timeReality_box" name="timeReality" value="<%=count.getReality() %>" style="border:none;" readonly="true"></td>
					<td class="timeExperiment"><input type="text" class="timeExperiment_box" name="timeExperiment" value="<%=count.getExperiment() %>" style="border:none;" readonly="true"></td>
					<input type="hidden" name="classs" value="<%=count.getClasss() %>">
					<td class="classes"><input type="text" class="classes_box" name="classes" value="<%=count.getClasss() %>" style="border:none;" readonly="true"></td>
					
					<td class="result"><input type="text" class="result_box" name="name" value="<%=count.getResult() %>" style="border:none;" readonly="true"></td>
					<td class="btn"><input type="submit" class="myBtn" value="修改">
					<a href="Delete/counts?name=<%=URLEncoder.encode(count.getCourse(), "UTF-8")%>&classs=<%=URLEncoder.encode(count.getClasss(), "UTF-8")%>" class="del">删除</a></td>
					<%-- <td><a href="Delete/counts?name=<%=count.getCourse()%>&classs=<%=count.getClasss()%>">删除</a></td> --%>
				</tr>
			</form>
			<%
			   }
			%>
			<% ArrayList<Other> others = (ArrayList<Other>)request.getAttribute("msg1");
				if(others.size() != 0 ) {
				Other other = others.get(0);
			%>
			<form action="Update/other" method="post" class="myForm">
				<tr>
					<td>其它工作量</td>
					<input type="hidden" name="quantityed" value="<%=other.getQuantity() %>">
					<td colspan="5"><input type="text" class="name_box" name="quantity" value="<%=other.getQuantity() %>" style="border:none;width:100%;" readonly="true"></td>
					<td><%=other.getResult() %></td>
					<td class="btn"><input type="submit" class="myBtn" value="修改">
					<a href="Delete/other" class="del">删除</a></td>
				</tr>
			</form>
			<% } %>
			</table>
    	</div>
    </div>
</body>
</html>