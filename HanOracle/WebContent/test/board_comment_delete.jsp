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
 
String cnum2 = request.getParameter("cnum");
String bnum2 = request.getParameter("bnum");

BoardDAO dao = new BoardDAO();
dao.delete_comment_one(cnum2);

response.sendRedirect("board_comment_select.jsp?bnum="+bnum2);

%>
</body>
</html>