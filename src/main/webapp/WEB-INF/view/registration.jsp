<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 20.09.2017
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<html>
<head>
    <title>Title</title>
</head>
<body>



    <%--@elvariable id="newUser" type="java"--%>
    <sf:form action="registration" modelAttribute="newUser" method="post">
    <p>enter your name
    <sf:input path="username"/>
    <sf:errors path="username"/>

    </p>
    <p>enter your password
    <sf:input path="password"/>
    <sf:errors path="password"/>
    </p>

    <p>enter your email
    <sf:input path="email"/>
    <sf:errors path="email"/>
    </p>


    <input type="submit">

    <input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/>
    </sf:form>





</body>
</html>
