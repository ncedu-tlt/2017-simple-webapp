<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<form action="${pageContext.request.contextPath}/calculate" method="post">
    <input name="value" type="text"/>
    <button type="submit">Calculate</button>
    <button type="reset">Clear</button>
</form>

</body>
</html>

