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

<form action="/edit" method="post" enctype="multipart/form-data">

    <c:forEach items="${booklist}" var="book">
        <c:if test="${id == book.getId()}">

            Id:<input type="number" name="id" value="${book.getId()}" >

            <br>


    Title:<input type="text" name="title" value="${book.getTitle()}">

    <br>
    Description:<textarea  name="description" value="${book.getDescription()}"></textarea>

    <br>

     Select Author(s):<select name="authorsIds" multiple>
        <option disabled value="0">Select authors:</option>
        <c:forEach items="${authorList}" var="author">
            <option value="${author.getId()}">${author.getFullName()}</option>
        </c:forEach>
    </select>

    <br>
    Select category:<select id="categoryId" name="categoryId">
        <option disabled value="0">Select category:</option>
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.getId()}">${category.getName()}</option>
        </c:forEach>
    </select>

    <br>
   Isbn:<input id="isbn" type="text" name="isbn" value="${book.getIsbn()}">

    <br>
    Year<input  type="number" name="year" value="${book.getYear()}">

    <br>
   Upload cover image:<input  type="file" name="image">

    <br>

            <input type="submit" value="Saqlash">

        </c:if>
    </c:forEach>





</form>
</body>
</html>