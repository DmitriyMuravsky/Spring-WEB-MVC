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
    <title>Delete user</title>
</head>
<body>
    <p>Вы действительно хотите удалить пользователя ${name} ?</p>
    <form action="/delete/" method="post">
        <input type="hidden" name="id" value="${id}">
        <input type="submit" value="Удалить">
    </form>
</body>
</html>
