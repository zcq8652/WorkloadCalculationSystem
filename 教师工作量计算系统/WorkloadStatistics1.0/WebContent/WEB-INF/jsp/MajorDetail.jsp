<%@page import="com.rjxy.domain.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="wrong.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<title>方向课时查询详情</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/graduationProject.css">
 	<!--样式文件-->
    <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/FileSaver.js"></script>
    <script type="text/javascript" src="js/jquery.wordexport.js"></script>  
    <!--DataTables 核心 js-->
    <script src="js/jquery.dataTables.min.js"></script>
    <script type="text/javaScript">
	    $(function () {
	        $(".display").DataTable();
	    });
	    function exportWord(){
	        $("#export_word").wordExport("工作量统计");
	    }
	</script>
</head>
<body>
	<button class="btn_btn-primary" onclick="exportWord()">导出</button>
	<div id="export_word">
		<table border = "1" style="border-style:solid ;border-collapse: collapse" id="excelstyles">
		<tr>
			<td>姓名</td>
			<td>职称</td>
			<td>课程名称</td>
			<td>课程类别</td>
			<td>总学时</td>
			<td>理论学时</td>
			<td>实验学时</td>
			<td>上课班级(与何班合班)</td>
			<td>课时</td>
			<td>总课时</td>
			<td>金额</td>
		</tr>
	<%  Map<User, Map<List<Count>,List<Other>>> allMap = (Map<User, Map<List<Count>,List<Other>>>)request.getAttribute("allMap");
		Iterator<Map.Entry<User, Map<List<Count>,List<Other>>>> it = allMap.entrySet().iterator(); 
	    while (it.hasNext()) {
	    	int j = 0 ;
	        Map.Entry<User, Map<List<Count>,List<Other>>> entry = it.next();
	        User user = entry.getKey();
	        Map<List<Count>,List<Other>> countsMap = entry.getValue();
	        Iterator<Map.Entry<List<Count>,List<Other>>> itOne = countsMap.entrySet().iterator();        
	        while (itOne.hasNext()) {
	        	Map.Entry<List<Count>,List<Other>> entryOne = itOne.next();
	        	List<Count> myCounts = entryOne.getKey();
	        	List<Other> myOthers = entryOne.getValue();
	        	if(myCounts.size() == 0 && myOthers.size() == 0) {
	        		%>
	        		<tr>
	        			<td rowspan="1"><%=user.getName() %></td>
	    				<td rowspan="1"><%=user.getPermissions() %></td>
	    				<td colspan="9">教师暂未添加上课信息</td>
	    			</tr>
	        		<%
	        	} 
	        	else if((myCounts.size() != 0 && myOthers.size() == 0 ) || (myCounts.size() != 0 && myOthers.size() != 0 )) {
		    		for(int i = 0 ; i < myCounts.size() ; i ++) {
		    			Count count = myCounts.get(i);
		    		%>	    		
		    		<tr>
		    			<% if(i == 0) { %>
		    			<td rowspan=<%=myCounts.size()+1%>><%=user.getName() %></td>
		    			<td rowspan=<%=myCounts.size()+1%>><%=user.getPermissions() %></td>
		    			<% } %>
		    			<td><%=count.getCourse() %></td>
		    			<td><%=count.getCtype() %></td>
		    			<td><%=count.getTotal() %></td>
		    			<td><%=count.getReality() %></td>
		    			<td><%=count.getExperiment() %></td>
		    			<td><%=count.getClasss() %></td>
		    			<td><%=count.getQuantity() %></td>
		    			<% if(i == 0 ) {%>
		    			<td rowspan="<%=myCounts.size()+1%>"><%=user.getTime() %></td>
		    			<%} %>
		    			<% if(i == 0 ) {%>
		    			<td rowspan="<%=myCounts.size()+1%>">课时*对应职称</td>
		    			<%}j++; %>
		    		</tr>
		    		<%}%>
		    		<tr>
		    		<td>其他工作量</td>		    			
		    		<%	    		
		    		StringBuffer classS = new StringBuffer();
			    		for(int i = 0 ; i < myOthers.size() ; i++) {
			    			Other other = myOthers.get(i);
			    			if(i == 0) {
			    				classS.append(other.getQuantity());
			    			} else {
			    				classS.append("+"+other.getQuantity());
			    			}
			    		}
			    		%>
			    		<td colspan="6"><%=classS %></td>
			    		</tr>
			      <%j++;
	        	}  else if(myCounts.size() == 0 || myOthers.size() != 0) {
	        		%>
	        	<tr>
        			<td rowspan="1"><%=user.getName() %></td>
    				<td rowspan="1"><%=user.getPermissions() %></td>
    				<td>其他工作量</td>	
    					<%	    		
		    		StringBuffer classS = new StringBuffer();
			    		for(int i = 0 ; i < myOthers.size() ; i++) {
			    			Other other = myOthers.get(i);
			    			if(i == 0) {
			    				classS.append(other.getQuantity());
			    			} else {
			    				classS.append("+"+other.getQuantity());
			    			}
			    		}
			    		%>
			    	<td colspan="6"><%=classS %></td>
			    	<td><%=user.getTime() %></td>
			    	<td>课时*对应职称</td>
    			</tr>
	        		<%	        		
	        }
	        	
	        } 
		}%>
	    			
	    		
	</table>
	</div>
</body>
</html>