<%@ page import = "member.MemberDAO" %>
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>

<%
	int checkID = 0;
	int checkNick = 0;
	int checkEmail = 0;
	int check = 0;
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String nick = request.getParameter("nick");
	String email = request.getParameter("email");
	
	MemberDAO dao = new MemberDAO();
	
	System.out.println("id :: " + id +", pwd :: " + pwd + ", name :: " + name + ", nick :: " + nick + ", email :: " + email);
	checkID = dao.IdCount(id);
	checkNick = dao.NickCount(nick);
	checkEmail = dao.EmailCount(email);
	
	if(checkID == 0 && checkNick == 0 && checkEmail == 0){
		dao.InsertMember(id, pwd, name, nick, email);
		check = 2;
	}
	
	StringBuffer buffer = new StringBuffer();
	buffer.append("<member>");
	buffer.append("<check>"+check+"</check>");
	buffer.append("<checkID>"+checkID+"</checkID>");
	buffer.append("<checkNick>"+checkNick+"</checkNick>");
	buffer.append("<checkEmail>"+checkEmail+"</checkEmail>");
	buffer.append("</member>");
%>
<%= buffer.toString()%>