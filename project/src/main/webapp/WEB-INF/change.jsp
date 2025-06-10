<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Редактирование</title>
</head>
<body>
Page for edit good<br>

<form action="edit" method="post">

<input type="hidden" name="id" value="${quiz.id}"><br>
<input type="text" name="question" value="${quiz.question}"><br>
<hr/>

<ul>
<c:forEach items="${quizs}" var="quiz">
<input type="hidden" name="id" value="${quiz.id}">
<li>${quiz.answer}</li>

</c:forEach>



<hr/>
<input type="text" name="question"><br>
<input type="submit" value="Добавить"><br>

</body>
</html>


