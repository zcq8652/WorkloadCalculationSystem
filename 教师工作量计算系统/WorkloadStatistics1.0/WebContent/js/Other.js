$(document).ready(function(){

	$(':radio').click(function(){
	   	var r = $(this).attr("name");
	   	$(":radio[name=" + r + "]:not(:checked)").attr("tag",0);
	   	if($(this).attr("tag") == 1){
	   		$(this).prop('checked',false);
	   		$(this).attr("tag",0);
	   	}else{
	   		$(this).attr("tag",1);
	   	}
	   });
	
  setInterval(panDuan, 100);

  function panDuan(){
     if ($(".sel_textBox").val() == $(".option2").val()) {
         $(".box2_1").css("display","block");
         $(".box2").css("height","200px");
         $(".box3").css("top","370px");
         $(".box4").css("top","480px");
         $(".box5").css("top","555px");
         $(".sureButton").css("top","792px");
         $(".box6").css("top","825px");
         $(".saveButton").css("top","945px");
         $(".box7").css("top","672px");
     }else if($(".sel_textBox").val() == $(".option1").val()){
         $(".box2_1").css("display","none");
         $(".box2").css("height","40px");
         $(".box3").css("top","210px");
         $(".box4").css("top","320px");
         $(".box5").css("top","395px");
         $(".sureButton").css("top","635px");
         $(".box6").css("top","670px");
         $(".saveButton").css("top","790px");
         $(".box7").css("top","513px");
     }

  };
  
   setInterval(panDuan2, 100);

  function panDuan2(){
      if($(".open").val() == "合起"){
        $(".open").click(function(){
     	$(".box3_1").css("display","none");
  	    $(this).val("展开");
  	    $(".box4").css("margin-top","0px");
  	    $(".box5").css("margin-top","0px");
        $(".sureButton").css("margin-top","0px");
        $(".box6").css("margin-top","0px");
        $(".saveButton").css("margin-top","0px");
        $(".box7").css("margin-top","0px");
        });
      }else if($(".open").val() == "展开"){
        $(".open").click(function(){
     	$(".box3_1").css("display","block");
  	    $(this).val("合起");
        $(".box4").css("margin-top","258px");
  	    $(".box5").css("margin-top","258px");
        $(".sureButton").css("margin-top","258px");
        $(".box6").css("margin-top","258px");
        $(".saveButton").css("margin-top","258px");
        $(".box7").css("margin-top","258px");
        });
      }
  }

})