<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	int idCount = 0;
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	System.out.println("name ::: " + name + ", email :::: " + email);
	
	MemberDAO dao = new MemberDAO();
	String id = dao.SearchId(name, email);
	
	if(!id.equals("")){
		idCount = 1;
	}
	
	System.out.println("idCount:::::::"+idCount + ", id ::::::" + id);
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+idCount+"</check>");
	buffer.append("<id>"+id+"</id>");
	buffer.append("</member>");
%>

<%= buffer.toString()%>