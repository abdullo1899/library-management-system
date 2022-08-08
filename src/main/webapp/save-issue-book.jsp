<%@ page import="uz.pdp.librarymanagementsystem.books.Book" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.08.2022
  Time: 5:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Issue a book</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">


</head>
<body>

<%@include file="includes/admin-navbar.jsp"%>

<section class="container mt-4 ">
   <form action="/save-i_r-book" method="get">

       <label for="student_id">Student ID</label>
       <select id="student_id" name="id">
           <option disabled value="0">Select Student</option>
           <c:forEach items="${userList}" var="user">
               <option value="${user.getId()}">${user.getFullname()}</option>
           </c:forEach>
       </select>
       <br>
       <label for="bookIds">Title:</label>
       <select id="bookIds" name="bookIds" multiple>
           <option disabled value="0">Select book:</option>
           <c:forEach items="${bookList}" var="book">
               <option value="${book.getId()}">${book.getTitle()}</option>
           </c:forEach>
       </select>

       <br><br>

       <input type="radio" name="is_issued" value="true">Issue<br>
       <input type="radio" name="is_issued" VALUE="false">Return<br><br>

       <button class="btn btn-outline-dark btn-lg px-5" type="submit">Save</button>


   </form>
</section>


</body>
</html>
