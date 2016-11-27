<html>

<body>
<h2>Calculator!</h2>

<form action="${pageContext.request.contextPath}/calculate" method="post">
    <input type="text" name="number1"/>
    <input type="text" name="number2"/>
    <div>
        <button type="submit" name="action" value="1">+</button>
        <button type="submit" name="action" value="2">-</button>
        <button type="submit" name="action" value="3">*</button>
        <button type="submit" name="action" value="4">/</button>
        <button type="reset">Clear</button>
    </div>
</form>

</body>
</html>
