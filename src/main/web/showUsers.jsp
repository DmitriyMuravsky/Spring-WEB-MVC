<%--
  Created by IntelliJ IDEA.
  User: LDP
  Date: 10.04.2019
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
    <table border="2">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Login</td>
            <td>Pass</td>
            <td>Role</td>
            <td colspan="2">Action</td>
        </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
    <c:forEach var="role" items="${user.roles}">
            <td>${role.name}</td>
    </c:forEach>
            <td><a href="/admin/edit/${user.id}">Edit</a></td>
            <td><a href="/admin/delete/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
    <a href="/admin/add">
        <input type="submit" value="Добавить нового пользователя">
    </a>
    <a href="/logout">
        <input type="submit" value="Выход">
    </a>

</body>
</html>
