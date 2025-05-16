<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.Car" %>

<html>
<head>
    <title>Hometask27</title>
</head>
<body>

<h2> JSP skriplet:</h2>


<%
    List<Car> cars = (List<Car>)request.getAttribute("cars");

    for (Car car : cars) {
    %>
<li> <%= car.getId() %> -- <%= car.getModel() %> -- <%= car.getPrice() %> </li>

<%
    }
%>

<h2> JSTL tag:</h2>



<c:forEach var="car" items="${cars}">
<li>${car.id} -- ${car.model} -- ${car.price}</li>
</c:forEach>


</body>
</html>


