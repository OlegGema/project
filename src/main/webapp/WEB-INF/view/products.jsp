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
    <title>List of products</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"/>

<%--<button id="b1">show</button>--%>
<%--<div id="showDiv">--%>
    <%--<img id="photo" src="">--%>
<%--</div>--%>

<c:forEach items="${products}" var="product">
    <div style="border: 2px red solid;margin: 10px;">
        <a href="product-${product.id}">${product.productName}</a>
        <p>тип- ${product.productType}</p>
        <p>ціна- ${product.productPrice}</p>
        <img style="width: 100px;height: 150px" src="${product.productPhoto} " alt="">

        <%--<button type="submit" name="add-${product.id} " >asd</button>--%>
        <a href="add-${product.id}">add</a>
        <security:authorize  access="hasRole('ROLE_ADMINISTRATOR')">
            <%--<a href="delProduct-${product.id}">delete product</a>--%>
            <button id="delProduct-${product.id}">delete</button>
        </security:authorize>
    </div>


    <br>

</c:forEach>
<br>
<a href="/userPage">to user page</a>

<script src="/javascript/main.js"></script>
</body>
</html>
