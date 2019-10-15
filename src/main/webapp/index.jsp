<%@ page import="by.levkovets.banklist.service.impl.UserServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>The Bank List</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<%
    UserServiceImpl service = new UserServiceImpl();
%>
<body>
<h2>The Bank List</h2>
<br>
<br>
<div class="web-field">
    <input readonly value="<%=service.getRichestUser()%>"/><button formaction="">richest user</button>
</div>
<br>
<br>
<div>
    <input readonly value="<%=service.getSumAllAccounts()%>"/><button>sum of all accounts</button>
</div>
</body>
</html>
