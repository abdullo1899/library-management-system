<%@ page import="uz.pdp.librarymanagementsystem.i_r_book.I_R_book" %>
<%@ page import="uz.pdp.librarymanagementsystem.i_r_book.I_R_Dao" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.librarymanagementsystem.books.Book" %>
<%@ page import="uz.pdp.librarymanagementsystem.user.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.08.2022
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Return a book</title>
  <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<section class="container mt-4 ">
    <form action="/return-book" method="get">
        <%User user = (User) request.getAttribute("user");%>
        <label for="bookIds">Title:</label>
        <select id="bookIds" name="bookIds" multiple>
            <option disabled value="0">Select books:</option>
            <c:forEach items="${list}" var="book">
                <c:if test="${book.getIs_issued() && user.getId() == book.getStudent_id()}">
                <c:forEach items="${book.getBook_ids()}" var="gbook">
                        <option value="${gbook.getId()}"> ${gbook.getTitle()}</option>
                </c:forEach>
                </c:if>
            </c:forEach>
        </select>

        <button class="btn btn-outline-dark btn-lg px-5" type="submit">Return</button>


    </form>
</section>
</body>
</html>
