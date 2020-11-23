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
	<title>教师工作量提交信息</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/SubmitInformation.css">
	<script src="js/ajaxUtil.js"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/SubmitInformation.js"></script>
	<script type="text/javascript">
	    function getData1(){
	        var p = document.getElementById("div_1");
	        //待审核
	        var status = "status=1_1";
	        myAjax("get","submit/B",status,function(ajax){
	            //获取响应信息
	            var resoult = ajax.responseText;
	            p.innerHTML = resoult;
	        });
	    }
	    function getData2(){
	        var p = document.getElementById("div_2");
	        //待修改
	        var status = "status=2_1";
	        myAjax("get","submit/B",status,function(ajax){
	            //获取响应信息
	            var resoult = ajax.responseText;
	            p.innerHTML = resoult;
	        });
	    }
	    function getData0(){
	        var p = document.getElementById("div_0");
	        //本方向未提交
	        var status = "status=0";
	        myAjax("get","submit/B",status,function(ajax){
	            //获取响应信息
	            var resoult = ajax.responseText;
	            p.innerHTML = resoult;
	        });
	    }
	    function getData3(){
	        var p = document.getElementById("div_3");
	      //教秘审核，特殊情况后端有判断语句
	        var status = "status=2";
	        myAjax("get","submit/B",status,function(ajax){
	            //获取响应信息
	            var resoult = ajax.responseText;
	            p.innerHTML = resoult;
	        });
	    }
	    function getData4(){
	        var p = document.getElementById("div_4");
	        //教秘审核通过
	        var status = "status=3_2";
	        myAjax("get","submit/B",status,function(ajax){
	            //获取响应信息
	            var resoult = ajax.responseText;
	            p.innerHTML = resoult;
	        });
	    }
		function check(){
			document.form.action="Jsp/check2";
			document.form.submit();
		}
	</script>
</head>
<body>
    <div class="all">
    	<div class="title1">教师工作量提交信息</div>
    	<div class="line"></div>
    	<div class="auditBox">
    		<div class="title2">待审核</div>
    	    <div class="audit">
    		<span class="s1">有${check }个教师工作量待审核</span>
    	    </div>
        </div>
            <input type="button" name="" value="名单显示" class="button" onclick="getData1()">
    	    <div id="div_1" class="show"></div>

    	<div class="returnBox">
    		<div class="title3">待修改</div>
    		<div class="return">
    			<span class="s2">有${update }个教师工作量正在修改</span>
    		</div>
        </div>
            <input type="button" name="" value="名单显示" class="button" onclick="getData2()">
    		<div id="div_2" class="show"></div>

    	<div class="notSubmitBox">
    		<div class="title4">未提交</div>
    		<div class="notSubmit">
    			<span class="s3">有${submit }个教师工作量未提交</span>
    		</div>
        </div>
            <input type="button" name="" value="名单显示" class="button" onclick="getData0()">
    		<div id="div_0" class="show"></div>

    	<div class="passBox">
    		<div class="title5">教学秘书审核</div>
    		<div class="pass">
    			<span class="s4">有${pass_1 }个教师工作量教学秘书正在审核</span>
    		</div>
        </div>
            <input type="button" name="" value="名单显示" class="button" onclick="getData3()">
    		<div id="div_3" class="show"></div>
        <div class="pass_1Box">
    		<div class="title6">已通过</div>
    		<div class="pass_1">
    			<span class="s5">有${pass }个教师工作量已通过教学秘书审核</span>
    		</div>
        </div>
            <input type="button" name="" value="名单显示" class="button" onclick="getData4()">
    		<div id="div_4" class="show"></div>
		    <form name="form" method="post">
    			<input type="button" value="前往审核" onclick="check()" class="check_box">
    		</form>
    </div>
</body>
</html>