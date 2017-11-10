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
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <link href="/CSS/userChangePage.css" rel="stylesheet" >
    <title>Product page</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="first">
    <div class="change">

        <p>Enter new product name</p>
<form action="/admin/changeProdName-${product.id}" method="post" >
    <input type="text" name="productName" placeholder="${product.productName}">
    <input type="submit" value="change" class="button">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
        <p>Enter new product type</p>
<form action="/admin/changeProdType-${product.id}" method="post" >
    <input type="text" name="productType" placeholder="${product.productType}">
    <input type="submit" value="change" class="button">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
        <p>Enter new product price</p>
<form action="/admin/changeProdPrice-${product.id}" method="post" >
    <input type="number" name="productPrice" placeholder="${product.productPrice}">
    <input type="submit" value="change" class="button">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>
        <p>Add new product photo</p>
<form action="/admin/changeProdPhoto-${product.id}" method="post" enctype="multipart/form-data">
    <input type="file" name="productPhoto" >
    <input type="submit" value="change" class="button">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

</div>
</div>

<div id="toUserPage">
    <a href="/userPage/products" >Back</a>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
