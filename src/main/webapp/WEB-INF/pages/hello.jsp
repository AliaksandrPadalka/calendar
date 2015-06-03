<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.4/css/bootstrap.min.css" />
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/1.11.1/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/angularjs/1.3.15/angular.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Message : ${message}</h1>
        <hr/>
    </body>
</html>
