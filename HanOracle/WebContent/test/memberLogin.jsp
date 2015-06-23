<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	int pwdCheck = 0;
	int idCount = 0;
	
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	System.out.println("id :::: " + id + "pwd :::::: " + pwd);
	
	MemberDAO dao = new MemberDAO();
	
	idCount = dao.IdCount(id);
	
	System.out.println("idCount :::::: " + idCount);
	
	if(idCount == 1){
		String dbpwd = dao.LoginSelect(id);
		
		if(dbpwd.equals(pwd)){
			pwdCheck = 1;	// 아이디, 비밀번호 일치
		}else{
			pwdCheck = 0;	// 아이디, 비밀번호 불일치
		}
	}else{
		pwdCheck = -1;		// 아이디가 존재하지 않음.
	}
	
	System.out.print(pwdCheck);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+pwdCheck+"</check>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>