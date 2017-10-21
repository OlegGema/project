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
    <title>Title</title>
</head>
<body>
hello ${user.username} you are administrator
<br>
you can add new prodcuts
<br>
<a href="/admin/addProduct">add product</a>
<br>
<a href="/admin/listOfUsers">list of users</a>
<br>
<a href="userPage">to user page</a>

</body>
</html>
