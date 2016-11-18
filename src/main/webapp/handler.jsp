<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Handler</title>
</head>
<body>
    <h1>Hey!</h1>
    <%
        String text = request.getParameter("text");
        if (text != null && !text.isEmpty()) {
    %>
        <span>You entered the following text: <b><%= text %></b></span>
    <%
        } else {
    %>
        <span>You haven't left any text message to me :(</span>
    <%
        }
    %>
</body>
</html>
