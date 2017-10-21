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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>List of users</title>
</head>
<body>
    <c:forEach items="${allUsers}" var="user">
        <div style="border: solid burlywood 2px">(${user.id}) ${user.username}
            <img style="width: 100px;height: 120px " src="${user.avatar}"  alt="user dint have avatar">
            <p>${user.email}</p>
            <%--<form action="banUser-${user.id} ">--%>
                <p>статус користувача-  ${user.enabled}</p>
                змінити сататус - <select name="enabled">
                    <option value="true">true</option>
                    <option value="false">false</option>
                </select>
                <%--<input type="submit">--%>
                <button id="setEnabled-${user.id}">change</button>

            <%--</form>--%>


        </div>
        <br>
    </c:forEach>
<br>
    <a href="/admin">back to admin page</a>
    <script src="/javascript/main.js"></script>
</body>
</html>
