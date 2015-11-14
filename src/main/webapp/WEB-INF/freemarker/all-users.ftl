<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<#list users as user>
<p><a href="/update/${user.id}">${user.id} ${user.name}</a></p>
</#list>
</body>
</html>