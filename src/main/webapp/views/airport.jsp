<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Аэропорты</title>
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
<h1 style="text-align: center;">Список аэропортов</h1>
<table>
  <thead>
  <tr>
    <th>Код аэропорта</th>
    <th>Название аэропорта</th>
    <th>Город</th>
    <th>Координаты аэропорта (долгота и широта)</th>
    <th>Часовой пояс аэропорта</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${data}" var="item">
    <tr>
      <td>${item.airportCode}</td>
      <td>${item.airportName}</td>
      <td>${item.city}</td>
      <td>${item.coordinates}</td>
      <td>${item.timezone}</td
    </tr>
  </c:forEach>
  </tbody>
</table>
<!-- Кнопка для возврата на главную страницу -->
<a href="${pageContext.request.contextPath}">Вернуться на главную страницу</a>

</body>
</html>