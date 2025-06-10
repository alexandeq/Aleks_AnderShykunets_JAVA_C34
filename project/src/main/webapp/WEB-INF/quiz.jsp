<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Quiz</title>
</head>
<body>

Опросы<br>

<form action="edit" method="post">

<input type="hidden" name="id" value="${good.id}"><br>
Title: <input type="text" name="title" value="${good.title}"><br>
Description: <input type="text" name="description" value="${good.description}"><br>
Price: <input type="number" name="price" value="${good.price}"><br>
<input type="submit" value="Update"><br>







</form>
</body>
</html>