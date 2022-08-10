<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>EDIT BOOK</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<h1>EDIT BOOK</h1>
<br>

<form action="/edit-user" method="post">

    <c:forEach items="${userlist}" var="user">
        <c:if test="${id == user.getId()}">

            Id:<input type="number" name="id" value="${user.getId()}" >

            <br>


    Fullname:<input type="text" name="fullname" value="${user.getFullname()}">

    <br>
    Username:<input  name="username" value="${user.getUsername()}">

    <br>

    <br>
   Password:<input type="password" name="password" value="${user.getPassword()}">


            <input type="submit" value="Saqlash">

        </c:if>
    </c:forEach>





</form>
</body>
</html>