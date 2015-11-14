<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="/update" method="POST">
    <input type="hidden" name="id" value="${user.id}">
    <input type="text" name="name" value="${user.name}">Имя <br>
    <input type="text" name="password" value="${user.password}">Пароль <br>

    <select name="role" id="">
    <#if user.role = "ROLE_USER">
        <option value="0" selected>User</option>
        <option value="1">Admin</option>
    <#else>
        <option value="0">User</option>
        <option value="1" selected>Admin</option>
    </#if>

    </select>

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