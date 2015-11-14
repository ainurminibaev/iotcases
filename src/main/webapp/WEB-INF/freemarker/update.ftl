<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/update" method="POST">
    <input type="text" name="name" value="${user.name}">Имя <br>
    <input type="text" name="password" ${user.password}>Пароль <br>
    <input type="text" name="role" value="${user.role}">Роль

<#list devices as device>
    <input type="checkbox" name="device" value="${device.id}"> ${device.name}
</#list>

    <input type="submit" value="Go">
</form>
</body>
</html>