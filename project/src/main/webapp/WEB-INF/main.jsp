<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавление товара</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f7fa;
            margin: 40px;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            width: 300px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Добавить новый товар</h1>

<form action="add" method="post">
    Название:<br>
    <input type="text" name="title" required><br>
    Описание:<br>
    <input type="text" name="description" required><br>
    Цена:<br>
    <input type="number" name="price" required><br>
    <input type="submit" value="Добавить товар">
</form>

<hr/>

<ul>
 <c:forEach items="${goods}" var="good">
<form action="change" method="post">
<input type="hidden" name="id" value="${good.id}">
<li>${good.title}<input type="submit" name="action" value="Edit"> <input type="submit" name="action" value="Delete"></li>
</form>
</c:forEach>
</ul>





</body>
</html>
