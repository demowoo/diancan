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
h3{
	border-bottom: 1px solid #000;
}
</style>
<script type="text/javascript">

</script>
<title>我的信息</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<h3>历史订餐记录</h3>
<c:if test="${hislist != null }">
	<table>
		<tr>
			<th>食物名称</th>
			<th>餐馆名称</th>
			<th>价钱</th>
			<th>订单组织者</th>
			<th>订餐时间</th>
		</tr>
		<c:forEach var="history" items="${hislist}" >
			<tr>
				<td>
					${history.foodname }
				</td> 
				<td>
					${history.restname }
				</td>
				<td>
					${history.price }
				</td>
				<td>
					${history.organizer }
				</td>
				<td>
					${history.ordertime }
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<%@ include file="/WEB-INF/template/footer.jsp" %>