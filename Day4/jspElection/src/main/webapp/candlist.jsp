<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="cb" class="com.sunbeam.Beans.CandidateListBean"/>
	<h2>Candidate List</h2>
	<% List<Candidate> list = cb.getCandidateList(); %>
	<% for(Candidate c:list){
		out.println("<input type='radio' name='name' value="+ c.getId() + " />"+ c.getName() +" ( "+ c.getParty()+ ")<br/>");
	}%>
	<input type="submit" value="Vote">
</body>
</html>