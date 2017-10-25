<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 03.10.2017
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product page</title>
</head>
<body>

<form action="/admin/changeProdName-${product.id}" method="post" >
    <input type="text" name="productName" placeholder="${product.productName}">
    <input type="submit">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<form action="/admin/changeProdType-${product.id}" method="post" >
    <input type="text" name="productType" placeholder="${product.productType}">
    <input type="submit">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<form action="/admin/changeProdPrice-${product.id}" method="post" >
    <input type="number" name="productPrice" placeholder="${product.productPrice}">
    <input type="submit">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<form action="/admin/changeProdPhoto-${product.id}" method="post" enctype="multipart/form-data">
    <input type="file" name="productPhoto" >
    <input type="submit">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
<br>
<a href="/userPage/products">to product list</a>
<img src="${product.productPhoto}">
</body>
</html>
