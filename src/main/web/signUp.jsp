<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="/auth/signUp" method="post">
    <input type="text" name="name" placeholder="Введите имя">
    <input type="text" name="login" placeholder="Введите логин">
    <input type="password" name="password" placeholder="Введите пароль">
    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>