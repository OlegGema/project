<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 02.10.2017
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new product page</title>
</head>
<body>
Creating product

<%--@elvariable id="newProduct" type="java"--%>
<%--<sf:form action="createNewProduct" modelAttribute="newProduct" method="post" enctype="multipart/form-data">--%>
    <%--<p>enter product name--%>
        <%--<sf:input path="productName"/>--%>
        <%--<sf:errors path="productName"/>--%>
    <%--</p>--%>

    <%--<p>enter product type--%>
        <%--<sf:input path="productType"/>--%>
        <%--<sf:errors path="productType"/>--%>
    <%--</p>--%>

    <%--<p>enter product photo--%>
        <%--<input type="file" name="productPhoto">--%>
    <%--</p>--%>

    <%--<p>enter product price--%>
        <%--<sf:input path="productPrice"/>--%>
        <%--<sf:errors path="productPrice"/>--%>
    <%--</p>--%>

    <%--<p>enter product description--%>
        <%--<sf:input path="productDescription"/>--%>
        <%--<sf:errors path="productDescription"/>--%>
    <%--</p>--%>
    <%--<input type="submit">--%>

    <%--<input type="hidden"--%>
           <%--name="${_csrf.parameterName}"--%>
           <%--value="${_csrf.token}"/>--%>
<%--</sf:form>--%>

<%--@elvariable id="newProdcut" type="java"--%>
<form action="/admin/createNewProduct" method="post" enctype="multipart/form-data">
    <p>enter prodcut name
        <input type="text" name="productName" pattern="[a-zA-Z0-9]+" required title="enter product name" placeholder="name"/>
    </p>

    <p>entet prodcut type
        <input type="text" name="productType" pattern="[a-zA-Z0-9]+" required title="enter product type" placeholder="type"/>
    </p>

    <p>add prodcut photo
        <input type="file" name="productPhoto"/>
    </p>

    <p>enter procut price
        <input type="number" name="productPrice" pattern="[0-9]+" required title="enter product price" placeholder="price"/>
    </p>

    <p>add product description
        <input type="text" name="productDescription" pattern="[a-zA-Z0-9]+" required title="enter product description" placeholder="description"/>
    </p>
    <input type="submit">

    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>
<br>
<a href="/admin">back to admin page</a>
</body>
</html>
