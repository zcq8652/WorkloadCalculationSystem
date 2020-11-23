$(document).ready(function(){

	$(".selectBoxSon2").click(function(){
         $(".selectBoxSon1").toggle(500);
	});

    $(".selectBoxSon11").click(function(){
         $(".selected4Img").css("display","none");
	     $(".inputText").css("display","none");
	});
    
    $(".userBox").click(function(){
         $(".userSelectedBox").toggle(1);
    });

    var box1 = document.getElementsByClassName("abox1")[0];
    var box2 = document.getElementsByClassName("abox2")[0];
    /*var box3 = document.getElementsByClassName("box3")[0];*/

    box1.onmouseover = function(){
    	this.style.backgroundColor = "#F8B466";
    }
    box1.onmouseout = function(){
    	this.style.backgroundColor = "#fff";
    }
    box2.onmouseover = function(){
    	this.style.backgroundColor = "#F8B466";
    }
    box2.onmouseout = function(){
    	this.style.backgroundColor = "#fff";
    }
    /*box3.onmouseover = function(){
    	this.style.backgroundColor = "#F8B466";
    }
    box3.onmouseout = function(){
    	this.style.backgroundColor = "#fff";
    }*/

    $(".dd").hide();
 
    $("dt").click(function(){
    	$(this).next().slideToggle(200);
    	$(this).siblings("dt").next().slideUp(200);
    });

   $("dt").hover(function(){
      $(this).css("color","#438eb9");
    },function(){
      $(this).css("color","#585858");
    });
    
    $(".item1").hover(function(){
    	$(this).css("color","#438eb9");
    },function(){
    	$(this).css("color","#757575");
    });

    $(".item").hover(function(){
    	$(this).css("color","#438eb9");
    },function(){
    	$(this).css("color","#757575");
    });
    
    $(".dt1").hover(function(){
    	$(".computingImg").attr("src","images/computing2.png");
    	$(".selected2Img1").attr("src","images/selected5.png");
    },function(){
    	$(".computingImg").attr("src","images/computing.png");
    	$(".selected2Img1").attr("src","images/selected2.png");
    });

    $(".dt2").hover(function(){
    	$(".personalInforImg").attr("src","images/personalInfor2.png");
    	$(".selected2Img2").attr("src","images/selected5.png");
    },function(){
    	$(".personalInforImg").attr("src","images/personalInfor.png");
    	$(".selected2Img2").attr("src","images/selected2.png");
    });

    $(".dt3").hover(function(){
    	$(".directionalInforImg").attr("src","images/directionalInfor2.png");
    	$(".selected2Img3").attr("src","images/selected5.png");
    },function(){
    	$(".directionalInforImg").attr("src","images/directionalInfor.png");
    	$(".selected2Img3").attr("src","images/selected2.png");
    });
    
    $(".dt4").hover(function(){
    	$(".computingInforImg").attr("src","images/computingInfor2.png");
    	$(".selected2Img4").attr("src","images/selected5.png");
    },function(){
    	$(".computingInforImg").attr("src","images/computingInfor.png");
    	$(".selected2Img4").attr("src","images/selected2.png");
    });
    
    $(".dt5").hover(function(){
    	$(".user").attr("src","images/user2.png");
    	$(".selected2Img5").attr("src","images/selected5.png");
    },function(){
    	$(".user").attr("src","images/user1.png");
    	$(".selected2Img5").attr("src","images/selected2.png");
    });

});