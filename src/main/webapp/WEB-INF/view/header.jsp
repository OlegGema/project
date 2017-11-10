<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 05.10.2017
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div>
<div class="header">

    <security:authorize  access="hasRole('ROLE_USER')">
    <div class="user">
        <p>Hello <a href="/userChange" class="a">${user.username}</a></p>
        <img src="${user.avatar}" height="100px" width="100px">
        <br>
        <a  href="/logout" class="a">logout</a>
    </div>
    </security:authorize>
    <security:authorize  access="hasRole('ROLE_ADMINISTRATOR')">
        <div class="admin">
        <p>Admin</p>
        <a  href="/logout" class="a">logout</a>
        </div>
    </security:authorize>
    <p id="shop">E-Shop</p>


</div>
<br>




