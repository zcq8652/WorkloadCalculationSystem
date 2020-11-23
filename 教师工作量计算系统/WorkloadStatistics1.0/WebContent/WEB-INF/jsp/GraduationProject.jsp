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
	<title>毕业设计</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/graduationProject.css">
	<script type="text/javascript">
		function count(){
			document.form1.action="Jspdb/C";
			document.form1.submit();
		}
		function insert(){
			document.form2.action="JspInsert/C";
			document.form2.submit();
		}
	</script>
</head>
<body>
    <div class="all">
    	<div class="text1">毕业设计</div>
    	<div class="line1"></div>
    	<form:form modelAttribute="countQ" method="post" name="form1">
    	<div class="courseBox">
    	     <div class="courseType">
    	   <div class="courseType_name">课程类别</div>
    	   <div class="courseType_val">
    	        <form:select path="numberA" class="courseType_textBox">
    	            <option>请选择</option>
    				<form:options items="${equation }"/>
    			</form:select>
    	   </div>
    	</div>
    	</div>
    	<div class="teamProject">
    		<div class="titleSon1">团队设计</div>
    		<div class="teamBox">
    			<div class="teamNumber">
    				<div class="teamNumber_name">团队数</div>
    				<div class="teamNumber_val">
                        <select name="nteam" class="teamNumber_box">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>         
                    </div>
    			</div>
    			<div class="teamday">
    				<div class="teamday_name">辅导周数</div>
    				<div class="teamday_val">
                         <select name="nweekB" class="teamday_box">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                         </select>            
                    </div>
    			</div>
    		</div>
    	</div>
    	<div class="personalProject">
    		<div class="titleSon2">个人设计</div>
            <div class="personalBox">
                <div class="personalNumber">
                    <div class="personalNumber_name">辅导人数</div>
                    <div class="personalNumber_val">
                    <div class="optionBox">
                         <select name="npeople" class="personalNumber_box">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                       </select>
                    </div>
                    </div>
                </div>
                <div class="personalday">
                    <div class="personalday_name">辅导周数</div>
                    <div class="personalday_val">
                        <select name="nweekA" class="personalday_box">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>
                </div>
            </div>
    	</div>
    	        <input type="button" name="" value="确认" class="button1" onclick="count()">
    	 </form:form>
    	 <form:form modelAttribute="countH" method="post" name="form2">
    	<div class="resultall">
    	    <div class="titleSon3">计算结果</div>
    	    <div class="resultBox">
    	    <div class="showInfor">
    	        <div class="showInfor_name">信息显示</div>
    	        <div class="showInfor_val">
    	            <form:input path="classs"  class="showInfor_textBox"/>
    	        </div>
    	    </div>
    	    <div class="result">
    		    <div class="result_name">计算结果</div>
    		    <div class="result_val">
    		        <form:input path="result" class="result_textBox"/>
    		    </div>
    		</div>
    	    </div>
    	</div>
        <input type="button" name="" class="button2" value="存储"  onclick="insert()">
        <form:hidden path="quantity"/>
        <form:hidden path="course"/>
        </form:form>
    </div>
    <%
		int option = (int)request.getAttribute("option"); 
		if(option == 1){
	%>
	<script type="text/javascript">
		alert("数据存储成功");
	</script>
	<%}else if(option == 0) {%>
	<script type="text/javascript">
		alert("数据异常，请谨慎填写课时数据");
	</script>
	<%} %>
</body>
</html>