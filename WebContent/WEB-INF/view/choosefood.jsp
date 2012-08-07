<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>选择菜式</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<c:if test="${foodlist != null }">
	<c:forEach var="food" items="${foodlist}" >
		<a href="viewfood.action?foodId=${food.id }">
		${food.name } 
		${food.price }
		</a>
		<a href="book.action?foodId=${food.id }&dayOrderId=${dayorderid}">订购</a>
		<br/>
	</c:forEach>
</c:if>
<c:if test="${foodlist == null }">
此餐馆还未添加菜单
</c:if>

<%@ include file="/WEB-INF/template/footer.jsp" %>