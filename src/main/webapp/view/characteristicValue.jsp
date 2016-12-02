<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 30.11.2016
  Time: 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Characteristic Value</title>
</head>
<style>
    .main-list {
        margin: 10px auto;
        border: 1px solid black;
    }

    .main-list td {
        border-top: 1px solid black;
        border-right: 1px solid black;
        padding: 10px;
    }

    .main-list td:last-child {
        border-right: none;
    }

    .main-list thead tr td {
        border-top: none;
    }
</style>
<body>


<table class="main-list">
    <thead>
    <tr>
        <td><b>Characteristic id</b></td>
        <td><b>Product id</b></td>
        <td><b>Value</b></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.characteristicValue}" var="characteristicValue">
        <tr>
            <td>${characteristicValue.characteristicId}</td>
            <td>${characteristicValue.productId}</td>
            <td>${characteristicValue.value}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            Size: ${requestScope.size}
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
