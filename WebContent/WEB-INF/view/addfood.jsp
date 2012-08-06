<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>添加食物</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
	<form id="addfood_form" action="addfood.action" method="post" onsubmit="return validate()">
		<select name="restId">
			<c:forEach var="rest" items="${restlist}" >
				<option value="${rest.id}">${rest.name}</option>
			</c:forEach>
		</select>
		<p>菜名: <input type="text" name="name" id="name"/></p>
		<p>价格: <input type="text" name="pri" id="pri"/></p>
		<p>辣: <input type="radio" name="hot" value="1" /> 辣
			   <input type="radio" name="hot" value="0" checked="checked"/> 不辣
		</p>
		<p>点餐日期: 
			   <input type="text" name="day_start" id="day_start"/>
			   <input type="text" name="day_end" id="day_end"/>
		</p>
		<p>一周中可点范围: 
			<input type="checkbox" name="day_week" value="2" />周一
			<input type="checkbox" name="day_week" value="3" />周二
			<input type="checkbox" name="day_week" value="4" />周三
			<input type="checkbox" name="day_week" value="5" />周四
			<input type="checkbox" name="day_week" value="6" />周五
			<input type="checkbox" name="day_week" value="7" />周六
			<input type="checkbox" name="day_week" value="1" />周日	
		</p>
		<input type="submit" value="提交" />
	</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>