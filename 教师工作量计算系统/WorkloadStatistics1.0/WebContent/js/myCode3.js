$(document).ready(function(){  // 等待Dom元素加载完毕
   $(".myForm").submit(function(){
	  var button = $(this).next().children(".btn").children(".myBtn");
	  console.log($(".myForm"));
	  if(button.val() == "修改") {
		  button.parent().prev().prev().children().removeAttr("readonly");
		  button.parent().prev().prev().children().css("border","1px solid black");
		  button.attr("value","确定");
		  return false;
	  }
   });
   
   $(".del").click(function(){
	   if(confirm("确认删除")==false) {
		   return false;
	   };
   });
});