<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>点餐页面</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<c:if test="${userorder != null }">
${userorder.foodName }
${userorder.price }
</c:if>

<c:if test="${dayorderlist != null }">
	<c:forEach var="dayorder" items="${dayorderlist}" >
		<c:if test="${userorder.dayOrderId == dayorder.dayOrderId }">
			<h1>
		</c:if>
			<a href="viewdayorder.action?dayOrderId=${dayorder.dayOrderId}">
			${dayorder.dayOrderId }
			${dayorder.time }
			${dayorder.open }
			${dayorder.restName }
			${dayorder.restId }
			${dayorder.userName }
			</a>
		<c:if test="${userorder.dayOrderId == dayorder.dayOrderId }">
			</h1>
		</c:if>
		<a href="choosefood.action?restId=${dayorder.restId }&dayOrderId=${dayorder.dayOrderId}">加入订单</a>
		<br/>
	</c:forEach>
</c:if>


<a href='createorder.htm'>新建</a>

<%@ include file="/WEB-INF/template/footer.jsp" %>