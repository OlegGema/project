<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 17.10.2017
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/CSS/banner.css" rel="stylesheet" >
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/products.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>List of users</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp"/>

    <c:forEach items="${allUsers}" var="user">
        <div class="product">
        <div>(${user.id}) ${user.username}

            <img style="width: 100px;height: 120px " src="${user.avatar}"  alt="user dint have avatar">
            <p>${user.email}</p>
            <form action="/admin/listOfUsers/banUser-${user.id}"method="post">
                <p>статус користувача-  ${user.enabled}</p>
                змінити сататус - <select name="enabled">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
                <input type="submit" class="button" value="Change">
                <%--<button id="setEnable" atribute="${user.id}">change</button>--%>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>


        </div>
        </div>
    </c:forEach>

    <%--<c:forEach items="${allUsers}" var="user">--%>
        <%--<div style="border: solid burlywood 2px">(${user.id}) ${user.username}--%>
            <%--<img style="width: 100px;height: 120px " src="${user.avatar}"  alt="user dint have avatar">--%>
            <%--<p>${user.email}</p>--%>
                <%--<p>статус користувача-  ${user.enabled}</p>--%>
                <%--змінити сататус - <button id="ban" atribute="${user.id}">Ban user</button> <button id="unban" atribute="${user.id}">unban</button>--%>
            <%--<input type="submit">--%>
                <%--&lt;%&ndash;<button id="setEnable" atribute="${user.id}">change</button>&ndash;%&gt;--%>




        <%--</div>--%>
        <%--<br>--%>
    <%--</c:forEach>--%>

    <div id="toUserPage">
        <a href="/admin">Back</a>
    </div>
    <script src="/javascript/main.js"></script>

<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
