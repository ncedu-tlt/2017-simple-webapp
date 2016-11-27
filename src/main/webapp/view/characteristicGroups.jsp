<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Characteristic groups</title>
</head>
<body>
Size: ${requestScope.size}<br>

<c:forEach items="${requestScope.characteristicGroups}" var="characteristicGroup">
    ${characteristicGroup.id}, ${characteristicGroup.name}, ${characteristicGroup.orderNumber} <br>
</c:forEach>


</body>
</html>
