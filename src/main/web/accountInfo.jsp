<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Добро пожаловать, ${user.name}</h2>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Имя</td>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Роль</td>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.login}</td>
        <td>${user.password}</td>
        <c:forEach var="role" items="${user.roles}">
            <td>${role.name}</td>
        </c:forEach>
    </tr>
    <tr>
        <td colspan="3">
            <form action="/logout" method="post">
                <input type="submit" value="Выход">
            </form>
        </td>
    </tr>
</table>
</body>
</html>