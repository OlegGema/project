<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 27.09.2017
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/CSS/userPage.css" rel="stylesheet" >
    <link href="/CSS/banner.css" rel="stylesheet" >
    <title>User page</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<br>


    <div class="pages">
        <security:authorize  access="hasRole('ROLE_ADMINISTRATOR')">
            <a href="admin">admin page</a>
        </security:authorize>

         <br>

        <a href="/userPage/products">List of products</a>
         <br>
        <security:authorize  access="hasRole('ROLE_USER')">
             <a href="/userPage/userBusket-${user.id}">Busket</a>
        </security:authorize>

    </div>



<jsp:include page="footer.jsp"/>

</div>


</form>


</body>
</html>
