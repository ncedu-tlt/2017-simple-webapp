<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h1> Your result:
        <%=
            request.getAttribute("Result")
        %>
    </h1>
</body>
</html>
