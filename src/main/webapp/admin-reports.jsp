<%@ page import="uz.pdp.librarymanagementsystem.user.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.2022
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>

<%@include file="includes/admin-navbar.jsp" %>

<section>

    <table class="table">
        <tr><th>Id</th><th>Student</th><th>Book</th><th>Date</th><th>Status</th></tr>
        <c:forEach items="${list}" var="i_r_book">
        <c:forEach items="${userlist}" var="user">
            <c:if test="${user.getId() == i_r_book.getStudent_id()}">
        <tr><td>${user.getId()}</td>
        <td>${user.getFullname()}</td>
        <c:forEach items="${booklist}" var="book">
        <c:forEach items="${i_r_book.getBook_ids()}" var="i_book">
        <c:if test="${book.getId() == i_book.getId()}">
        <td>${i_book.getTitle()}</td>
        <td>${i_r_book.getDate()}</td>
            <c:if test="${i_r_book.getIs_issued() == true}">
        <td>issued</td></tr>
            </c:if>
            <c:if test="${i_r_book.getIs_issued() == false}">
                <td>returned</td></tr>
            </c:if>
        </c:if>
        </c:forEach>
        </c:forEach>
        </c:if>
        </c:forEach>
        </c:forEach>





    </table>
</section>

</body>
</html>
