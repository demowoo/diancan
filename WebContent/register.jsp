<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link type="text/css" href="css/start/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
		
<style type="text/css">
#warning{
	color: red;
}
#reg_wrap{
	width: 300px;
	margin: 0 auto;
	margin-top: 100px;
}
form label{
	font-weight: bold;
}
#back_login{
	color: #A6C9E2;
	font-weight: bold;
	text-decoration: none
}
#back_login:hover{
	color: #2E90BD;
}
#reg_form{
	text-align: center;
}
#reg_href{
	position:absolute;
	top: 5px;
	right: 5px;
}
.line-wrap{
	margin: 20px;
}
#submit_button{
	border-top:1px solid #A6C9E2;
	margin-top: 10px;
	padding-top: 5px;
	font-size: 12px;
}
#reg_title{
	color: #2E90BD;
	border-bottom:1px solid #A6C9E2;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="js/json2.min.js"></script>
<script type="text/javascript">
	function validate(){
		var resultData = "";
		var loginContent = $('#reg_form').serialize();
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
			return true;
		else{
			$('#warning').html(resultData);
			return false;
		}
	}
	
	$(document).ready(function(){
		$("input:submit").button();	
	});
</script>

<title>注册</title>
</head>
<body>
<a href="login.jsp" id="back_login">返回登陆页面</a>
<div id="reg_wrap">
<h2 id="reg_title">注册</h2>
<form id="reg_form" action="register.do" method="post" onsubmit="return validate()">
  <div class="line-wrap"><label>登陆账号: </label><input type="text" name="loginname" id="loginname"/></div>
  <div class="line-wrap"><label>真实姓名: </label><input type="text" name="realname" id="realname"/></div>
  <div class="line-wrap"><label>登陆密码: </label><input type="password" name="password" id="password"/></div>
  <div class="line-wrap"><label>确认密码: </label><input type="password" id="reinput"/></div>
  <div id="submit_button"><input type="submit" value="提交" /></div>
  <span id="warning"></span>
</form>
</div>
</body>
</html>