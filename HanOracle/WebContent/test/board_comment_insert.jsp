<%@page import="board.Board_CommentDTO"%>
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

String c_number = request.getParameter("c_number");
String b_number = request.getParameter("b_number");
String c_writer = request.getParameter("c_writer");
String c_regdate = request.getParameter("c_regdate");
String c_content = request.getParameter("c_content");
String c_id = request.getParameter("c_id"); 
   
BoardDAO dao = new BoardDAO();  

dao.insert_comment(c_number, b_number, c_writer, c_content, c_id);  

response.sendRedirect("board_comment_select.jsp?bnum="+b_number);

%>
</body>
</html>