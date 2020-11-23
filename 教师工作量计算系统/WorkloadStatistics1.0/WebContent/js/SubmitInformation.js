$(document).ready(function(){
	
   $(".show").hide();
   $(".button").toggle(function(){
     $(this).next().slideDown("fast");
     $(this).val("名单合起");
   },function(){
     $(this).next().slideUp("fast");
     $(this).val("名单显示");
   });

})