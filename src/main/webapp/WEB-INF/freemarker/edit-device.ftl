<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Jasny Bootstrap</title>

    <!--Подключаем CSS Twitter Bootstrap -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet" media="screen">

    <!--Подключаем CSS Jasny Bootstrap -->

    <link href="/resources/css/styles.css" rel="stylesheet" media="screen">
    <link href="/resources/css/jasny-bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navmenu navmenu-default navmenu-fixed-left offcanvas-sm">
    <a class="navmenu-brand visible-md visible-lg" href="#">Logo</a>
    <ul class="nav navmenu-nav left-menu">
        <li><a href="/create" class="left-menu-item"><i class="fa fa-user-plus"></i> Add user</a></li>
        <li><a href="/edit" class="left-menu-item"><i class="fa fa-pencil-square-o"></i> Edit users</a></li>
        <li><a href="/edit-device" class="left-menu-item"><i class="fa fa-plus"></i> Create device</a></li>

    </ul>
</div>
<div class="navbar navbar-default navbar-fixed-top hidden-md hidden-lg">
    <button type="button" class="navbar-toggle" data-toggle="offcanvas" data-target=".navmenu">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Project name</a>
</div>
<div class="container wrapper">
    <div class="col-md-3 border-right">
        <h3>Cписок устройств</h3>
    <#list devices as device>
        <div class="device">
            <div class="device-name device-name-bg-green" onclick="getDevice(${device.id})">${device.name}</div>
            <div style="clear: both"></div>
        </div>
    </#list>
    </div>

    <div class="col-md-5" id="list-devices">

    </div>


</div>

<script>
    function getDevice(id) {
        $.ajax({
            url: "/edit-device/" + id,
            type: "GET",
            dataType: "html",
            success: function (data) {
                $('#list-devices').html(data);
            }
        })
    }
</script>
<!-- Подключаем jQuery -->

<!-- Подключаем JavaScript Twitter Bootstrap -->
<script src="/resources/js/bootstrap.min.js"></script>

<!-- Подключаем JavaScript Jasny Bootstrap -->
<script src="/resources/js/jasny-bootstrap.min.js"></script>
<script>
    var div;
    $('.device').on('click',function(){
        if(div){
            $(div).find(".device-name").removeClass().addClass("device-name full-green-bg");
            $(this).find(".device-name").removeClass().addClass("device-name full-red-bg");
            div = $(this);
        }else{
            $(this).find(".device-name").removeClass().addClass("device-name full-red-bg");
            div = $(this);
        }
    });
</script>
</body>
</html>