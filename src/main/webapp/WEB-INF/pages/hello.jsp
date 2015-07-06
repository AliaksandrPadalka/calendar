<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <title>Welcome</title>
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
                <h1>Message : ${message}</h1>
                <h4>Users :</h4>
                <c:if test="${not empty users}">
                    <table class="table table-bordered">
                        <tr>
                            <td>user id</td>
                            <td>user name</td>
                            <td>user phone</td>
                            <td>user role</td>
                        </tr>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.name}</td>
                                <td>
                                    <c:if test="${not empty user.phones}">
                                        <ul>
                                            <c:forEach var="phone" items="${user.phones}">
                                                <li>
                                                    ${phone}
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </td>
                                <td>${user.role}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <h4>Operations :</h4>
                <c:if test="${not empty operations}">
                    <table class="table table-bordered">
                        <tr>
                            <td>operation id</td>
                            <td>operation name</td>
                            <td>operation description</td>
                            <td>operation duration</td>
                        </tr>
                        <c:forEach var="operation" items="${operations}">
                            <tr>
                                <td>${operation.id}</td>
                                <td>${operation.name}</td>
                                <td>${operation.description}</td>
                                <td>${operation.duration}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </div>

            <div class="row">
                <%@ include file="footer.jsp" %>
            </div>
        </div>

        <script type="text/javascript" src="${jqueryJs}" />
        <script type="text/javascript" src="${bootstrapJs}" />
    </body>
</html>
