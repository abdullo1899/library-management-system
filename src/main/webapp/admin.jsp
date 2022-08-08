<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.2022
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<%@include file="includes/navbar.jsp" %>

<c:if test="${message != null}">
    <h1>${message}</h1>
</c:if>

<form action="add-book-form.jsp" method="post">
    <button class="btn btn-outline-dark btn-lg px-5" type="submit">Add a book</button> <br>
</form>

<form action="add-category-form.jsp" method="post">
    <button class="btn btn-outline-dark btn-lg px-5" type="submit">Add a category</button>
</form>

<form action="add-author-form.jsp" method="post">
    <button class="btn btn-outline-dark btn-lg px-5" type="submit">Add an author</button> <br>
</form>

<form action="add-user-form.jsp" method="post">
    <button class="btn btn-outline-dark btn-lg px-5" type="submit">Add user</button>
</form>

</body>
</html>
