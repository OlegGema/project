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
    <link href="/CSS/registration.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <title>Registration</title>
</head>
<body>

    <div class="wrapper">
        <jsp:include page="banner.jsp"/>
<div class="first">
        <div class="registration">
        <%--@elvariable id="newUser" type="java"--%>
        <sf:form action="registration" modelAttribute="newUser" method="post">
            <p>Enter your name
                <br>
                <sf:input path="username"/>
                <br>
                <div class="error"><sf:errors path="username"/></div>

            </p>
            <p>Enter your password
                <br>
                <sf:input path="password"/>
                <br>
            <div class="error"><sf:errors path="password"/></div>
            </p>

            <p>Enter your email
                <br>
                <sf:input path="email"/>
                <br>
               <div class="error"> <sf:errors path="email"/></div>
            </p>
            <br>

            <input type="submit" value="Enter" id="button">

            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </sf:form>
        </div>
</div>


        <jsp:include page="footer.jsp"/>

    </div>




</body>
</html>
