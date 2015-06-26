<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<%
	int changedCheck = 0;
	int check = 0;									// check = 2 면, 변경된거. check = 3이면, nick존재.
	int checkEmail = 0;
	
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String email = request.getParameter("email");

	System.out.println("memberUpdateNick..... id = "+id+", email="+email);
	
	MemberDAO dao = new MemberDAO();
	
	checkEmail = dao.EmailCount(email);
	
	if(checkEmail == 0){
		changedCheck = dao.UpdateEmail(id, email);
		check = 5;
	}else{
		check = 6;
	}
	
	System.out.println("changedCheck :: " + changedCheck + ", check ::: " + check);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+check+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>