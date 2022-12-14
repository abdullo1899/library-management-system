<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 01/08/22
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>BOOK PAGE</title>
    <!--    <link rel="stylesheet" href="styles.css">-->

    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>

<%@include file="includes/user-navbar.jsp" %>

<!--SAYTNI MENYUDAN PASTKI QISMI KONTENTLAR-->
<section class="container mt-4 ">


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

<h3><a href="/books?page=1">1</a></h3> <h3><a href="/books?page=2">2</a></h3><h3><a href="/books?page=3">3</a></h3>


<!--SAYTNI PASTKI QISMI | SAYT HAQIDA YOKI KOMPANIYA HAQIDA MA'LUMOTLAR -->
<footer>

</footer>


</body>
</html>
