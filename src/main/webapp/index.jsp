<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>The Bank List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>The Bank List</h2>
<br>
<br>
<div class="web-field">
    <form action="control.html" method="get">
        <input readonly name="rich"
               value="${rich}"/>
        <input type="submit" value="richest user">
    </form>
</div>
<br>
<br>
<div>
    <form action="control.html" method="get">
        <input name="sum" readonly
               value="${sum}"/>
        <input type="submit" value="sum of all accounts">
    </form>
</div>
</body>
</html>
