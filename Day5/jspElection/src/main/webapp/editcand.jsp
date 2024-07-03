<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ec" class="com.sunbeam.Beans.EditCandBean"/>
	<jsp:setProperty property="candidateId" name="ec" param="id" />
	${ec.fetchCandidate()}
	<form method="post" action="updatecand.jsp">
		 <input type="hidden" name="id" value="${ec.candidate.id}" /> <br/>
		Name : <input type="text" name="name" value="${ec.candidate.name}" /><br/>
		Party : <input type="text" name="party" value="${ec.candidate.party}" /><br/>
		Votes : <input type="text" name="votes" value="${ec.candidate.votes}" readonly /><br/>
		<input type="submit" value="Update" />
	</form>
</body>
</html>