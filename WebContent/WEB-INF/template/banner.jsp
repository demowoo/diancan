<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</head>
<body>
<div id="banner" class="frame ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header">
	<span id="navigation">
		<a href="${ctx}/welcome.action">点餐</a>|
		<a href="${ctx}/viewmenu.action">浏览菜单</a>|
		<a href="${ctx}/addrest.htm">添加餐馆</a>|
		<a href="${ctx}/addfood.htm">添加菜单</a>|
		<a href="">我的信息</a>
	</span>
	<span id="userinfo">
		<span>你好：${logininfo.loginname }</span>|
		<a href="${ctx}/logout.action">退出</a>
	</span>
</div>
<div id="main" class="frame">