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
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <link href="/CSS/userChangePage.css" rel="stylesheet" >
    <title>Change</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="first">
<div class="change">
    <p>Enter new username</p>
    <form action="changeUserName-${user.id}" method="post" >
        <input type="text" name="username" placeholder="${user.username}">
        <br>
        <input type="submit" class="button" value="change">
        ${massage}
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>



    <p>Enter new email</p>
    <form action="changeEmail-${user.id}" method="post" >
        <input type="text" name="email" placeholder="${user.email}">
        <br>
        <input type="submit" class="button" value="change">

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>

    <p>Chose new avatar</p>
    <form action="changeAvatar-${user.id}" method="post" enctype="multipart/form-data">
        <input type="file" name="avatar" placeholder="avatar">
        <br>
        <input type="submit" class="button" value="change">

        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>
</div>

<div id="toUserPage">
    <a href="userPage" >Back</a>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
