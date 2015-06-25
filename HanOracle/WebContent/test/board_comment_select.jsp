<%@page import="board.Board_CommentDTO"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.*"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Board_CommentDTO> clist = null;
	ArrayList<BoardDTO> list = null;
	BoardDAO dao = new BoardDAO();
	StringBuffer buffer = null;
	
	String bnum2 = request.getParameter("bnum");
	int a = dao.count_comment(bnum2); 
	
	if(a!=0){
	clist = dao.select_comment(bnum2);

		buffer = new StringBuffer();
		buffer.append("<board>");
		for (Board_CommentDTO dto : clist) {
			int c_number = dto.getC_number();
			int b_number = dto.getB_number();
			String c_writer = dto.getC_writer();
			Date c_regdate = dto.getC_regdate();
			String c_content = dto.getC_content();
			String c_id = dto.getC_id();

			buffer.append("<record>");
			buffer.append("<c_number>" + c_number + "</c_number>");
			buffer.append("<b_number>" + b_number + "</b_number>");
			buffer.append("<c_writer>" + c_writer + "</c_writer>");
			buffer.append("<c_regdate>" + c_regdate + "</c_regdate>");
			buffer.append("<c_content>" + c_content + "</c_content>");
			buffer.append("<c_id>" + c_id + "</c_id>");
			buffer.append("</record>");
		}
		buffer.append("</board>");
} else {
}
%>
<%=buffer.toString()%>
