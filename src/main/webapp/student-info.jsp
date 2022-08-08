<%@ page import="uz.pdp.librarymanagementsystem.user.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.08.2022
  Time: 10:38
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

<%@include file="includes/user-navbar.jsp" %>

<div class="container d-flex justify-content-center align-items-center">

    <div class="card">

        <div class="upper">

            <img src="https://i.imgur.com/Qtrsrk5.jpg" class="img-fluid">

        </div>

        <div class="user text-center">

            <div class="profile">

                <img src="https://i.imgur.com/JgYD2nQ.jpg" class="rounded-circle" width="80">

            </div>

        </div>


        <div class="mt-5 text-center">
         <% User user =(User) request.getAttribute("user"); %>
            <h4 class="mb-0">Username: <%=user.getUsername()%></h4>
            <span class="text-muted d-block mb-2">Fullname: <%=user.getFullname()%></span>
            <h4 class="mb-0">Password: <%=user.getPassword()%></h4>

            <div class="d-flex justify-content-between align-items-center mt-4 px-4">


            </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
