<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">
#restlist{
	text-align: center;
	border-bottom: 1px solid #000;
	padding: 5px 10px 10px 10px;
	margin: 10px 0;
}
a.restname{
	text-decoration: none;
	margin: 3px 5px;
	padding: 3px 5px;
}
.nochoosed{
	background-color: #F1F1F1;
	color: #000;
}
.choosed{
	background-color: #6EB6D5;
	color: #fff;
}
a.restname:hover {
	background-color: #6EB6D5;
	color: #fff;
}
table{
	position:relative;
	margin: 10px;
	text-align: center;
	width: 700px;
}
table tr td{
	padding: 3px 5px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".restname").click(function(){
		$(".restname").removeClass("choosed");
		$(this).addClass("choosed");
		var restId = $(this).attr("idvalue");
		$.get("getfoodlist.do",{restId:restId},function(foodList){
			var table = "<table><tr><th>菜名</th><th>人气</th><th>辣否</th><th>单价</th><th>可定日期</th><th>每月可定范围</th><th>可定星期</th></tr>";
			for(var i in foodList){
				var dayStart = null;
				var dayEnd = null;
				var dayRangeStart = null;
				var dayRangeEnd = null;
				
				if(foodList[i].order_day_start == "")
					dayStart = "-";
				else{
					dayStart = new Date(foodList[i].order_day_start).toLocaleDateString();
					
				}
				
				if(foodList[i].order_day_end == "")
					dayEnd = "-";
				else
					dayEnd = new Date(foodList[i].order_day_end).toLocaleDateString();
				
				var dateRange = dayStart + "-" + dayEnd;
				////////////////////////////////////////
				if(foodList[i].order_range_start == "0")
					dayRangeStart = "-";
				else
					dayRangeStart = "每月" + foodList[i].order_range_start + "日-";
				
				if(foodList[i].order_range_end == "0")
					dayRangeEnd = "-";
				else
					dayRangeEnd = foodList[i].order_range_end + "日";
				
				var dayRange =  dayRangeStart  + dayRangeEnd;
				///////////////////////////////////////
				var dayWeek = foodList[i].order_day_week;
				if(dayWeek =="")
					dayWeek = "-";
				
				var hot = "--";
				if(foodList[i].hot == 1)
					hot = "辣";
				new Date(foodList[i].order_day_start);
				table += "<tr><td>";
				table += foodList[i].name;
				table += "</td>";
				table += "<td>";
				table += foodList[i].book_count;
				table += "</td>";
				table += "<td>";
				table += hot;
				table += "</td>";
				table += "<td>";
				table += foodList[i].price;
				table += "</td>";
				table += "<td>";
				table += dateRange;
				table += "</td>";
				table += "<td>";
				table += dayRange;
				table += "</td>";
				table += "<td>";
				table += dayWeek;
				table += "</td></tr>";
			}
			table += "</table>";
			$("#foodlist").html(table);
		},
		"JSON");
	});
});
</script>
<title>浏览菜单</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<div id="restlist">
<c:forEach  var="rest" items="${restList}">
	<a href="javascript:void(0)" class="restname nochoosed" idvalue="${rest.id }">${rest.name }</a>
</c:forEach>
</div>

<div id="foodlist">
</div>
<%@ include file="/WEB-INF/template/footer.jsp" %>