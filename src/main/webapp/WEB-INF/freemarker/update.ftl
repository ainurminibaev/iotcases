<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/update" method="POST">
    <input type="text" name="name" value="${user.name}">Имя <br>
    <input type="text" name="password" ${user.password}>Пароль <br>
    <input type="text" name="role" value="${user.role}">Роль <br>

<#list devices as dev>
    <#if dev.checked>
        <input type="checkbox" name="device" value="${dev.device.id}" checked> ${dev.device.name}
    <#else>
        <input type="checkbox" name="device" value="${dev.device.id}"> ${dev.device.name}
    </#if>
</#list>



    <input type="submit" value="Go">
</form>
</body>
</html>