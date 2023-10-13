<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Меню</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        h1 {
            color: #333;
        }

        form {
            margin: 20px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Выберите действие:</h1>
<form action="${pageContext.request.contextPath}/html/aircraft">
    <input type="submit" value="Просмотр самолетов">
</form>
<form action="${pageContext.request.contextPath}/html/airport">
    <input type="submit" value="Просмотр аэропортов">
</form>
<form action="${pageContext.request.contextPath}/html/flight">
    <input type="submit" value="Просмотр полетов">
</form>
</body>
</html>