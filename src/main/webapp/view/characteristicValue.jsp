<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@ page import="ru.ncedu.webapp.models.CharacteristicValue" %>
<%@ page import="java.util.List" %>

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

    <%
        List<CharacteristicValue> characteristicValues = (List<CharacteristicValue>) request.getAttribute("characteristicValue");
        for(CharacteristicValue characteristicValue : characteristicValues) {
    %>
    <tr>
        <td><%=characteristicValue.getCharacteristicId()%></td>
        <td><%=characteristicValue.getProductId()%></td>
        <td><%=characteristicValue.getValue()%></td>
    </tr>
    <%
        }
    %>
        <%--<c:forEach items="${requestScope.characteristicValue}" var="characteristicValue">--%>
            <%--${characteristicValue.characteristic_id}, ${characteristicValue.product_id}, ${characteristicValue.value}--%>
        <%--</c:forEach>--%>

    <tr>
        <td colspan="3">
            Size: ${requestScope.size}
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
