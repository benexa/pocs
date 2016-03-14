<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div>
	<sec:authorize access="isAuthenticated()">${labelWelcome}
		<a href="/Spring_ACL_Authentication/logout">Logout</a>
	</sec:authorize>
	
	<sec:authorize access="isAnonymous()">
		<a href="/Spring_ACL_Authentication/login">Login</a>
	</sec:authorize>
</div>