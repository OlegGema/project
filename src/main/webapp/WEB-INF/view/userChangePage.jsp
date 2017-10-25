<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 06.10.2017
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp"/>
    <title>Change</title>
</head>
<body>
    <form action="changeUserName-${user.id}" method="post" >
        <input type="text" name="username" placeholder="${user.username}">
        <input type="submit">
        ${massage}
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>




    <form action="changeEmail-${user.id}" method="post" >
        <input type="text" name="email" placeholder="${user.email}">
        <input type="submit">

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <form action="changeAvatar-${user.id}" method="post" enctype="multipart/form-data">
        <input type="file" name="avatar" placeholder="avatar">
        <input type="submit">

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <a href="userPage">to user page</a>

</body>
</html>
