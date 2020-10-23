<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register user here</title>
<style>
.error-class{
color:red;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#id").change(function(){
    $.ajax({
    	url:"validateEmail",
    	data:{id:$("#id").val()},
    	success:function(reponseText){
    		console.log("sdfds"+reponseText)
    		$("#error").text(reponseText);
    		if(reponseText!=null){
    			$("#id").focus();
    		}
    	}
    })
  });
});
</script>
</head>
<body>
	<form action="registerUser" method="post">
		<pre>
			ID: <input type="text" name="id" id="id"/><br/><span class="error-class" id="error"></span>
			Name: <input type="text" name="name" /><br/>
			Email: <input type="text" name="email" /><br/>
			<input type="submit" name="register" />
		</pre>
	</form>
	<br/>
	<p>${result}</p>
</body>
</html>