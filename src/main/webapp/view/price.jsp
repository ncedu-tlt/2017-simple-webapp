<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Prices</title>
    <link rel="stylesheet" type="text/css" href="/style/table.css" media="screen"/>
</head>
<body>
    <table>
        <caption align="top">Price:</caption>
        <th>Marked ID</th><th>Product ID</th><th>Price</th>
    <c:forEach items="${requestScope.prices}" var="price">
        <tr>
        <td>${price.marketId}</td><td>${price.productId}</td><td>${price.price}</td> <br>
        </tr>
    </c:forEach>
    </table>
    Table Size: ${requestScope.size}
</body>
</html>
