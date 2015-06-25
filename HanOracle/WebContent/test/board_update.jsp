<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 
String bnumber = request.getParameter("b_number");
String subject = request.getParameter("b_subject");
String content = request.getParameter("b_content");
String pnumber = request.getParameter("p_number");

BoardDAO dao = new BoardDAO();

dao.update(bnumber, subject,content, pnumber);   

response.sendRedirect("board_select.jsp");

%>
</body>
</html>