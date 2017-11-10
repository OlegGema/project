<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 22.09.2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/CSS/loginPage.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <title>Login page</title>
</head>
<body>


    <div class="wrapper">
        <jsp:include page="banner.jsp"/>
        <div class="first">
        <div class="login">
            <form action="/login" method="post">
                <p>Enter your name
                    <input type="text" name="username">
                </p>
                <br>
                <p>Enter your password
                    <input type="password" name="password">
                </p>
                <br>
                <input type="submit" value="Enter" id="button">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>
        </div>
        <jsp:include page="footer.jsp"/>



    </div>

</body>
</html>
