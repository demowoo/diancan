<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Constant" %>
<%
	//request.getRequestDispatcher("template.jsp").forward(request, response);
	//response.sendRedirect("login.html");
	if(session == null)
		response.sendRedirect("login.jsp");
	else{
		if(session.getAttribute(Constant.LOGININFO) == null){
			response.sendRedirect("login.jsp");
		}else
			response.sendRedirect("welcome.action");
	}
%>