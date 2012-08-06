<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>添加餐馆</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
	<form id="createorder_form" action="createdayorder.action" method="post">
		<select name="restId">
			<c:forEach var="rest" items="${restlist}" >
				<option value="${rest.id}">${rest.name}</option>
			</c:forEach>
		</select>
	  <input type="submit" value="提交" />
	</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>