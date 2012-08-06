<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link type="text/css" href="css/start/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
		
<style type="text/css">

</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="js/json2.min.js"></script>
<script type="text/javascript">
	function validate(){
		var resultData = "";
		var loginContent = $('#login_form').serialize();
		$.ajax({
		   type: "POST",
		   url: "regValidate.do",
		   data: loginContent,
		   timeout: 3000,
		   async: false,
		   success: function(data){
			   resultData = data;
		   },
		   error: function(XMLHttpRequest, textStatus, errorThrown){
			   resultData = "连接服务器出错";
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

<title>注册</title>
</head>
<body>
<a href="login.jsp" id="back_login">返回注册页面</a>
<h1 id="reg_title">注册</h1>
<form id="login_form" action="register.action" method="post" onsubmit="return validate()">
  <p>登陆账号: <input type="text" name="loginname" id="loginname"/></p>
  <p>真实姓名: <input type="text" name="realname" id="realname"/></p>
  <p>登陆密码: <input type="password" name="password" id="password"/></p>
  <p>确认密码: <input type="password" id="reinput"/></p>
  <input type="submit" value="提交" />
  <span id="warning"></span>
</form>
</body>
</html>