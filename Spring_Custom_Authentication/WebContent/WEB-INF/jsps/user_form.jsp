<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:form modelAttribute="user" action="/Spring_Custom_Authentication/user/create">
		<s:label path="username">Name</s:label><s:input path="username"/><br/>
		<s:label path="password">Password</s:label><s:input path="password"/><br/>
		<%-- <s:select path="listOfRoles" items="${roleList}" itemValue="id" itemLabel="role"/> --%>
		
		<s:select path="listOfRoles">
			<c:forEach items="${roleList}" var="role" varStatus="vs">
				<s:option path="${role.id}" value="${role.id}" label="${role.role }"/>
			</c:forEach>			
		</s:select>
		<input type="submit" value="Submit"/>
	</s:form>	
</body>
</html>