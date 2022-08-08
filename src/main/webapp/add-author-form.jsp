<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ADD NEW AUTHOR</title>
</head>
<body>
<h1>ADD NEW AUTHOR</h1>
<br/>


<form action="/add-author" method="post">

    <label for="fullname">Full Name:</label>

    <input id="fullname" type="text" name="fullname">

    <br>

    <label for="biography">Biography:</label>

    <textarea id="biography" name="biography"></textarea>

    <br>

    <input type="submit" value="Saqlash">

</form>
</body>
</html>