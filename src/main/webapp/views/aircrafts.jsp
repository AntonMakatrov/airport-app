<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Самолеты</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #333;
            color: #fff;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Список самолетов</h1>
<table>
    <thead>
    <tr>
        <th>Код самолета, IATA</th>
        <th>Модель самолета</th>
        <th>Максимальная дальность полета, км</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="item">
        <tr>
            <td>${item.aircraftCode}</td>
            <td>${item.model}</td>
            <td>${item.range}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!-- Кнопка для возврата на главную страницу -->
<a href="${pageContext.request.contextPath}">Вернуться на главную страницу</a>

</body>
</html>