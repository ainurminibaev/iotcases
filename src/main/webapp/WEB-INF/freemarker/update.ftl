<form class="form-horizontal" action="/update" method="POST">
    <div class="col-md-3 border-right">
        <h3>Список девайсов</h3>
    <#list devices as dev>
        <#if dev.checked>
            <div class="device">
                <div class="device-name device-name-bg-green">${dev.device.name}</div>
                <div class="check"><input type="checkbox" name="device" value="${dev.device.id}" checked/></div>
                <div style="clear: both"></div>
            </div>
        <#else>
            <div class="device">
                <div class="device-name device-name-bg-red">${dev.device.name}</div>
                <div class="check"><input type="checkbox" name="device" value="${dev.device.id}"/></div>
                <div style="clear: both"></div>
            </div>
        </#if>
    </#list>

    </div>
    <div class="col-md-6" style="margin-top: 50px;">
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Имя</label>
            <input type="hidden" value="${user.id}" name="id">
            <div class="col-xs-10">
                <input type="text" class="form-control" value="${user.name}" name="name" id="inputPassword"
                       placeholder="username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Роль</label>

            <div class="col-xs-10">
                <select class="form-control" name="role">
                <#if user.role = "ROLE_USER">
                    <option value="0" selected>User</option>
                    <option value="1">Admin</option>
                <#else>
                    <option value="0">User</option>
                    <option value="1" selected>Admin</option>
                </#if>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword" class="control-label col-xs-2">Пароль</label>

            <div class="col-xs-10">
                <input type="password" class="form-control" name="password" id="inputPassword" value="${user.password}"
                       placeholder="password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </div>
    </div>
</form>
<script>
    $('input[type="checkbox"]').on('click',function(){
        if(this.checked){
            $(this).parent().parent().find('.device-name').removeClass().addClass("device-name device-name-bg-green");
        }else{1
            $(this).parent().parent().find('.device-name').removeClass().addClass("device-name device-name-bg-red");
        }
    });
</script>