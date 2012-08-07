<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/head.jsp" %>
<style type="text/css">

</style>
<script type="text/javascript">

</script>
<title>点餐页面</title>
<%@ include file="/WEB-INF/template/banner.jsp" %>
<c:if test="${status=='booked' }">
123
</c:if>
<c:if test="${status=='nostart' }">
<a href='createorder.htm'>新建</a>
</c:if>
<c:if test="${status=='open' }">
${dayorderlist }
<a href='createorder.htm'>新建</a>
</c:if>
<%@ include file="/WEB-INF/template/footer.jsp" %>