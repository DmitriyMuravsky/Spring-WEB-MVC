<%--
  Created by IntelliJ IDEA.
  User: LDP
  Date: 11.04.2019
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form action="/admin/edit/" method="post">
    <input type="hidden" name = "id" value="${user.id}">
    <input type="text" name="name" value="${user.name}" placeholder="Введите имя">
    <input type="text" name="login" value="${user.login}" placeholder="Введите логин">
    <input type="text" name="password" value="${user.password}" placeholder="Введите пароль">
    <select name="role">
        <option>admin</option>
        <option>user</option>
        <option>guest</option>
    </select>
    <input type="submit" value="Обновить">
</form>
</body>
</html>
