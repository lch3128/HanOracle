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
 
String bNum2 = request.getParameter("bNum");
String parkNum2 = request.getParameter("parkNum");
BoardDAO dao = new BoardDAO();
dao.delete_comment(bNum2);
dao.delete(bNum2); 

response.sendRedirect("board_select_park.jsp?parkNum="+parkNum2);

%>
</body>
</html>