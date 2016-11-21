<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Handler</title>
</head>
<body>
<h1>Hey!</h1>
<%
    int number1 = Integer.parseInt(request.getParameter("number1"));
    int number2 = Integer.parseInt(request.getParameter("number2"));
    int action = Integer.parseInt(request.getParameter("action"));
    switch (action) {
        case 1: %><span>Результат сложения: <b><%= number1 + number2 %></b></span><%
            break;
        case 2:%><span>Результат вычитания: <b><%= number1 - number2 %></b></span><%
            break;
        case 3:%><span>Результат умножения: <b><%= number1 * number2 %></b></span><%
            break;
        case 4:%><span>Результат деления: <b><%= number1 / number2 %></b></span><%
            break;
    }

%>


</body>
</html>
