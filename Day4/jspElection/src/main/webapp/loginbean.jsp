<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="loginb" class="com.sunbeam.Beans.loginBean"/>
	<jsp:setProperty name="loginb" property="email" param="email"/>
	<jsp:setProperty name="loginb" property="password" param="pass"/>
	<% int count = loginb.authenticate();
		if(count == 0) {%>
			 <jsp:forward page="candlist.jsp"/>
		<% } else{ %>
		Login Failed
		<%} %>
</body>
</html>