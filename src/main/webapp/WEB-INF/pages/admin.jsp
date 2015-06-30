<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <script type="text/javascript" src="../js/js.js" />
    </head>

    <body
        <%@ include file="header.jsp" %>

        <h1> Title : ${title} </h1>
        <h1> Message : ${message} </h1>

        <c:url value="/j_spring_security_logout" var="logoutUrl" />

        <form action = "${logoutUrl}" method = "post" id = "logoutForm" >
            <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}" />
        </form>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2> Welcome : ${pageContext.request.userPrincipal.name} | <a href = "javascript:formSubmit()" > Logout </a></h2>
        </c:if>

        <%@ include file="footer.jsp" %>
    </body>
</html>