<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">
#title_wrapper{
	border-bottom: 1px solid #000;
}

table{
	width: 700px;
	margin: 10px 30px;
	text-align: center;
}
table th, table td{
	padding: 2px 5px;
}

#title_wrapper{
	padding-left:20px;
	padding-bottom: 5px;
	font-weight: bold;
	font-size: 16px;
}
.summary{
	padding-left: 100px;
	text-align: left;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".time").each(function(){
		var value = $(this).html();
		$(this).html(formatTime(value));
	});
});
</script>
<title>查看订单内容</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<div id="title_wrapper">
	<span class="title">今日订单：</span>
	<span class="title">${rest.name }</span>
	<span class="title">${user.realname }</span>
	<span class="title time">${dayorder.time }</span>
</div>
<table>
	<tr>
		<th>食物名称</th>
		<th>食物价格</th>
		<th>点餐人</th>
		<th>订餐时间</th>
	</tr>
	<c:if test="${orderlist != null }">
		<c:forEach var="order" items="${orderlist}" >
			<tr>
			  <td>${order.foodName } </td>
			  <td>${order.price }元</td>
			  <td>${order.userName }</td>
			  <td class="time">${order.time }</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<br/>
<br/>
<div id="title_wrapper">订单概要 联系电话：${rest.phone } 总价：${totalprice }元</div>
<table>
	<c:if test="${summarylist != null }">
		<c:forEach var="summary" items="${summarylist}" >
			<tr>
			  <td class="summary">${summary.foodname } </td>
			  <td class="summary">${summary.count }份</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<%@ include file="/WEB-INF/template/footer.jsp" %>