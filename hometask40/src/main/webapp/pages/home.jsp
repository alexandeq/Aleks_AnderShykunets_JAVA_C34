<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>REGISTRATION</title>

</head>
<body>
<a href="/1/home?lang=ru">RU</a><br>
<a href="/1/home?lang=en">EN</a><br>
<a href="/1/home?lang=pl">PL</a><br>

<sp:message code="login.title"/>

<sf:form method="post" action="/1/home/register" modelAttribute="personprofile">
 <sp:message code="param.login"/>: <sf:input path="login" type="text"/> <sf:errors path="login"/> <br>
 <sp:message code="param.email"/>: <sf:input path="email" type="text"/> <sf:errors path="email"/> <br>
 <sp:message code="param.age"/>: <sf:input path="age" type="number"/> <sf:errors path="age"/> <br>

<input type="submit" value="<sp:message code="param.submit"/>">

</sf:form>


</body>
</html>
