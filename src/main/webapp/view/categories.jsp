<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.ncedu.webapp.models.Category" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    Size: ${requestScope.size}<br>


    Categories (taglib): <br>
    <c:forEach items="${requestScope.categories}" var="category">
        ${category.id}, ${category.name}, ${category.description} <br>
    </c:forEach>


    Categories (java): <br>
    <%
        List<Category> categories = (List<Category>) request.getAttribute("categories");
        for(Category category : categories) {
        %>
            <%=category.getId()%>, <%=category.getName()%>, <%=category.getDescription()%> <br>
        <%
        }
    %>
</body>
</html>
