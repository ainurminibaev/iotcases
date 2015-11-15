<#list users as user>
<div class="user" onclick="getDevice(${user.id})">
    <div class="id-user">${user.id}</div>
    <div class="username">${user.name}</div>
    <div style="clear: both"></div>
</div>
</#list>
