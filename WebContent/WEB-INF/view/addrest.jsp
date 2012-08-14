<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">
#addrest_form{
	position: relative;
	border: 1px;
	padding: 15px 5px 5px 5px;
}
div.itemWrapper{
	position: relative;
	padding-left: 340px;
	padding-bottom: 10px;
}
form label{
 	position: absolute;
	text-align: right;
	left: 0;
	width: 330px;
	display: block;
	font-size: 14px;
	padding: 4px 5px;
}
input.input-text{
	display: block;
	left: 0;
	width: 200px;
	background-color: #FBFBFB;
    background-position: 0 -72px;
    border: 1px solid #C1C1C1;
    color: #444444;
    font-size: 14px;
    padding: 4px 5px;
}
#intro{
	height: 50px;
	width: 200px;
    overflow :  auto ;
    background-color: #FBFBFB;
    background-position: 0 -72px;
    border: 1px solid #C1C1C1;
    color: #444444;
    font-size: 14px;
    padding: 4px 5px;
    resize: none;
}

</style>
<script type="text/javascript">

</script>
<title>添加餐馆</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
	<form id="addrest_form" action="addrest.action" method="post" onsubmit="return validate()">
	  <div class="itemWrapper"><label>餐馆名称: </label><input class="input-text" type="text" name="name" id="name"/></div>
	  <div class="itemWrapper"><label>餐馆介绍: </label><textarea class="input-text" name="intro" id="intro"></textarea></div>
	  <div class="itemWrapper"><label>餐馆地址: </label><input class="input-text" type="text" name="address" id="address"/></div>
	  <div class="itemWrapper"><label>联系电话: </label><input class="input-text" type="text" name="phone" id="phone"/></div>
	  <div class="itemWrapper"><input type="submit" value="提交" class="button"/></div>
	</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>