<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Handler</title>
</head>
<body>

<h1>Hey!</h1>
    <%
        String text1 = request.getParameter("text");
        if (text1 != null && !text1.isEmpty()) {
    %>
    <span>You entered the following text: <b><%= text1 %></b></span>
    <%
        }else {
    %>
    <span>You haven't left any text message to me :(</span>
    <%
        }
    %>
    <%
        String text2 = request.getParameter("text");
        if (text2 != null && !text2.isEmpty()) {
    %>
        <span>You entered the following text: <b><%= text2 %></b></span>
    <%
        } else {
    %>
        <span>You haven't left any text message to me :(</span>
    <%
        }
    %>
</body>
</html>
