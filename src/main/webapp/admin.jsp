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
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">

</head>
<body>

<%@include file="includes/admin-navbar.jsp" %>

<section class="container mt-4 ">

    <a href="/add-book" class="btn btn-outline-dark btn-lg px-5">Add a book</a>

    <a href="/add-category-form.jsp" class="btn btn-outline-dark btn-lg px-5">Add a category</a>

    <a href="/add-author-form.jsp" class="btn btn-outline-dark btn-lg px-5">Add an author</a>

    <a href="/add-user-form.jsp" class="btn btn-outline-dark btn-lg px-5">Add user</a>

    <c:if test="${message != null}">
        <h1>${message}</h1>
    </c:if>

    <div class="row justify-content-around">

        <c:forEach items="${bookList}" var="book">
            <div class="card my-4 text-center shadow col-md-3" style="width: 18rem;">
                <a href="/book-description?id=${book.getId()}"> <img src="files/${book.getImgFileName()}"class="card-img-top" alt="${book.getTitle()}"></a>
                <div class="card-body">
                    <h5 class="card-title">${book.getTitle()}</h5>
                    <c:forEach items="${book.getAuthors()}" var="author">
                        <a href="/authors?id=${author.getId()}">
                            <h6 class="card-title">${author.getFullName()}</h6>
                        </a>
                    </c:forEach>
                    <a href="/category-search?id=${book.getCategory().getId()}"><p class="card-text">${book.getCategory().getName()}</p></a>

                </div>
            </div>
        </c:forEach>

    </div>


</section>




</body>
</html>
