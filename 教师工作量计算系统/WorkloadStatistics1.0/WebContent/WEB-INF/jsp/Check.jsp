<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
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
	<title>审核</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/check.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/check.js"></script>
	<script src="js/ajaxUtil.js"></script>
	<script type="text/javascript">
        function getData_update(){
            var uid = document.getElementById("uid").value;
            var status =  $('input:radio:checked').val();
            var information =encodeURI(encodeURI(document.getElementById("information").value));
            var p = document.getElementById("div_show");
            var data = "uid=" + uid + "&status=" + status + "&information=" + information;
            myAjax("get","check/B",data,function(ajax){
                //获取响应信息
                var resoult = ajax.responseText;
                p.innerHTML = resoult;                
            });
        }
        function getData(){
            var p = document.getElementById("div_show");
            myAjax("get","check/A",null,function(ajax){
                //获取响应信息
                var resoult = ajax.responseText;
                p.innerHTML = resoult;
            });
        }
		function returnSub(){
			document.form.action="Jsp/submitInformation";
			document.form.submit();
		}
    </script>
</head>
<body>
    <div class="all">
    	<form name="form">
    		<input type="button" name="" value="返回" class="goaway" onclick="returnSub()">
    	</form>
    	    <div id="div_show" class="check_box"></div>
    	    <input type="button" name="" value="下一页" class="next" onclick="getData_update()">
    	<div class="bottom"></div>
    	<input type="button" name="" value="开始审核" class="run" onclick="getData()">
    </div>
</body>
</html>