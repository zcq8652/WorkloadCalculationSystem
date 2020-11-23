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
	<title>社会实践</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/css_SocialPractice.css">
	<script type="text/javascript">
		function count(){
			document.form1.action="Jspdb/D";
			document.form1.submit();
		}
		function insert(){
			document.form2.action="JspInsert/D";
			document.form2.submit();
		}
	</script>
</head>
<body>
    <div class="all">
    	<div class="text1">社会实践</div>
    	<div class="line1"></div>
    	<form:form modelAttribute="countQ" method="post" name="form1">
    	<div class="text2">请填入以下信息</div>
    	<div class="socialBox">
    	    <div class="courseType">
    	       <div class="courseType_name">课程类型</div>
    	       <div class="courseType_val">
    	          <form:select path="numberA" class="courseType_textBox">
    	              	<option>请选择</option>
    					<form:options items="${equation }"/>
    			  </form:select>
    	       </div>
    	    </div>
    		<div class="socialday">
    			<div class="socialday_name">实践天数</div>
    		<div class="socialday_val">
    			<select name="nday" class="socialday_box">
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
    		<div class="number">
    			<div class="number_name">组数</div>
    			<div class="number_val">
    				<select name="ngroup" class="number_box">
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
    	</form:form>
    	<form:form modelAttribute="countH" method="post" name="form2">
    	<div class="text3">信息显示</div>
    	<div class="socialBox2">
    	     <div class="show">
    		    <div class="show_name">信息显示</div>
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
    	<input type="button" name="" value="确认" class="button1" onclick="count()">
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