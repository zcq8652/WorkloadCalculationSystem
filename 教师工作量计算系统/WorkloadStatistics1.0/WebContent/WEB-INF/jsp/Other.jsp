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
	<title>其它教学工作量</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/Other.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/Other.js"></script>
	<script type="text/javascript">
		function count(){
			document.form1.action="Jspdb/E";
			document.form1.submit();
		}
		function insert(){
			document.form2.action="JspInsert/E";
			document.form2.submit();
		}
	</script>
</head>
<body>
    <div class="all">
    	<div class="text1">其它教学工作量</div>
    	<div class="line"></div>
    	<div class="title1">指导进修教师和青年教师的工作量</div>
    	<form:form name="form1" modelAttribute="otherQ" method="post">
    	<div class="box1">
    		<div class="number">
    		     <div class="number_name">指导人数</div>
    		     <div class="number_val">
    			     <select name="npeople" class="number_textBox">
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
    	<div class="title2">教学方法研究工作量</div>
    	<div class="box2">
    		<div class="sel">
    			<div class="sel_name">是否参与研究</div>
    			<div class="sel_val">
    				<select name="researchOption" class="sel_textBox">
    					<option value="0" class="option1">否</option>
    					<option value="1" class="option2">是</option>
    				</select>
    			</div>
    		</div>
    		<div class="box2_1">
    			<div class="sciPaperNum">
    				<div class="sciPaperNum_name">发表核心期刊论文数量</div>
    				<div class="sciPaperNum_val">
                        <select name="periodical" class="sciPaperNum_textBox">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>            
                    </div>
    			</div>
    			<div class="classNum">
    				<div class="classNum_name">教学研究课题数量</div>
    				<div class="classNum_val">
                         <select name="researchSubject1" class="classNum_textBox">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                         </select>            
                    </div>
    			</div>
    			<div class="countryPaperNum">
    				<div class="countryPaperNum_name">发表国家一级论文数量</div>
    				<div class="countryPaperNum_val">
                        <select name="paper" class="countryPaperNum_textBox">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                        </select>            
                    </div>
    			</div>
    			<div class="countryClassNum">
    				<div class="countryClassNum_name">国家下达的教学研究课题数量</div>
    				<div class="countryClassNum_val">
                         <select name="researchSubject2" class="countryClassNum_textBox">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                         </select>            
                    </div>
    			</div>
    		</div>
    	</div>
    	<div class="box3">
    		<div class="title3">双肩挑教师的教学工作量</div>
    		<div class="box3_2">
                <div class="box3_2_name">
                    身兼多职的教师是否累计不计：
                </div>
                <div class="box3_2_val">
                    <input type="radio" name="cumulativeOption" value="1" class="radio7" checked>
                    <div class="radio_text7">是</div>
                    <input type="radio" name="cumulativeOption" value="0" class="radio8">
                    <div class="radio_text8">否</div>
                </div>
            </div>
    		<input type="button" name="" value="展开" class="open">
    		<div class="box3_1"><form:checkboxes items="${positionMap }" path="list" /></div>
    	</div>
    	<div class="box4">
    		<div class="title4">课程组/课程群</div>
    		<div class="box4_1">
                    <input type="radio" value="cgroupB" name="group" class="radio1">
                    <div class="radio_text1">课程组普通教师</div>
                    <input type="radio" value="cgroupA" name="group" class="radio2">
                    <div class="radio_text2">课程组组长</div>
                    <input type="radio" value="ccrowdB" name="flock" class="radio3">
                    <div class="radio_text3">课程群普通教师</div>
                    <input type="radio" value="ccrowdA" name="flock" class="radio4">
                    <div class="radio_text4">课程群负责人</div>
    		</div>
    	</div>
    	<div class="box5">
    		<div class="title5">编写教材教学工作量</div>
    		<div class="box5_1">
    			<div class="bookName">
    			     <div class="bookName_name">教材名称</div>
    			     <div class="bookName_val">
    				     <form:select path="course" class="bookName_textBox">
    				     	 <option>请选择</option>
    			    	     <form:options items="${courseMap }"/> 
    				     </form:select>
    			     </div>
    		    </div>
    		</div>
    		<div class="box5_2">
    			<div class="box5_2_name">是否获得国家级规划教材或省级以上优秀教材：</div>
    			<div class="box5_2_val">
    				<input type="radio" name="courseOption" value="1" class="radio5">
    				<div class="radio_text5">是</div>
    				<input type="radio" name="courseOption" value="0" class="radio6" checked>
    				<div class="radio_text6">否</div>
    			</div>
    		</div>
    	</div>
    	<div class="box7">
            <div class="title7">特殊情况(编写多篇教材，上述情况无法全部输入，剩余的填写到下方)</div>
            <div class="box7_1">
                <div class="bookName2">
                    <div class="bookName2_name">教材名称</div>
                    <div class="bookName2_val">
                        <input type="text" name="specialString" class="bookName2_textBox">
                    </div>
                </div>
                <div class="rewardTime">
                    <div class="rewardTime_name">奖励总学时</div>
                    <div class="rewardTime_val">
                        <input type="text" name="specialValue" value="0" class="rewardTime_textBox">
                        <span class="s1">*该教材出版当年对应课程教学计划学时的${textbookA }。获得国家级规划教材的或省级以上优秀教材的另行增加对应课程教学计划学时的${textbookB }。</span>
                    </div>
                </div>
            </div>
        </div>
    	</form:form>
    	<input type="button" name="" value="确定" class="sureButton" onclick="count()">
    	<form:form name="form2" modelAttribute="otherH" method="post">
    	<div class="box6">
    		<div class="title6">信息显示</div>
    		<div class="box6_1">
    			<div class="show">
    			     <div class="show_name">汇总信息</div>
    			     <div class="show_val">
    				     <form:input path="quantity" class="show_textBox"/>
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
    	<form:hidden path="course"/>
    	</form:form>
    	<input type="button" name="" value="存储" class="saveButton" onclick="insert()">
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