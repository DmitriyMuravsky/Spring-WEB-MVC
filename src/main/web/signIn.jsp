<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="/auth/signIn/process" method="post">
    <input type="text" name="login" placeholder="Введите логин">
    <input type="password" name="password" placeholder="Введите пароль">
    <input type="submit" value="Войти">
</form>
<a href="/auth/signUp">
    <input type="submit" value="Зарегистрироваться">
</a>
</body>
</html>