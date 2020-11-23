$(document).ready(function(){

   
   setInterval(panDuan,500);

   function panDuan(){
    if($(".classType_selectBox").val() == $(".option3").val()){
     /* $(".class_name").text("出行班级数");*/
      $(".time_name").text("出行天数");
      $(".classCourse_name").text("同行老师数");
    }else{
     /* $(".class_name").text("上课班级");*/
      $(".time_name").text("实验学时");
      $(".classCourse_name").text("班内人数");
    }
   }

  
});