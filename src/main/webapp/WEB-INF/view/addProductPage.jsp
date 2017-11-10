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
    <%--<link href="/CSS/registration.css" rel="stylesheet" >--%>
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <link href="/CSS/addProductPage.css" rel="stylesheet" >
    <title>new product page</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<div class="first">
    <div class="registration">
        <%--@elvariable id="newUser" type="java"--%>
            <%--@elvariable id="newProdcut" type="java"--%>
            <form action="/admin/createNewProduct" method="post" enctype="multipart/form-data">
                <p>Enter product name
                    <input type="text" name="productName" pattern="[a-zA-Z0-9]+" required title="enter product name" placeholder="name"/>
                </p>
                <br>
                <p>Entet prodcut type
                    <input type="text" name="productType" pattern="[a-zA-Z0-9]+" required title="enter product type" placeholder="type"/>
                </p>
                <br>
                <p>Add prodcut photo
                    <input type="file" name="productPhoto"/>
                </p>
                <br>
                <p>Enter procut price
                    <input type="number" name="productPrice" pattern="[0-9]+" required title="enter product price" placeholder="price"/>
                </p>
                <br>
                <p>Add product description
                    <input type="text" name="productDescription" pattern="[a-zA-Z0-9]+" required title="enter product description" placeholder="description"/>
                </p>
                <br>
                <input type="submit" value="Create" id="button">

                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>

            </form>
    </div>
</div>


<jsp:include page="footer.jsp"/>



<div id="toUserPage">
<a href="/admin">Back</a>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
