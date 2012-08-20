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
<title>管理界面</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<c:if test="${userlist != null }">
	<table>
		<tr>
			<th>账号名称</th>
			<th>真实姓名</th>
			<th>账户类型</th>
			<th>是否激活</th>
			<th>操作</th>
		</tr>
		<c:forEach var="user" items="${userlist}" >
			<tr>
				<td>
					${user.loginname }
				</td> 
				<td>
					${user.realname }
				</td>
				<td>
					${user.type == 1 ? "管理员":"普通账户" }
				</td>
				<td>
					${user.active == true ? "已激活" : "未激活" }
				</td>
				<td>
					<c:if test="${user.active == false }">
						<a href="activeuser.action?userId=${user.id }">激活</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<%@ include file="/WEB-INF/template/footer.jsp" %>