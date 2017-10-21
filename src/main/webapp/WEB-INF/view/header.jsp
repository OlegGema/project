<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 05.10.2017
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="border: solid red 1px; background: yellow">
<p>HEADER</p>
    Hello <a href="<%--user-${user.id}--%>userChange">${user.username}</a>
<a style="float: right" href="/logout">logout</a>
    <img src="${user.avatar}" height="100px" width="100px">
</div>
<br>

<%--<c:if test="${user}">--%>
    <%--<a href="">registration</a>--%>
    <%--or--%>
    <%--<a href="/login">login</a>--%>
<%--</c:if>--%>

<br>
