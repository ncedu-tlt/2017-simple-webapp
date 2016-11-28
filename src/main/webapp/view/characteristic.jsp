<%@ page import="java.util.List" %>
<%@ page import="ru.ncedu.webapp.servlets.models.Characteristic" %>
<%--
  Created by IntelliJ IDEA.
  User: Antoine
  Date: 29.11.2016
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Characteristics</title>
</head>
<body>

    Size: ${requestScope.size} <br>
    Characteristics <br>
    <c:forEach items="${requestScope.characteristics}" var="characteristic">
        <table>
            <tr>
                <td> ${characteristic.id} </td>
                <td> ${characteristic.name} </td>
                <td> ${characteristic.groupId} </td>
                <td> ${characteristic.categoryId} </td>
            </tr>
        </table>
    </c:forEach>

    <br>
    <br>
    // для проверки <br>
    Characteristics <br>
    <%
        List<Characteristic> characteristics = (List<Characteristic>) request.getAttribute("characteristics");
        for (Characteristic characteristic : characteristics) {
            %>
                <%=characteristic.getId()%>, <%=characteristic.getName()%>, <%=characteristic.getGroupId()%>,
                <%=characteristic.getCategoryId()%> <br>
            <%
        }

    %>

</body>
</html>
