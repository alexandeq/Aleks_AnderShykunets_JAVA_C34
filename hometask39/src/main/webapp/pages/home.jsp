<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>REGISTRATION</title>

</head>
<body>

<form method="post" action="/1/home/register">
Login: <input type="text" name="login" value="${login}"> ${loginError}<br>
Email: <input type="text" name="email" value="${email}">${emailError}<br>
Age: <input type="number" name="age" value="${age}">${ageError}<br>

<input type="Submit" value="Отправить">

</body>
</html>