<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.ncedu.simple-webapp.models.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Products</title>
</head>
<body>
Size: ${requestScope.size}<br>


Products: <br>
<c:forEach items="${requestScope.categories}" var="category">
    ${category.id}, ${category.name}, ${category.description} <br>
</c:forEach>


</body>
</html>