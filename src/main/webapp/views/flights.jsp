<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Список полетов</title>
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
<h1 style="text-align: center;">Список полетов</h1>
<form action="${pageContext.request.contextPath}/html/flight" method="get">
    <label for="page">Страница:</label>
    <input type="text" id="page" name="page" value="${param.page}">
    <label for="size">Записей на странице:</label>
    <select id="size" name="size">
        <option value="10" ${param.size == '10' ? 'selected' : ''}>10</option>
        <option value="20" ${param.size == '20' ? 'selected' : ''}>20</option>
        <option value="50" ${param.size == '50' ? 'selected' : ''}>50</option>
    </select>

    <label for="fromDate">Время вылета по расписанию:</label>
    <input type="text" id="fromDate" name="fromDate">
    <label for="toDate">Время прилёта по расписанию:</label>
    <input type="text" id="toDate" name="toDate">
    <label for="departureAirport">Аэропорт отправления:</label>
    <input type="text" id="departureAirport" name="departureAirport">
    <label for="arrivalAirport">Аэропорт прибытия:</label>
    <input type="text" id="arrivalAirport" name="arrivalAirport">
    <label for="status">Статус рейса:</label>
    <input type="text" id="status" name="status">

    <button type="submit">Применить</button>
</form>

<table>
    <thead>
    <tr>
        <th>Идентификатор рейса</th>
        <th>Номер рейса</th>
        <th>Время вылета по расписанию</th>
        <th>Время прилёта по расписанию</th>
        <th>Аэропорт отправления</th>
        <th>Аэропорт прибытия</th>
        <th>Статус рейса</th>
        <th>Код самолета, IATA</th>
        <th>Фактическое время вылета</th>
        <th>Фактическое время прилёта</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="item">
        <tr>
            <td>${item.flightId}</td>
            <td>${item.flightNo}</td>
            <td>${item.scheduledDeparture}</td>
            <td>${item.scheduledArrival}</td>
            <td>${item.departureAirport}</td>
            <td>${item.arrivalAirport}</td>
            <td>${item.status}</td>
            <td>${item.aircraftCode}</td>
            <td>${item.actualDeparture}</td>
            <td>${item.actualArrival}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<!-- Кнопка для возврата на главную страницу -->
<a href="${pageContext.request.contextPath}">Вернуться на главную страницу</a>

</html>
