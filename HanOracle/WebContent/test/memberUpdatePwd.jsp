<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	int changedCheck = 0;
	int check = 0;
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("pwd");
	
	System.out.println("memberUpdatePwd..... id = "+id+", pwd="+pass);
	
	MemberDAO dao = new MemberDAO();
	changedCheck = dao.UpdatePwd(id, pass);
	
	if(changedCheck == 1){
		check = 1;
	}
	
	System.out.println("changedCheck" + changedCheck);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+check+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>