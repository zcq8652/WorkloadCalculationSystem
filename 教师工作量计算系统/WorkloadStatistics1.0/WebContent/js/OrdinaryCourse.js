$(document).ready(function(){
	
	setInterval(panDuan2,100);
	
	function panDuan2(){
		if($(".grade_textBox").val() == $(".option1").val()){
			$(".classes_textBox1").css("display","block");
			$(".classes_textBox2").css("display","none");
			$(".classes_textBox3").css("display","none");
			$(".classes_textBox4").css("display","none");
			/*console.log("111");*/
		}else if($(".grade_textBox").val() == $(".option2").val()){
			$(".classes_textBox1").css("display","none");
			$(".classes_textBox2").css("display","block");
			$(".classes_textBox3").css("display","none");
			$(".classes_textBox4").css("display","none");
			/*console.log("222");*/
		}else if($(".grade_textBox").val() == $(".option3").val()){
			$(".classes_textBox1").css("display","none");
			$(".classes_textBox2").css("display","none");
			$(".classes_textBox3").css("display","block");
			$(".classes_textBox4").css("display","none");
			/*console.log("333");*/
		}else if($(".grade_textBox").val() == $(".option4").val()){
			$(".classes_textBox1").css("display","none");
			$(".classes_textBox2").css("display","none");
			$(".classes_textBox3").css("display","none");
			$(".classes_textBox4").css("display","block");
			/*console.log("444");*/
		}
	}
	
	var classes2_textBox1 = document.getElementsByClassName("classes2_textBox1");
	var classes2_textBox2 = document.getElementsByClassName("classes2_textBox2");
	var classes2_textBox3 = document.getElementsByClassName("classes2_textBox3");
	var classes2_textBox4 = document.getElementsByClassName("classes2_textBox4");
	var count = 0;
	classes2_textBox1[count].style.display = "block";
	$(".oneBtn").click(function(){
		console.log(count);
		count++;
		if(count == 4){
			count = 0;
		}
	    if(count == 0){
			classes2_textBox1[count].style.display = "block";
			classes2_textBox1[3].style.display = "none";
		}else{
			classes2_textBox1[count].style.display = "block";
			classes2_textBox1[count - 1].style.display = "none";
		}
	    
        classes2_textBox1[count].style.display = "block";
		$(".classes2_textBox2").css("display","none");
		$(".classes2_textBox3").css("display","none");
		$(".classes2_textBox4").css("display","none");
		/*console.log("11");*/
	});
	$(".twoBtn").click(function(){
		
		console.log(count);
		count++;
		if(count == 4){
			count = 0;
		}
	    if(count == 0){
			classes2_textBox2[count].style.display = "block";
			classes2_textBox2[3].style.display = "none";
		}else{
			classes2_textBox2[count].style.display = "block";
			classes2_textBox2[count - 1].style.display = "none";
		}
	    
        classes2_textBox2[count].style.display = "block";
		$(".classes2_textBox1").css("display","none");
		$(".classes2_textBox3").css("display","none");
		$(".classes2_textBox4").css("display","none");
		/*console.log("22");*/
	});
	$(".threeBtn").click(function(){

		console.log(count);
		count++;
		if(count == 4){
			count = 0;
		}
	    if(count == 0){
			classes2_textBox3[count].style.display = "block";
			classes2_textBox3[3].style.display = "none";
		}else{
			classes2_textBox3[count].style.display = "block";
			classes2_textBox3[count - 1].style.display = "none";
		}
	    
        classes2_textBox3[count].style.display = "block";
        $(".classes2_textBox1").css("display","none");
		$(".classes2_textBox2").css("display","none");
		$(".classes2_textBox4").css("display","none");
		/*console.log("33");*/
	});
	$(".fourBtn").click(function(){
		$(".classes2_textBox1").css("display","none");
		$(".classes2_textBox2").css("display","none");
		$(".classes2_textBox3").css("display","none");
		console.log(count);
		count++;
		if(count == 4){
			count = 0;
		}
	    if(count == 0){
			classes2_textBox4[count].style.display = "block";
			classes2_textBox4[3].style.display = "none";
		}else{
			classes2_textBox4[count].style.display = "block";
			classes2_textBox4[count - 1].style.display = "none";
		}
	    
        classes2_textBox4[count].style.display = "block";
		/*console.log("44");*/
	});
	  //控制盒子显隐
	   $(".radio1").click(function(){
	   	   $(".box3").css("display","block");
	   	   $(".sureBtn").css("top","580px");
	   	   $(".text3").css("top","620px");
	   	   $(".box2").css("top","645px");
	   	   $(".storageBtn").css("top","860px");
	   });
	   $(".radio2").click(function(){
	   	   $(".box3").css("display","none");
	   	   $(".sureBtn").css("top","380px");
	   	   $(".text3").css("top","410px");
	   	   $(".box2").css("top","435px");
	   	   $(".storageBtn").css("top","650px");
	   });
	   //控制班级框动态显示
	   setInterval(panDuan,100);
	   function panDuan(){
	     if ($(".grade3_textBox").val() == $(".option1").val()) {
	   	   $(".classes1_textBox").css("display","block");
	   	   $(".classes2_textBox").css("display","none");
	   	   $(".classes3_textBox").css("display","none");
	   	   $(".classes4_textBox").css("display","none");
	     }else if($(".grade3_textBox").val() == $(".option2").val()){
	   	   $(".classes1_textBox").css("display","none");
	   	   $(".classes2_textBox").css("display","block");
	   	   $(".classes3_textBox").css("display","none");
	   	   $(".classes4_textBox").css("display","none");
	     }else if($(".grade3_textBox").val() == $(".option3").val()){
	   	   $(".classes1_textBox").css("display","none");
	   	   $(".classes2_textBox").css("display","none");
	   	   $(".classes3_textBox").css("display","block");
	   	   $(".classes4_textBox").css("display","none");
	     }else if($(".grade3_textBox").val() == $(".option4").val()){
	       $(".classes1_textBox").css("display","none");
	   	   $(".classes2_textBox").css("display","none");
	   	   $(".classes3_textBox").css("display","none");
	   	   $(".classes4_textBox").css("display","block");
	     }
	   }
	   //控制新加人数的显示
	   var demo = '';
	   $(".showPeople_textBox").val("...");
	   console.log($(".showPeople_textBox").val());
	   $(".core").click(function(){
	   	   var c = $(this).text();
	   	   if($(".showPeople_textBox").val() != "..."){
	   		  demo += (',' + c);
	   	   }else{
	   		   demo = c;
	   	   }
	   	   $(".showPeople_textBox").val(demo);
	   });
	   $(".clearBtn").click(function(){
		   $(".showPeople_textBox").val("...");
	   });
	   
	 //控制所选班级的显示
	   var demo2 = '';
	   $(".showClasses_textBox").val("...");
	   //多选框触发事件
	   $(".class1234").click(function(){
		   var a = $(this).val();
		   //选中触发事件
		   if($(this).is(":checked") == true){
			   if($(".showClasses_textBox").val() != '...'){
				   demo2 += (',' + a);
			   }else{
				   demo2 += a;
			   }
			   console.log(demo2);
		   }else{//未选中触发事件
			   if(a == demo2.substring(0,4)){
				   demo2 = demo2.replace(a + ',','');
			   }else{
				   demo2 = demo2.replace(',' + a,'');
			   }
			   console.log(demo2);
		   }
		   $(".showClasses_textBox").val(demo2);
	   });
	   
})