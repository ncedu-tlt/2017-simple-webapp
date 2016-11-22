<html>
<body>
<h2>Calculator</h2>
<form action="printParams" method="get">
    <link rel="nav" type="text/css" href="/main.css" media="screen" />
    <link rel="button" type="text/css" href="/button.css" media="screen" />
    <label>First number (a)</label>
    <input type="text" name="text1" value="0"/>
    <br/>
    <label>Second number (b)</label>
    <input type="text" name="text2" value="0"/>
    <br/>
    <br/>
    <button type="reset">Clear</button>
    <br/>
    <br/>
    <ul id=nav>
        <li>
        <input type="submit" name="sum" value="+"/>
        <input type="submit" name="dif" value="-"/>
        <input type="submit" name="mul" value="*"/>
        <input type="submit" name="div" value="/"/>
        <input type="submit" name="pow" value="a^b"/>
        <input type="submit" name="sqrt" value="&radic;"/>
        </li>
    </ul>

</form>
</body>
</html>
