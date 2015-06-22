<%@page import="facility.FacilityDTO"%>
<%@page import="java.util.*"%>
<%@page import="facility.FacilityDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String p_num = request.getParameter("p_number");
	String f_num = request.getParameter("f_number");

	FacilityDAO dao = new FacilityDAO();
	ArrayList<FacilityDTO> list = dao.select(Integer.parseInt(p_num),Integer.parseInt(f_num));	

	StringBuffer buffer = new StringBuffer();
	buffer.append("<board>");
	for(FacilityDTO dto : list) {
		int p_number = dto.getP_number();
		int f_number = dto.getF_number();
    	double lon = dto.getLon();
    	double lat = dto.getLat();
		
		buffer.append("<record>");
		buffer.append("<p_number>"+p_number+"</p_number>");
		buffer.append("<f_number>"+f_number+"</f_number>");
		buffer.append("<lon>"+lon+"</lon>");
		buffer.append("<lat>"+lat+"</lat>");
		buffer.append("</record>");
	}
	buffer.append("</board>");
%>
<%= buffer.toString()%>