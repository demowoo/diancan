<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>查看订单内容</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<h1>${rest.name }</h1>
<h1>${user.realname }</h1>
<h1>${dayorder.time }</h1>
<c:if test="${orderlist != null }">
	<c:forEach var="order" items="${orderlist}" >
		${order.foodName } 
		${order.price }
		${order.userName } 
		${order.time }
		<br/>
	</c:forEach>
</c:if>

<%@ include file="/WEB-INF/template/footer.jsp" %>