<#import "/spring.ftl" as spring/>
<html>
<body>
<form action="/average" method="post">
    <input type="text" name="firstName" placeholder="name student" required/>
    <input type="text" name="surName" placeholder="lastname student" required/>
    <input type="text" name="lastName" placeholder="surname student" required/>
    <button type="submit">Average!</button>
</form>

<form action="/pointsubj" method="post">
    <input type="text" name="firstName" placeholder="name student" required/>
    <input type="text" name="surName" placeholder="lastname student" required/>
    <input type="text" name="lastName" placeholder="surname student" required/>
    <select name="subject" id="">
        <option value="0">MATH</option>
        <option value="1">ENGLISH</option>
        <option value="2">HISTORY</option>
        <option value="3">PHILOSOPHY</option>
        <option value="4">INFORMATICS</option>
    </select>
    <button type="submit">Go</button>
</form>
<form action="/tp" method="post">
        <input type="text" name="firstName" placeholder="name student" required/>
        <input type="text" name="surName" placeholder="lastname student" required/>
        <input type="text" name="lastName" placeholder="surname student" required/>
    <button type="submit">Total Pont!</button>
</form>


</body>
</html>
