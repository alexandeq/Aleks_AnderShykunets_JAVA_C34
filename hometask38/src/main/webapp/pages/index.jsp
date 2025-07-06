<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Оформить заказ</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h1 class="mb-4 text-center">Добро пожаловать</h1>

    <div class="card shadow-sm p-4 mb-5 bg-white rounded">
        <h4 class="mb-3">Пожалуйста, заполните форму для оформления заказа</h4>

        <form method="post" action="/shop/orders">
            <div class="mb-3">
                <label for="name" class="form-label">Имя:</label>
                <input type="text" class="form-control" name="name" required>
            </div>

            <div class="mb-3">
                <label for="birthdate" class="form-label">Дата рождения:</label>
                <input type="date" class="form-control" name="birthdate" value="2000-01-01" required>
            </div>

            <div class="mb-3">
                <label for="address" class="form-label">Адрес:</label>
                <input type="text" class="form-control" name="address" required>
            </div>

            <button type="submit" class="btn btn-success">Ввод</button>
        </form>
    </div>

    <div class="text-center">
        <a href="${pageContext.request.contextPath}/shop/info" class="btn btn-primary btn-lg">
            Перейти на страницу информации
        </a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
