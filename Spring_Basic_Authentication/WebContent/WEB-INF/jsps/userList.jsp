<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:url var="logoutURL" value="j_spring_security_logout" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
	<a href="/Spring_Basic_Authentication/login" > Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<a href="/Spring_Basic_Authentication/logout" > Logout</a>
</sec:authorize>	


<br/>
	<c:forEach items="${userList}" var="user">
		${user.id} : ${user.name} <br/>
	</c:forEach>

</body>
</html>