<%@ page import="java.util.*,com.rjxy.domain.*" %>
<%@ page pageEncoding="utf-8"
errorPage="wrong.jsp"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragrma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<title>软件学院工作量统计系统主页</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/main.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/mainPage.js"></script>
    <script src="js/ajaxUtil.js"></script>
</head>
<%if(request.getSession().getAttribute("user")==null){
	response.sendRedirect("/WorkloadStatistics1.0/login");
	return;
} %>
<body style="overflow:-Scroll;overflow-x:hidden">  
    <div class="all">
    	<div class="allTop">
    		<div class="systemName">软件学院工作量统计系统</div>
            <div class="selectBox">
                <div class="selectBoxSon1">
                    <input type="text" name="" class="selectBoxSon11">
                    <img src="images/selected4.png" class="selected4Img">
                    <div class="inputText">查找功能...</div>
                </div>
                <div class="selectBoxSon2">
                    <img src="images/selected3.png" class="selected3Img">
                </div>
            </div>
           <!--  <div class="line1"></div> -->
    		<div class="userBox">
    			<!-- <img src="images/man.png" class="image"> -->
    			 <div class="welcome">欢迎您，</div>
    			<div class="username">${sessionScope.user.name}(${sessionScope.user.duty})</div>
    			<img src="images/selectImg.png" class="selectImg">
    		</div>
             <div class="userSelectedBox">
               <!--  <a href="#" class="aLevel">
                     <div class="box1">
                        <img src="images/firstPage.png" class="firstPageImg">
                        <div class="text1">首页</div>
                    </div> 
                </a> -->
                <a href="Jsp/initial"><input type="button" name="" class="abox1" value="首页"></a>
               <a href="Login/exit"> <input type="button" name="" class="abox2" value="注销"></a> 
            </div> 
    	</div>
    	<div class="allLeft">
    		<dl class="dl">
    			<dt class="dt1">
                    <img src="images/computing.png" class="computingImg">
                    课时计算器
                    <img src="images/selected2.png" class="selected2Img1">
                </dt>
    			<dd class="dd">
    				<a href="Jsp/OrdinaryCourse" class="aLevel"><div class="item1">普通课</div></a>
    				<a href="Jsp/Train" class="aLevel"><div class="item">实训/校外写生</div></a>
    				<a href="Jsp/GraduationProject" class="aLevel"><div class="item">毕业设计</div></a>
    				<a href="Jsp/SocialPractice" class="aLevel"><div class="item">社会实践课</div></a>
    				<a href="Jsp/Other" class="aLevel"><div class="item">其它</div></a>
    			</dd>
    			<dt class="dt2">
                    <img src="images/personalInfor.png" class="personalInforImg">
                    个人信息
                    <img src="images/selected2.png" class="selected2Img2">
                </dt>
    			<dd class="dd">
    				<a href="find/myCourse" class="aLevel"><div class="item1">个人课时量</div></a>
    				<a href="Jsp/Information" class="aLevel"><div class="item">密码修改</div></a>
    				<a href="Msg/counts" class="aLevel"><div class="item">个人课时量修改</div></a>
    			</dd>
     <%	String permissions = (String)request.getSession().getAttribute("permissions");
    	List<Direction> dirList = (List<Direction>)request.getAttribute("dirList");
    	if(permissions.equals("系主任")||permissions.equals("院长")) {%>
    			<dt class="dt3">
                    <img src="images/directionalInfor.png" class="directionalInforImg">
                   		系主任工作台
                    <img src="images/selected2.png" class="selected2Img3">
                </dt>
				<dd class="dd" id="myNeed">
 				<%-- <%
 					for(int i = 0 ; i < dirList.size() ; i++) {
 						Direction direction = dirList.get(i);
 					%>
 						<a href="find/typeCourse?major=<%=direction.getName() %>" class="aLevel"><div class="item"><%=direction.getName() %></div></a>
 					<%}%> --%>
 					<a href="Jsp/submitInformation2" class="aLevel"><div class="item">工作量审核</div></a>
    			</dd>
    			
    <% } %>
    <% if(permissions.equals("教学秘书")||permissions.equals("院长")) {%>
    			<dt class="dt4">
                    <img src="images/computingInfor.png" class="computingInforImg">
                    教秘工作台
                    <img src="images/selected2.png" class="selected2Img4">
                </dt>
    			<dd class="dd">
    				<a href="Msg/equation" class="aLevel"><div class="item1">计算公式</div></a>
    				<a href="Msg/position" class="aLevel"><div class="item">双肩挑教师奖励</div></a>
    				<a href="Msg/parameters" class="aLevel"><div class="item">其他工作量参数</div></a>
    				<a href="Msg/course" class="aLevel"><div class="item">课程查改</div></a>
    				<a href="Msg/direction" class="aLevel"><div class="item">方向查改</div></a>
    				<a href="Jsp/submitInformation" class="aLevel"><div class="item">工作量审核</div></a>
    				<a href="find/allCourse" class="aLevel"><div class="item">总查询</div></a>
    			</dd>
    <% } %>
        <% if(permissions.equals("院长")) {%>
    			<dt class="dt5">
                    <img src="images/user1.png" class="user">
                    用户中心
                    <img src="images/selected2.png" class="selected2Img5">
                </dt>
    			<dd class="dd">
    				<a href="Jsp/toRegister" class="aLevel"><div class="item1">注册用户</div></a>
    				<a href="Jsp/toUpdateUser" class="aLevel"><div class="item">修改用户权限</div></a>
    				<a href="Jsp/toResetPassword" class="aLevel"><div class="item">重置用户密码</div></a>
    			</dd>
    <% } %>
    		</dl>
    	</div>
    	<div class="allRight">
    		<jsp:include page="${path }" flush="true"></jsp:include>
    	</div>
    </div>
</body>
	<script type="text/javascript">
	   $.ajax({
		   type:"get",
		   async:false,
		   url:"<%=path%>/Login/getDirection",
		   data:{
			 "name":"$direction.name"  
		   },
		   success:function(data) {
			   var dataObj = $.parseJSON(data);
			   var myMsg = "";
			   for(var i = 0 ; i < dataObj.length ; i++) {
				   myMsg += "<a href='find/typeCourse?major="
				   myMsg += dataObj[i].name+ "' class='aLevel'><div class='item'>"+dataObj[i].name+"</div></a>";
				   console.log(dataObj[i].name);
			   }
			   $("#myNeed").append(myMsg);
		   }	   		
	   })
    </script>
</html>