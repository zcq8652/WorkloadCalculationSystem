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
	<title>信息修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/information.css">
	<script type="text/javascript">
		function button1(){
			document.form1.action="Information/A";
			document.form1.submit();
		}
	</script>
</head>
<body>
	<%
		int option = (int)request.getAttribute("option"); 
		if(option == 1){
	%>
	<script type="text/javascript">
		alert("数据修改成功");
	</script>
	<%} %>
    <div class="all">
    	<div class="title1">密码修改</div>
    	<div class="line"></div>
    	<form:form name="form1" method="post" >
    	<div class="password">
    		<!-- <div class="title2">密码修改</div> -->
    		<div class="password_box">
    			<div class="old">
    				<div class="old_name">原密码</div>
    				<div class="old_val">
    					<input type="password" name="password" class="old_textbox"/>
    				</div>
    			</div>
    			<div class="new">
    				<div class="new_name">新密码</div>
    				<div class="new_val">
    					<input type="password" name="passwords" class="new_textbox"/>
    				</div>
    			</div>
    			<div class="sure">
    				<div class="sure_name">确认密码</div>
    				<div class="sure_val">
    					<input type="password" name="repassword" class="sure_textbox"/>
    				</div>
    			</div>
    		</div>
    	</div>
    	<input type="button" name="" value="修改" class="button1" onclick="button1()">
    	</form:form>
    </div>
</body>
</html>