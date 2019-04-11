<%--
  Created by IntelliJ IDEA.
  User: LDP
  Date: 11.04.2019
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <form action="/addSave" method="post">
        <input type="text" name="name" placeholder="name">
        <input type="text" name="login" placeholder="login">
        <input type="text" name="pass" placeholder="password">
        <input type="submit" value="Добавить">
    </form>
</body>
</html>
