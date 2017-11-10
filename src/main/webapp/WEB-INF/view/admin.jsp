<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 01.10.2017
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/admin.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="first">
    <div class="adm">
        <a href="/admin/addProduct">Add product</a>
        <br>
        <a href="/admin/listOfUsers">List of users</a>
        <br>

    </div>
</div>

<div id="toUserPage">
    <a href="/userPage" >Back</a>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
