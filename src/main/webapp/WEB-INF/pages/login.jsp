<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" href="./css/style.css" />
    </head>

    <body onload='document.loginForm.username.focus();'>

        <h1>Spring Security Custom Login Form (XML)</h1>

        <div id="login-box">

            <h2>Login with Username and Password</h2>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div class="msg">${msg}</div>
            </c:if>

            <form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>

                <table>
                    <tr>
                        <td>User:</td>
                        <td><input type='text' name='username' value='' ></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type='password' name='password' /></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit"
                                               value="submit" /></td>
                    </tr>
                </table>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

            </form>
        </div>

    </body>
</html>