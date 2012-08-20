<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
<link type="text/css" href="css/start/jquery-ui-1.8.22.custom.css" rel="stylesheet" />
		
<style type="text/css">
#warning{
	color: red;
}
#login_wrap{
	width: 300px;
	margin: 0 auto;
	margin-top: 150px;
}
form label{
	font-weight: bold;
}
#login_form{
	text-align: center;
}
#reg_href{
	position:absolute;
	top: 5px;
	right: 5px;
	color: #A6C9E2;
	font-weight: bold;
	text-decoration: none
}
#reg_href:hover{
	color: #2E90BD;
}
.line-wrap{
	margin: 20px;
}
#login_button{
	border-top:1px solid #A6C9E2;
	margin-top: 10px;
	padding-top: 5px;
	font-size: 12px;
}
#login_title{
	height: 30px;
	line-height: 30px;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("input:submit").button();	
	});
	
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
	<a id="reg_href" href="register.jsp">注册账号</a>
	<div id="login_wrap">
	<form method="post" action="login.do" id="login_form" onsubmit="return validate()">
		<div id="login_title" class="ui-widget-header ui-corner-left ui-corner-right">登陆</div>
		<div class="line-wrap"><label>账号：</label><input type="text" name="name" id="name"/></div>
		<div class="line-wrap"><label>密码：</label><input type="password" name="pass" id="pass"/></div>
		<div id="login_button"><input type="submit" value="提交" id="submit"/></div>
		<span id="warning"></span>
	</form>
	</div>
</body>
</html>