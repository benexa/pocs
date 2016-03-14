<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="common_menu.jsp" %>
	Username:${user.username}<br/>
	Password:${user.password}<br/>
	<c:forEach items="${userRoles}" var="rol">
		<%-- Role:${rol.role}<br/> --%>
		Role Description: ${rol.description }<br/>
	</c:forEach>
</body>
</html>