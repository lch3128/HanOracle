<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import = "main.*"  %>
<%@page import="java.util.Date" %>
<%
Main_NoticeDAO dao = new Main_NoticeDAO();
ArrayList<Main_NoticeDTO> list = dao.select();

StringBuffer buffer = new StringBuffer();
buffer.append("<main_notice>");
for(int i = 0; i<5; i++){
	int n_number =  list.get(i).getN_number();
	String n_subject = list.get(i).getN_subject();
	Date n_regdate = list.get(i).getN_regdate();
	
	buffer.append("<data>");
	buffer.append("<n_number>"+n_number+"</n_number>");
	buffer.append("<n_subject>"+n_subject+"</n_subject>");
	buffer.append("<n_regdate>"+n_regdate+"</n_regdate>");
	buffer.append("</data>");
	
}
buffer.append("</main_notice>");
%>
<%=buffer.toString()  %>