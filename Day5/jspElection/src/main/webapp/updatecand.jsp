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
	<jsp:useBean id="uc" class="com.sunbeam.Beans.UpdateCandidateBean"></jsp:useBean>
	<jsp:setProperty property="*" name="uc"/>
	${uc.saveCandidate()}
	<c:choose>
		<c:when test="${uc.count == 1}">
			<c:redirect url="result.jsp" />
		</c:when>
		<c:otherwise>
			Update Failed!!
			<a href="result.jsp">Results</a>
		</c:otherwise>
	</c:choose>
		
</body>
</html>