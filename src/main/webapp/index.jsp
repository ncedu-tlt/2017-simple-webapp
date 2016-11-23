<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/nav.css" media="screen"/>
</head>
<body>
<h2>Calculator</h2>
<form action="/calc" method="post">
    <div class="wrapper">
        <div class="box">
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
                    <button type="submit" name="operation" value="sum">+</button>
                    <button type="submit" name="operation" value="dif">-</button>
                    <button type="submit" name="operation" value="mul">*</button>
                    <button type="submit" name="operation" value="div">/</button>
                    <button type="submit" name="operation" value="pow">a^b</button>
                    <button type="submit" name="operation" value="sqrt">&radic;a</button>
                </li>
            </ul>
        </div>
    </div>
</form>
</body>
</html>
