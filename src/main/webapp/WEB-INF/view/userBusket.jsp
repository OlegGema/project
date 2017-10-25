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
${busket}
${item}
<c:forEach items="${busket}" var="item">
    <div style="border: solid royalblue 2px";>
        <p>${item.product.productName}</p>
        <p>тип- ${item.product.productType}</p>
        <p>ціна- ${item.product.productPrice*item.quantity}</p>
        <p>кількість- ${item.quantity}</p>
        <img style="width: 100px;height: 150px" src="${item.product.productPhoto} " alt="">
        <br>
        <a href="/userPage/delete-${item.itemId}">delete</a>
    </div>
    <br>
</c:forEach>
<br>
<a href="/userPage">to user page</a>
</body>
</html>
