<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">
a.button{
	left: 340px;
}
table{
	position:relative;
	margin: 10px;
	text-align: center;
	width: 400px;
	left: 180px;
}

#create_div{
	display: none;
	padding: 5px;
}

</style>
<script type="text/javascript">
$(document).ready(function() { 
    $('.create_order').click(function() { 
        $.blockUI({ 
			message: $('#create_div'),
			css: { 
				padding:        0, 
				margin:         0, 
				width:          '30%', 
				top:            '40%', 
				left:           '35%', 
				textAlign:      'center', 
				color:          '#000', 
				border:         '3px solid #aaa', 
				backgroundColor:'#fff', 
				cursor:         'default' 
   		    }
		}); 
 
    }); 
)};
</script>
<title>点餐页面</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>

<h3 class="h_title">我的订餐</h3>
<table>
	<c:if test="${userorder != null }">
		<tr>
		  <td>${userorder.foodName }</td>
		  <td>${userorder.price }</td>
		  <td>
		  	<c:if test="${open == true}">
		  		<a class='s_button' href="delorder.action?orderId=${userorder.id}">删除</a>
		  	</c:if>
		  	<c:if test="${open == false}">
		  		订单已经关闭
		  	</c:if>
		  </td>
		</tr>
	</c:if>
</table>
<c:if test="${userorder == null }">
	<div class="m_content">你今天还没有订餐</div>
</c:if>

<h3 class="h_title">今日订单</h3>
<c:if test="${dayorderlist != null }">
	<table>
		<c:forEach var="dayorder" items="${dayorderlist}" >
			<tr ${userorder.dayOrderId == dayorder.dayOrderId ? "class='light'":""}>
				<td>${dayorder.restName }</td>
				<td>${dayorder.userName }</td>
				<td>
					
					<a class='s_button' href="viewdayorder.action?dayOrderId=${dayorder.dayOrderId}">查看</a>
					<c:if test="${userorder.dayOrderId != dayorder.dayOrderId }">
					<a class='s_button' href="choosefood.action?restId=${dayorder.restId }&dayOrderId=${dayorder.dayOrderId}">加入订单</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="javascript:void(0)" class="button create_order">添加订单</a>
</c:if>
<c:if test="${dayorderlist == null }">
	<div class="m_content">今天还没有人创建订单</div>
	<a href="javascript:void(0)" class="button create_order">我来创建</a>
</c:if>

<div id="create_div">
	<input type="button" id="create" value="创建" />
</div>
<%@ include file="/WEB-INF/template/footer.jsp" %>