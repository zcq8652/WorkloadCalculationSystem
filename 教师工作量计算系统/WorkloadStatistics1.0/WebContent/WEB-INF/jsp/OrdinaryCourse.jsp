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
	<title>普通课课时</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/OrdinaryCourse.css">
	<script src="js/jquery.js"></script>
	<script src="js/OrdinaryCourse.js"></script>
	<script type="text/javascript">
		function count(){
			document.form1.action="Jspdb/A";
			document.form1.submit();
		}
		function insert(){
			document.form2.action="JspInsert/A";
			document.form2.submit();
		}
	</script>
</head>
<body>
    <div class="all">
    	<div class="text1">普通课课时</div>
    	<div class="line1"></div>
    	<div class="text2">请填入以下信息</div>
    	<form:form name="form1" modelAttribute="OrdinaryCourse" method="post" >
    	<div class="box1">
    		<div class="course">
    			<div class="course_name">课程名</div>
    			<div class="course_val">
    				<form:select path="course" class="course_textBox">
    					<option value="无">请选择</option>
    					<form:options items="${courseMap }"/>
    				</form:select>
    			</div>
    		</div>
    		<div class="grade">
    			<div class="grade_name">单班年级</div>
    			<div class="grade_val">
    				<select class="grade_textBox">
    					<option class="option1">大一</option>
    					<option class="option2">大二</option>
    					<option class="option3">大三</option>
    					<option class="option4">大四</option>
    				</select>
    			</div>
    		</div>
    		<div class="classes">
    			<div class="classes_name">单班班级</div>
    			<div class="classes_val">
    			   <div class="classes_textBox1">
    			     <form:checkboxes items="${class1 }" path="classs" class="class1"/>
    			   </div>
    			   <div class="classes_textBox2">
    			     <form:checkboxes items="${class2 }" path="classs" class="class2"/>
    			   </div>
    			   <div class="classes_textBox3">
    			     <form:checkboxes items="${class3 }" path="classs" class="class3"/>
    			   </div>
    			   <div class="classes_textBox4">
    			     <form:checkboxes items="${class4 }" path="classs" class="class4"/>
    			   </div>
    			</div>
    		</div>
    		<div class="grade2">
    			<div class="grade2_name">合班年级</div>
    			<div class="grade2_val">
    			<div class="grade2_textBox">
    			     <span>大一</span>
    			     <input type="button" class="oneBtn" value="1">
    				<span>大二</span>
    				 <input type="button" class="twoBtn" value="2">
    				<span>大三</span>
    				 <input type="button" class="threeBtn" value="3">
    				<span>大四</span>
    				 <input type="button" class="fourBtn" value="4">
    			</div>
    			</div>
    		</div>
    		<div class="classes2">
    			<div class="classes2_name">合班班级</div>
    			<div class="classes2_val">
    			   <div class="classes2_textBox1">
    			     <form:checkboxes items="${class1 }" path="classes1_0" class="class1"/>
    			   </div>
    			   <div class="classes2_textBox1">
    			     <form:checkboxes items="${class1 }" path="classes1_1" class="class1"/>
    			   </div>
    			   <div class="classes2_textBox1">
    			     <form:checkboxes items="${class1 }" path="classes1_2" class="class1"/>
    			   </div>
    			   <div class="classes2_textBox1">
    			     <form:checkboxes items="${class1 }" path="classes1_3" class="class1"/>
    			   </div>
    			   <div class="classes2_textBox2">
    			     <form:checkboxes items="${class2 }" path="classes2_0" class="class2"/>
    			   </div>
    			   <div class="classes2_textBox2">
    			     <form:checkboxes items="${class2 }" path="classes2_1" class="class2"/>
    			   </div>
    			   <div class="classes2_textBox2">
    			     <form:checkboxes items="${class2 }" path="classes2_2" class="class2"/>
    			   </div>
    			   <div class="classes2_textBox2">
    			     <form:checkboxes items="${class2 }" path="classes2_3" class="class2"/>
    			   </div>
    			   <div class="classes2_textBox3">
    			     <form:checkboxes items="${class3 }" path="classes3_0" class="class3"/>
    			   </div>
    			   <div class="classes2_textBox3">
    			     <form:checkboxes items="${class3 }" path="classes3_1" class="class3"/>
    			   </div>
    			   <div class="classes2_textBox3">
    			     <form:checkboxes items="${class3 }" path="classes3_2" class="class3"/>
    			   </div>
    			   <div class="classes2_textBox3">
    			     <form:checkboxes items="${class3 }" path="classes3_3" class="class3"/>
    			   </div>
    			   <div class="classes2_textBox4">
    			     <form:checkboxes items="${class4 }" path="classes4_0" class="class4"/>
    			   </div> 
    			   <div class="classes2_textBox4">
    			     <form:checkboxes items="${class4 }" path="classes4_1" class="class4"/>
    			   </div> 
    			   <div class="classes2_textBox4">
    			     <form:checkboxes items="${class4 }" path="classes4_2" class="class4"/>
    			   </div> 
    			   <div class="classes2_textBox4">
    			     <form:checkboxes items="${class4 }" path="classes4_3" class="class4"/>
    			   </div> 
    			</div>
    		</div>
    		<div class="courseType">
    			<div class="courseType_name">课程类别</div>
    			<div class="courseType_val">
    			    <form:select path="equation" class="courseType_textBox">
    			             <option>请选择</option>
    			    	     <form:options items="${equation }"/>  	
    			    </form:select>
    			</div>
    		</div>
                <!-- <div class="addPeopleNumber">
                    <div class="addPeopleNumber_name">新加人数</div>
                    <div class="addPeopleNumber_val">
                         <input type="text" value="无" name="npeople" class="addPeopleNumber_textBox">
                         <span class="s1">*书写格式：假如有三个班级新加人数分别为1,0,2可以写成1,0,2，特殊情况0,0,0则可以写无，逗号为英文状态下的。</span>
                    </div>
                </div> -->
        </div>
             <div class="choice">
    		<div class="choice_name">是否有新加人数：</div>
    		<div class="choice_val">
    		    <div class="choice_textBox">
    		        <input type="radio" name="decide1" value="1" class="radio1">
                    <div class="radio_text1">是</div>
                    <input type="radio" name="decide1" value="0" class="radio2" checked="checked">
                    <div class="radio_text2">否</div>
    		    </div>
            </div>
    	</div>
    	
    	<div class="box3">
    		<div class="grade3">
    			<div class="grade3_name">年级</div>
    			<div class="grade3_val">
    				<select class="grade3_textBox">
    					<option class="option1">大一</option>
    					<option class="option2">大二</option>
    					<option class="option3">大三</option>
    					<option class="option4">大四</option>
    				</select>
    			</div>
    		</div>
    		<div class="classes">
    			<div class="classes_name">班级</div>
    			<div class="classes_val">
    			   <div class="classes1_textBox">
    			     <form:checkboxes items="${class1 }" path="" class="class1234"/>
    			   </div>
    			   <div class="classes2_textBox">
    			     <form:checkboxes items="${class2 }" path="" class="class1234"/>
    			   </div>
    			   <div class="classes3_textBox">
    			     <form:checkboxes items="${class3 }" path="" class="class1234"/>
    			   </div>
    			   <div class="classes4_textBox">
    			     <form:checkboxes items="${class4 }" path="" class="class1234"/>
    			   </div>      
                </div>
    		</div>
    		<div class="showClasses">
    			<div class="showClasses_name">显示所选班级</div>
    			<div class="showClasses_val">
    				<input type="text" name="classs2" class="showClasses_textBox">
    			</div>
    		</div>
    		<div class="people">
    			<div class="people_name">对应班级新加人数</div>
    			<div class="people_val">
    				<div class="c">
    					<div id="c1" class="core">1</div>
    				    <div id="c2" class="core">2</div>
    				    <div id="c3" class="core">3</div>
    				    <div id="c4" class="core">4</div>
    				    <div id="c5" class="core">5</div>
    				    <div id="c6" class="core">6</div>
    				    <div id="c7" class="core">7</div>
    				    <div id="c8" class="core">8</div>
    				    <div id="c9" class="core">9</div>
    				    <div id="c10" class="core">10</div>
    				</div>
    			</div>
    		</div>
    		<div class="showPeople">
    			<div class="showPeople_name">显示新加人数</div>
    			<div class="showPeople_val">
    				<input type="text" name="npeople" class="showPeople_textBox">
    				<input type="button" value="清空" class="clearBtn">
    			</div>
    		</div>
    	</div>
    	
    	<input type="button" name="" value="确认" class="sureBtn" onclick="count()">
    	</form:form>
    	<div class="text3">信息显示</div>
    	<form:form name="form2" modelAttribute="count" method="post" >
    	<div class="box2">
    		<div class="sumTime">
    			<div class="sumTime_name">课程总学时</div>
    			<div class="sumTime_val">
    				<form:input path="total" class="sumTime_textBox"/>
    			</div>
    		</div>
    		<div class="theoryTime">
    			<div class="theoryTime_name">理论学时</div>
    			<div class="theoryTime_val">
    				<form:input path="reality" class="theoryTime_textBox"/>
    			</div>
    		</div>
    		<div class="experimentTime">
    		    <div class="experimentTime_name">实验学时</div>
    			<div class="experimentTime_val">
    				<form:input path="experiment" class="experimentTime_textBox"/>
    			</div>
    		</div>
    		<div class="number">
    	        <div class="number_name">班级人数</div>
    	        <div class="number_val">
    	             <form:input path="classs_show" class="number_textBox"/>
    	        </div>
    	    </div>
    		<div class="result">
    			<div class="result_name">计算结果</div>
    			<div class="result_val">
    				<form:input path="resultString" class="result_textBox"/>
    			</div>
    		</div>
    	</div>
    	   <form:hidden path="realityQuantity"/>
    	   <form:hidden path="experimentQuantity"/>
    	   <form:hidden path="ctype"/>
    	   <form:hidden path="course"/>
    	   <form:hidden path="realityResult"/>
    	   <form:hidden path="experimentResult"/>
    	   <form:hidden path="classs"/>
    	<input type="button" name="" value="存储" class="storageBtn" onclick="insert()">
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