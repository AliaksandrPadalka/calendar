<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<spring:url value="/resources/img/brand.jpg" var="brandimg" />
<spring:url value="/" var="mainurl" />
<spring:url value="/resources/css/style.css" var="stylecss" />

<link rel="stylesheet" href="${stylecss}" type="text/css" />

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${mainurl}">
                <img alt="Main" src="${brandimg}" class="brandimg"/>
            </a>
            <a class="navbar-brand" href="#">News</a>
            <a class="navbar-brand" href="#">Contacts</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search" />
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <a href="${mainurl}login" class="btn btn-info btn-md glyphicon glyphicon-user" role="button"> Sign up</a>
                    or
                    <a href="${mainurl}login" class="btn btn-info btn-md glyphicon glyphicon-log-in" role="button"> Register</a>
                </div>
            </form>
        </div>
    </div>
</nav>