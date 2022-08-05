<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Add New User</h1>
<form action="/register" method="post">
    <table>
        <tr><td>Username:</td><td><input type="text" name="username"/></td></tr>
        <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
        <tr><td>Fullname:</td><td><input type="text" name="fullname"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="Save User"/></td></tr>
    </table>
</form>

<br/>
<a href="ViewUsers">view users</a> |
<a href="ViewBooks">view books</a> |
<a href="book_c.jsp">add book</a>
</body>
</html>