<form action="/update-device" method="post">
    <input type="hidden" name="id" value="${device.id}">
    <input type="text" name="name" class="form-control" value="${device.name}">
    <button type="submit" class="btn btn-primary">Изменить</button>
</form>