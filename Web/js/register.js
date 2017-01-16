$(function(){
    $('#button').click(function(){
         $.ajax({
             type: "POST",
             url: "../registerUser",
             data: {"mobile":$("#mobile").val(),"password":$("#password").val(),"passwords":$("#passwords").val()},
             dataType: "json",
             success: function(data){
                      $('#resText').empty();   //清空resText里面的所有内容
             }
         });
    });
});