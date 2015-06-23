<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	int pwdCount = 0;
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberDAO dao = new MemberDAO();
	String s = dao.SearchPwd(id, name, email);
	
	if(!s.equals("")){
		pwdCount = 1;
	}
	
	System.out.println("pwdCount :::::" + pwdCount + ", id:::::::::" + id);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+pwdCount+"</check>");
	buffer.append("<id>"+id+"</id>");
	buffer.append("</member>");
%>
<%= buffer.toString()%>