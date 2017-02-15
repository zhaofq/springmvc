$(function(){
         $.ajax({
//             type: "POST",
			 url: "../findPictures",
//			 data: {"mobile":$("#mobile").val(),"password":$("#password").val(),"passwords":$("#passwords").val()},
//			 dataType: "json",
			 success: function(data){
				 console.log(data)
//          $('#resText').empty();   //清空resText里面的所有内容
         }
     });
});