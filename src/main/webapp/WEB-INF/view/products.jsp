<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 03.10.2017
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/CSS/banner.css" rel="stylesheet" >
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/products.css" rel="stylesheet" >
    <title>List of products</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>

<div class="wrapper">
<jsp:include page="header.jsp"/>




<c:forEach items="${products}" var="product">
    <div class="product">
        <security:authorize  access="hasRole('ROLE_ADMINISTRATOR')">
            <a href="/admin/products/product-${product.id}">${product.productName}</a>
        </security:authorize>
        <security:authorize  access="hasRole('ROLE_USER')">
            <p>${product.productName}</p>
        </security:authorize>
        <p>type- ${product.productType}</p>
        <p>price- ${product.productPrice}</p>
        <img style="width: 100px;height: 150px" src="${product.productPhoto} " alt="">
        <br>
        <security:authorize  access="hasRole('ROLE_USER')">
        <form action="/userPage/add-${product.id}" method="post">

            <p>quantity-<input type="number" name="quantity" id="quantity" value="1"/></p>
            <input type="submit" class="button" value="add">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
        </security:authorize>

        <security:authorize  access="hasRole('ROLE_ADMINISTRATOR')">
            <div id="delete">
            <a href="/admin/products/delete-${product.id}">del</a>
            </div>
        </security:authorize>
    </div>
</c:forEach>


<br>

<div id="toUserPage">
    <a href="/userPage" >to user page</a>
</div>

<jsp:include page="footer.jsp"/>
</div>
<script src="/javascript/main.js"></script>
</body>
</html>
