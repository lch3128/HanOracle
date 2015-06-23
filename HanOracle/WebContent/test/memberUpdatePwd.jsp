<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	int changedCheck = 0;
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	
	MemberDAO dao = new MemberDAO();
	changedCheck = dao.UpdatePwd(id, pass);
	
	System.out.print(changedCheck);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+changedCheck+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>