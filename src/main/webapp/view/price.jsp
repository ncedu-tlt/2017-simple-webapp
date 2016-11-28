<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 11/28/2016
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Prices</title>
</head>
<body>
    Size: ${requestScope.size()}<br>
    Price (taglib):<br>
    <c:forEach items="${requestScope.prices}" var="price">
        ${price.marketId}, ${price.productId}, ${price.price} <br>
    </c:forEach>
</body>
</html>
