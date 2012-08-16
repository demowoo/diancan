<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">
table{
	width: 700px;
	margin: 10px 0px;
	text-align: center;
}
table th, table td{
	padding: 2px 5px;
}
</style>
<script type="text/javascript">

</script>
<title>选择菜式</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<c:if test="${foodlist != null }">
	<table>
		<tr>
			<th>食物名称</th>
			<th>单价</th>
			<th>操作</th>
		</tr>
		<c:forEach var="food" items="${foodlist}" >
			<tr>
				<td>
					${food.name }
				</td> 
				<td>
					${food.price }元
				</td>
				<td>
					<a href="book.action?foodId=${food.id }&dayOrderId=${dayorderid}">订餐</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
<c:if test="${foodlist == null }">
此餐馆还未添加菜单
</c:if>

<%@ include file="/WEB-INF/template/footer.jsp" %>