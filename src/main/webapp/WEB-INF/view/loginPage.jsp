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
    <title>Login page</title>
</head>
<body>
    <form action="/login" method="post">
        <input type="text" name="username">
        <input type="text" name="password">
        <input type="submit">

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

</body>
</html>
