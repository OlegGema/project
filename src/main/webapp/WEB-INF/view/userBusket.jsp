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
    <link href="/CSS/banner.css" rel="stylesheet" >
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/products.css" rel="stylesheet" >
    <title>Busket</title>
</head>
<body>
<div class="wrapper">
<jsp:include page="header.jsp"/>

<%--${item}--%>
<c:forEach items="${busket}" var="item">
    <div class="product">
        <p>${item.product.productName}</p>
        <p>тип- ${item.product.productType}</p>
        <p>ціна- ${item.product.productPrice*item.quantity}</p>
        <p>кількість- ${item.quantity}</p>
        <img style="width: 100px;height: 150px" src="${item.product.productPhoto} " alt="">
        <br>
        <div id="delete">
        <a href="/userPage/delete-${item.itemId}">delete</a>
        </div>
        </div>
</c:forEach>

<div id="toUserPage">
    <a href="/userPage">to user page</a>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
