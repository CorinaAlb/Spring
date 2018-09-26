<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Spring Mvc WebFlow Demo</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="content">
    <fieldset>
        <sf:form modelAttribute="userBean"><br />
            <sf:label path="username">UserName:</sf:label>
            <sf:input path="username" /><br />
            <!-- to display validation messages -->
            <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('username')}" var="err">
                <div><span>${err.text}</span></div>
            </c:forEach><br />
            <sf:label path="password">Password:</sf:label>
            <sf:input path="password" /><br />
            <!-- to display validation messages -->
            <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
                <div><span>${err.text}</span></div>
            </c:forEach><br />

            <input name="_eventId_submit" type="submit" value="Submit" /><br />
        </sf:form>
    </fieldset>
</div>
</body>
</html>
