
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Markets</title>
</head>
<body>
        Size: ${requestScope.size}<br>

        <c:forEach items="${requestScope.markets}" var="market">
            ${market.id}, ${market.name} <br>
        </c:forEach>


</body>
</html>
