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
	<title>实训/校外写生</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/Train.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/Train.js"></script>
	<script type="text/javascript">
		function count(){
			document.form1.action="Jspdb/B";
			document.form1.submit();
		}
		function insert(){
			document.form2.action="JspInsert/B";
			document.form2.submit();
		}
	</script>
</head>
<body>
    <div class="all">
    	<div class="text">实训/校外写生</div>
    	<div class="line"></div>
    	<div class="text2">请填写以下信息</div>
    	<form:form name="form1" modelAttribute="train" method="post" >
    	<div class="box1">
    		<div class="courseType">
    			<div class="courseType_name">课程类型</div>
    			<div class="courseType_val">
    				<form:select path="type" class="courseType_textBox">
    					<option>请选择</option>
    					<form:options items="${typeMap }"/>
    				</form:select>
    			</div>
    		</div>
    		<div class="computingType">
    			<div class="computingType_name">计算类型</div>
    			<div class="computingType_val">
    				<select class="computingType_textBox">
    					<option class="option1">实训</option>
    					<option class="option2">校外写生</option>
    				</select>
    			</div>
    		</div>
            <div class="box1_1">
            	<div class="days">
    			     <div class="days_name">写生天数</div>
    			     <div class="days_val">
    			     	<select name="day" class="days_textBox">
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
    		    <div class="classNum">
    			     <div class="classNum_name">写生班数</div>
    			     <div class="classNum_val">
    			     	<select name="nclass" class="classNum_textBox">
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
    		    <div class="teacherNum">
    			     <div class="teacherNum_name">代课老师数</div>
    			     <div class="teacherNum_val">
    			     	<select name="teachers" class="teacherNum_textBox">
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
            <div class="box1_2">
            	<div class="playTime">
            		<div class="playTime_name">计划学时</div>
            		<div class="playTime_val">
            			<select name="reality" class="playTime_textBox">
            				<option value="0">0</option>
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
    			     		<option value="21">21</option>
    			     		<option value="22">22</option>
    			     		<option value="23">23</option>
    			     		<option value="24">24</option>
    			     		<option value="25">25</option>
    			     		<option value="26">26</option>
    			     		<option value="27">27</option>
    			     		<option value="28">28</option>
            			</select>
            		</div>
            	</div>
            	<div class="classRange">
            		<div class="classRange_name">班级区段</div>
            		<div class="classRange_val">
            			<div class="classRange_textBox">
            				<form:select path="classStart"  class="classRange1_textBox">
            				    <form:options items="${classStartMap}"/>
            			    </form:select>
            			    <div class="logo">~</div>
            			    <form:select path="classFinish"  class="classRange2_textBox">
            				    <form:options items="${classFinishMap }"/>
            			    </form:select>
            			</div>
            		</div>
            	</div>
            	<div class="newPeopleNum">
            		<div class="newPeopleNum_name">新加人数</div>
            		<div class="newPeopleNum_val">
            			<!-- <input type="text" value="0" name="npeople" class="newPeopleNum_textBox"> -->
            			<select name="npeople" class="newPeopleNum_textBox">
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
            	<!-- <div class="infor">
            		<div class="infor_name">描述情况</div>
            		<div class="infor_val">
            			<input type="text" name="peoplem" class="infor_textBox">
            		</div>
            	</div> -->
            </div>
    	</div>
    	</form:form>
    	<input type="button" name="" value="确定" class="button1" onclick="count()">
    	<form:form name="form2" modelAttribute="count" method="post" >
    	<div class="text3">信息显示</div>
    	<div class="box2">
    		<div class="show">
    			<div class="show_name">汇总信息</div>
    			<div class="show_val">
    				<form:input path="classs" class="show_textBox"/>
    			</div>
    		</div>
    		<div class="result">
    			<div class="result_name">计算结果</div>
    			<div class="result_val">
    				<form:input path="result" class="result_textBox"/>
    			</div>
    		</div>
    	</div>
    	<form:hidden path="course"/>
    	<form:hidden path="quantity"/>
    </form:form>
    <input type="button" name="" value="存储" class="button2" onclick="insert()">
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