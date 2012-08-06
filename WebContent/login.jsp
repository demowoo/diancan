<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link type="text/css" href="css/start/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
		
<style type="text/css">

</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript">
	function validate(){
		var resultData = "";
		var loginContent = $('#login_form').serialize();
		$.ajax({
		   type: "POST",
		   url: "validate.do",
		   data: loginContent,
		   timeout: 3000,
		   async: false,
		   success: function(data){
			   resultData = data;
		   },
		   error: function(XMLHttpRequest, textStatus, errorThrown){
			   resultData= "连接服务器出错";
		   }
		});
		if(resultData == "ok")
			return  true;
		else{
			$('#warning').html(resultData);
			return false;
		}
	}
</script>
</head>
<body>
	<a href="register.jsp">注册账号</a>
	<form method="post" action="login.action" id="login_form" onsubmit="return validate()">
		<div><label>用名：</label><input type="text" name="name" id="name"/></div>
		<div><label>密码：</label><input type="password" name="pass" id="pass"/></div>
		<input type="submit" value="登陆" id="submit"/>
		<span id="warning"></span>
	</form>
</body>
</html>