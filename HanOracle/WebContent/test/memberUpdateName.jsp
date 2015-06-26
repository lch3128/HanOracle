<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	int changedCheck = 0;
	int check = 0;									// check = 4이면 변경된거.
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");

	System.out.println("memberUpdatePwd..... id = "+id+", name="+name);
	
	MemberDAO dao = new MemberDAO();
	changedCheck = dao.UpdateName(id, name);
	
	if(changedCheck == 1){
		check = 4;
	}
	
	System.out.println("changedCheck :: " + changedCheck + ", check ::: " + check);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+check+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>