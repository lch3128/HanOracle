<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
	int changedCheck = 0;
	int check = 0;								// check = 7  회원탈퇴
	
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");

	System.out.println("memberDelete....... id = "+id);
	
	MemberDAO dao = new MemberDAO();
	changedCheck = dao.DeleteMember(id);
	
	if(changedCheck == 1){
		check = 7;
	}
	
	System.out.println("changedCheck" + changedCheck);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+check+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>