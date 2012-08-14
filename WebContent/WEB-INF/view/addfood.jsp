<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">
#addfood_form{
	position: relative;
	border: 1px;
	padding: 15px 5px 5px 5px;
}
div.itemWrapper{
	position: relative;
	padding-left: 320px;
	padding-bottom: 10px;
}
form label{
 	position: absolute;
	text-align: right;
	left: 0;
	width: 310px;
	display: block;
	font-size: 14px;
	padding: 4px 5px;
}
input.input-text{
	display: block;
	left: 0;
	width: 200px;
	background-color: #FBFBFB;
    background-position: 0 -72px;
    border: 1px solid #C1C1C1;
    color: #444444;
    font-size: 14px;
    padding: 4px 5px;
}
input.button{
	position: absolute;
	left: 390px;
}
</style>
<script type="text/javascript">
</script>
<title>添加食物</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
	<form id="addfood_form" action="addfood.action" method="post" onsubmit="return validate()">
		<div class="itemWrapper"><label>
		餐馆名称:
		</label>
		<select name="restId" class="input-text">
			<c:forEach var="rest" items="${restlist}" >
				<option value="${rest.id}">${rest.name}</option>
			</c:forEach>
		</select>
		</div>
		
		<div class="itemWrapper"><label>
		菜名:
		</label> 
		<input type="text" class="input-text" name="name" id="name"/></div>
		
		<div class="itemWrapper"><label>
		价格: 
		</label>
		<input type="text" class="input-text" name="pri" id="pri"/></div>
		
		<div class="itemWrapper"><label>
		辣: 
		</label>
			<input type="radio" name="hot" value="1" /> 辣
			<input type="radio" name="hot" value="0" checked="checked"/> 不辣
		</div>
		
		<div class="itemWrapper"><label>
		可点日期范围:
		</label> 
			   <input type="text" class="input-text" name="day_start" id="day_start"/>
			   <input type="text" class="input-text" name="day_end" id="day_end"/>
		</div>
		<div class="itemWrapper"><label>
		一周中可点天数:
		</label> 
			<input type="checkbox" name="day_week" value="2" />周一
			<input type="checkbox" name="day_week" value="3" />周二
			<input type="checkbox" name="day_week" value="4" />周三
			<input type="checkbox" name="day_week" value="5" />周四
			<input type="checkbox" name="day_week" value="6" />周五
			<input type="checkbox" name="day_week" value="7" />周六
			<input type="checkbox" name="day_week" value="1" />周日	
		</div>
		<input type="submit" value="提交" class="button"/>
	</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>