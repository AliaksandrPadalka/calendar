<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Login Page</title>

        <spring:url value="/resources/bootstrap/css/bootstrap.css" var="bootstrapCss" />
        <spring:url value="/resources/css/style.css" var="stylecss" />

        <link href="${bootstrapCss}" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="${stylecss}" type="text/css" />
    </head>

    <body onload="document.loginForm.username.focus();">

        <div class="container-fluid">
            <div class="row">
                <%@ include file="header.jsp" %>
            </div>
            <div class="row">
                <div class="panel col-md-3 panel-default text-center col-centered">
                    <c:if test="${not empty error}">
                        <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                        <div class="msg">${msg}</div>
                    </c:if>

                    <c:url var="loginUrl" value="/login" />
                    <form:form class="form-horizontal" action="${loginUrl}" method="POST" modelAttribute="user" name="loginForm">
                        <fieldset>
                            <legend>Login with Username and Password</legend>
                            <div class="form-group">
                                <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                                <div class="col-lg-10">
                                    <input type="text" class="form-control" id="inputEmail" placeholder="Email" name="username" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-lg-2 control-label">Password</label>
                                <div class="col-lg-10">
                                    <input type="password" class="form-control" id="inputPassword" placeholder="Password" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="reset" class="btn btn-default">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>
                        </fieldset>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form:form>
                </div>
            </div>
            <div class="row">
                <%@ include file="footer.jsp" %>
            </div>
        </div>

    </body>
</html>