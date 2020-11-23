<%@page import="com.rjxy.domain.Equation"%>
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
	<title>课程公式修改</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/equationMsg.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/myCode.js"></script>
</head>
<body>
    <div class="all">
    	<div class="title1">课程公式修改</div>
    	<div class="line"></div>
    	<div class="table_box">
	    			<span class="t1">编号</span>
	    			<span class="t2">课程类型</span>
	    			<span class="t3">公式</span>
	    			<span class="t4">操作</span>
    	     <table  border="1" style="border-style:solid ;border-collapse: collapse">
    	     	<tr style="display:none">
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			<% ArrayList<Equation> equations = (ArrayList<Equation>)request.getAttribute("msg");
			   for(int i = 0 ; i < equations.size() ; i++) {
				   Equation equation = equations.get(i);  
			%>

			<form action="Update/equation" method="post" class="myForm">
				<tr>
					<td class="id"><input type="text" class="id_box" name="id" value="<%=equation.getNumberA() %>" style="border:none;" readonly="true"></td>
					<td class="name"><input type="text" class="name_box" name="type" value="<%=equation.getType() %>" style="border:none;" readonly="true"></td>
					<td class="formula"><input type="text" class="formula_box" name="formula" value="<%=equation.getFormula() %>" style="border:none;" readonly="true"></td>
					<td class="btn1"><input type="submit" class="myBtn" value="修改"><a href="Delete/equation?id=<%=equation.getNumberA()%>" class="del">删除</a></td>
					<%-- <td class="btn2"><a href="Delete/equation?id=<%=equation.getNumberA()%>">删除</a></td> --%>
				</tr>
			</form>
			<%
			   }
			%>
				<form action="Insert/equation" method="post">
					<tr>
						<td class="id2"><input type="text" class="id_box2" name="id"></td>
						<td class="name2"><input type="text" class="name_box2" name="type"></td>
						<td class="formula2"><input type="text" class="formula_box2" name="formula"></td>
						<td class="btn2"><input type="submit" class="btn2" value="添加"></td>
					</tr>
				</form>
			</table>
    	</div>
    	<div class="prompt">
            <div class="prompt_title">温馨提示</div>
            <div class="prompt_content">
            <br>
            <span class="span1">
            	<p class="p1">公式可用参数：</p><br>
            <p class="p2">total;//总学时 </p>
            <p class="p3">reality;//理论课时 </p> 
            <p class="p4">experiment;//实验课时</p>   
            <p class="p5">npeople;//学生人数或指导教师人数</p>   
            <p class="p6">nclass;//校外写生所带班级数 </p> 
            <p class="p7">nday;//天数数  </p>
            </span>
             <span class="span3">
            <p class="p8">ngroup;//组数</p> 
            <p class="p9">nteacher;//校外写生代课老师 </p>
            <p class="p10">nteam;//毕业设计团队组数  </p>  
            <p class="p11">nweekA;//毕业设计个人设计周数 </p>
            <p class="p12">nweekB;//毕业设计团队设计周数 </p>
            <p class="p13">result;//计算结果</p>
            </span>
            <span class="span2"><br>
            <p class="p14">特殊情况请联系管理员在数据库修改（示例）：</p><br>
           <!--  <p class="p15">示例</p> -->
            <p class="p16">理论课教学工作量 = （ X + Y ）× 计划学时</p>
            <p class="p17">说明：</p>
            <p class="p18">①  X = （人数-40）/200 ，若总人数小于40，则X为0；</p>
            <p class="p19">②  Y为课程类型修正系数。</p>
            <p class="p20">总人数小于40就是特殊情况，遇到这种情况请简化公式
            </p>
            <p class="p21">上述可改为Y*计划学时</p>
            </span>
            </div>
        </div>
    </div>
</body>
</html>