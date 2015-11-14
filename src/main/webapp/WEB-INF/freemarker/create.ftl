<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/create" method="POST">
    <input type="text" name="name">Имя <br>
    <input type="text" name="password">Пароль <br>

    <select name="role" id="">
        <option value="0">User</option>
        <option value="1">Admin</option>
    </select>
    <br>

<#list devices as device>
    <input type="checkbox" name="device" value="${device.id}"> ${device.name}
</#list>

    <br>
    <input type="submit" value="Go">
</form>
</body>
</html>