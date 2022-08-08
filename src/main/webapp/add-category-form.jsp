<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ADD NEW CATEGORY</title>
</head>
<body>
<h1>ADD NEW CATEGORY</h1>
<br/>


<form action="/add-category" method="post">

    <label for="title">Name:</label>

    <input id="title" type="text" name="name">

    <br>

    <input type="submit" value="Saqlash">

</form>
</body>
</html>