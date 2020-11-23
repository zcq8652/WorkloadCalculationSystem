$(document).ready(function(){
   
   setInterval(panDuan3, 100);

   function panDuan3(){
    if($(".computingType_textBox").val() == $(".option1").val()){
   	  $(".box1_1").css("display","none");
   	  $(".box1_2").css("display","block");
   	  $(".box1").css("height","199.5px");
   	   $(".button1").css("top","300px");
    }else if($(".computingType_textBox").val() == $(".option2").val()){
   	  $(".box1_1").css("display","block");
   	  $(".box1_2").css("display","none");
   	  $(".box1").css("height","200px");
   	  $(".button1").css("top","300px");
    }
   }

})