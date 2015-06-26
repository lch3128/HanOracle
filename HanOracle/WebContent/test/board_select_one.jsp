<%@page import="board.BoardDTO"%>
<%@page import="java.util.*"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String bnum = request.getParameter("bnum");

	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.select_one(bnum);	 

	StringBuffer buffer = new StringBuffer();
	buffer.append("<board>");
	for(BoardDTO dto : list) {
		int b_number = dto.getB_number();
		String b_subject = dto.getB_subject();
    	String b_writer = dto.getB_writer();
    	Date b_regdate = dto.getB_regdate();
    	String b_content = dto.getB_content();
    	int b_count = dto.getB_count();
    	int p_number = dto.getP_number();
    	String b_id = dto.getB_id();
		
		buffer.append("<record>");
		buffer.append("<b_number>"+b_number+"</b_number>");
		buffer.append("<b_subject>"+b_subject+"</b_subject>");
		buffer.append("<b_writer>"+b_writer+"</b_writer>");
		buffer.append("<b_regdate>"+b_regdate+"</b_regdate>");
		buffer.append("<b_content>"+b_content+"</b_content>");
		buffer.append("<b_count>"+b_count+"</b_count>");
		buffer.append("<p_number>"+p_number+"</p_number>");
		buffer.append("<b_id>"+b_id+"</b_id>");
		buffer.append("</record>");
	}
	buffer.append("</board>");
%>
<%= buffer.toString()%>