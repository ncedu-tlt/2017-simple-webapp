<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
Size: ${requestScope.size}<br>


Products: <br>
<c:forEach items="${requestScope.products}" var="product">
    <table>
        <tr>
            <td>${product.id}</td>
            <td>${product.categoryId}</td>
            <td>${product.name}</td>
            <td>${product.description} </td>
        </tr>
    </table>
</c:forEach>
</body>
</html>