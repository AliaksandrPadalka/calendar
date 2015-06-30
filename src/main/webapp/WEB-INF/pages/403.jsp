<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>403 Error</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <h1>HTTP Status 403 - Access is denied</h1>

        <c:choose>
            <c:when test="${empty username}">
                <h2>You do not have permission to access this page!</h2>
            </c:when>
            <c:otherwise>
                <h2>Username : ${username} <br/> You do not have permission to access this page!</h2>
                </c:otherwise>
            </c:choose>

        <%@ include file="footer.jsp" %>
    </body>
</html>