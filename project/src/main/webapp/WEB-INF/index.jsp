<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Опросы сотрудников фирмы</title>
    <meta charset="UTF-8">



</head>
<body>

<h1>Опросы</h1>

<form action="add" method="post">

Создать новый опросник: <input type="text" name="question"><br>
<input type="submit" value="Создать"><br>

</form>

<hr/>


<ul>
<c:forEach items="${quizs}" var="quiz">
<form action="change" method="post">
<input type="hidden" name="id" value="${quiz.id}">
<li>${quiz.question} <input type="submit" name="action" value="Редактировать"> <input type="submit" name="action" value="Удалить"></li>

</form>
</c:forEach>
</ul>





</body>
</html>

