
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 22.09.2017
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <input type="text" name="username" required title="enter product price">
                </p>

                <br>
                <p>Enter your password
                    <input type="password" name="password" required title="enter product price">
                </p>
                <br>
                <input type="submit" value="Enter" id="button">

                <c:if test="${param.error=='true'}">
                    <br>
                    <div style="color: royalblue ;font-style: italic;font-size: 16px" >
                        wrong username or password
                    </div>
                </c:if>
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
