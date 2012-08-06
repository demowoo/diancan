<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>添加餐馆</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
	<form id="addrest_form" action="addrest.action" method="post" onsubmit="return validate()">
	  <p>餐馆名称: <input type="text" name="name" id="name"/></p>
	  <p>餐馆介绍: <input type="text" name="intro" id="intro"/></p>
	  <p>餐馆地址: <input type="text" name="address" id="address"/></p>
	  <p>联系电话: <input type="text" name="phone" id="phone"/></p>
	  <input type="submit" value="提交" />
	</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>