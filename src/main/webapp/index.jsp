<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 11/28/2016
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main menu</title></head>
    <link rel="stylesheet" type="text/css" href="/style/button.css" media="screen"/>
<body>
<form action="/mainMenu" method="post">
    <div>
    <button type="submit" name="choice" value="calc" cl>Calculator</button>
    <button type="submit" name="choice" value="price">Data Base Price</button>
    </div>
</form>
</body>
</html>
