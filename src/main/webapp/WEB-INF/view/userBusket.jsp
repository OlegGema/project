<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 09.10.2017
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Busket</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<c:forEach items="${busket}" var="product">
    <div style="border: solid royalblue 2px";>
        <p>${product.productName}</p>
        <p>тип- ${product.productType}</p>
        <p>ціна- ${product.productPrice}</p>
        <img style="width: 100px;height: 150px" src="${product.productPhoto} " alt="">
    </div>
    <br>
</c:forEach>
<br>
<a href="/userPage">to user page</a>
</body>
</html>
