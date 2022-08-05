<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.08.2022
  Time: 5:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>

<form action="/issue-book" method="post">
<button class="btn btn-outline-dark btn-lg px-5" type="submit">Issue a book</button> <br>
</form>

<form action="/return-book" method="post">
<button class="btn btn-outline-dark btn-lg px-5" type="submit">Return a book</button>
</form>
</body>
</html>
