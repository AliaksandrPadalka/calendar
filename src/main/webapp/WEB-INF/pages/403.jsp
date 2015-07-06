<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Access denied</title>
        <meta charset="utf-8"/>

        <spring:url value="/resources/bootstrap/css/bootstrap.css" var="bootstrapCss" />
        <spring:url value="/resources/jquery/jquery.js" var="jqueryJs" />
        <spring:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrapJs" />

        <link href="${bootstrapCss}" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <%@ include file="header.jsp" %>
            </div>

            <div class="row">
                <h1>HTTP Status 403 - Access is denied</h1>
                <c:choose>
                    <c:when test="${empty username}">
                        <h2>You do not have permission to access this page!</h2>
                    </c:when>
                    <c:otherwise>
                        <h2>Username : ${username} <br/> You do not have permission to access this page!</h2>
                        </c:otherwise>
                    </c:choose>
            </div>

            <div class="row">
                <%@ include file="footer.jsp" %>
            </div>
        </div>
        <script type="text/javascript" src="${jqueryJs}" />
        <script type="text/javascript" src="${bootstrapJs}" />
    </body>
</html>