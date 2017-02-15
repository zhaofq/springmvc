$(function(){
    $('#button').click(function(){
    	alert($("#mobile").val())
         $.ajax({
             type: "POST",
             url: "../login",
             data: {"mobile":$("#mobile").val(),"password":$("#password").val()},
             dataType: "json",
             success: function(data){
            	       console.log(data);
                      $('#resText').empty();   //清空resText里面的所有内容
                      window.location.href = "index.html";
             }
         });
    });
});