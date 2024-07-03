<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:useBean id="nub" class="com.sunbeam.Beans.RegisterBean" />
	<jsp:setProperty name="nub" property="firstName" param="first_name" />
	<jsp:setProperty name="nub" property="lastName" param="last_name" />
	<jsp:setProperty name="nub" property="email" param="email" />
	<jsp:setProperty name="nub" property="password" param="password" />
	<jsp:setProperty name="nub" property="birth" param="dob" />
	<% int count = nub.register();%>
	<% if(count > 0){%>
		Registration Successful!<br/><br/>
		<a href="index.jsp">Login Here!</a>
		
	<%}else{ %>
	<%} %>
	</body>
</html>