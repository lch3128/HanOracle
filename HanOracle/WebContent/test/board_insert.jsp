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
 
String subject = request.getParameter("b_subject");
String writer = request.getParameter("b_writer");
String content = request.getParameter("b_content");
String pnumber = request.getParameter("p_number");
String id = request.getParameter("b_id");

BoardDAO dao = new BoardDAO();

dao.insert(subject, writer, content, pnumber, id);  

response.sendRedirect("board_select.jsp");

%>
</body>
</html>