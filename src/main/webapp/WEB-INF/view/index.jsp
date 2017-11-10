<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 20.09.2017
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/CSS/index.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <title>Main page</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="banner.jsp"/>

<div class="first">
    <div id="enter">
        <a href="registration">Registration</a>
        <p>or</p>
        <a href="login">Login</a>
    </div>
</div>

    <jsp:include page="footer.jsp"/>

</div>

</body>
</html>
