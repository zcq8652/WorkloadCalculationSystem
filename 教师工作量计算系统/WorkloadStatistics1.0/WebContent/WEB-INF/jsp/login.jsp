<%@ page pageEncoding="utf-8"
errorPage="wrong.jsp"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<title>登录界面</title>
	<meta charset="utf-8">
	<script src="js/ajaxUtil.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/login.js"></script>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript">
        function getData(){
            var data = document.getElementById("uid").value;
            var m = document.getElementById("uid");
            data = "uid=" + data;
            myAjax("get","LoginServlet",data,function(ajax){
                //获取响应信息
                var resoult = ajax.responseText;
                //p.innerHTML = resoult;
                eval("var rs="+resoult);
                //处理响应信息
                if(rs.message == "YES"){
                    m.style.color = "black";
                }else if(rs.message == "NO"){
                    m.style.color = "red";
                }
            });
        }
    </script>
</head>
<body>
    <div class="all">
    	<div class="block">
    		<div class="blockTitle">欢迎登录工作量统计系统</div>
    		<div class="line"></div>
            <img src="images/login.png" class="loginImg">
            <div class="line2"></div>
    		<div class="login">
    			<form action="Login/main" method="post">
    				<input type="text" name="uid" id="uid" onblur="getData()" class="username"  placeholder="账号">
    				<input type="password" name="password" class="password" placeholder="密码">
                    <input type="submit" name="" value="登录" class="teacherBtn">
                    <input type="reset" name="" value="重置" class="reTeacherBtn">
                    <input type="checkbox" name="option" value="automatic" class="option">
    			</form>
    		</div>
            <div class="forget">忘记密码？</div>
            <div class="line3"></div>
                <div class="option1">自动登录</div>
            <%
               String option = (String)request.getAttribute("option"); 
               if(option == "1"){
            %>
               <script type="text/javascript">
					alert("当前账号已被登录");
               </script>
            <%} %>
    	</div>
    	<div class="allbox">
    	<img src="images/school8.jpg" class="image">
    	<div class="text1">亲爱的老师：</div>
    	<div class="text2">您好！</div>
    	<div class="text3">欢迎您使用本网站！</div>
        <div class="text4">学生才疏学浅，未能将其做到最好，但<br>也已是竭尽全力。</div>
        <div class="text5">本网站若有何不妥之处，还望您多多担<br>待。</div>
        <div class="text6">在此，由衷的感谢老师给与我们参加此<br>项目的机会。</div>
        <div class="text7">从中我们学到了很多，不负付出，不期<br>所望！</div>  
        <div class="text8">最后还是得说:</div>    
        <div class="text9">很抱歉，此功能暂时无法使用，请找管<br>理员找回密码。</div>    
        <div class="text10">此致</div>     
        <div class="text11">敬礼</div>    
        </div>
    </div>
</body>
</html>