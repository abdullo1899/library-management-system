<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.08.2022
  Time: 5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<%@include file="includes/admin-navbar.jsp" %>


<section>
<table class="table">
    <tr><th>Id</th><th>Full Name</th><th>Username</th><th>Edit/Delete</th>

    <c:forEach items="${list}" var="user">
        <tr><td>${user.getId()}</td><td>${user.getFullname()}</td>
    <td>${user.getUsername()}</td><td><a href="/edit-user?id=${user.getId()}">Edit|</a> <a href="/delete-user?id=${user.getId()}">Delete</a></td></tr>
    </c:forEach>
</table>

    <h3><a href="/students?page=1">1</a></h3> <h3><a href="/students?page=2">2</a></h3><h3><a href="/students?page=3">3</a></h3>

</section>

</body>
</html>
