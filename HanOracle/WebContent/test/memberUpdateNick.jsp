<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	int changedCheck = 0;
	int check = 0;									// check = 2 면, 변경된거. check = 3이면, nick존재.
	int checkNick = 0;
	
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String nick = request.getParameter("nick");
	
	System.out.println("memberUpdateNick..... id = "+id+", nick="+nick);
	
	MemberDAO dao = new MemberDAO();
	
	checkNick = dao.NickCount(nick);
	
	if(checkNick == 0){
		changedCheck = dao.UpdateNick(id, nick);
		check = 2;
	}else{
		check = 3;
	}
	
	System.out.println("changedCheck :: " + changedCheck + ", check ::: " + check);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+check+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>