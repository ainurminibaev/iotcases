<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Главная страница Портала профессионального развития юристов</title>
    <link rel="stylesheet" href="/resources/css/index.css">
</head>
<body>

<section id="info">

    <div class="wrapper clearfix">
        <header class="header clearfix">
            <a href="/" class="logo" tabindex="-1"><h1>Портал профессиональ-<br>ного развития юристов</h1></a>

            <menu>
                <li><a href="src.html" tabindex="-1">Архив рассылок</a></li>
                <li><a href="#partners" tabindex="-1">Партнеры</a></li>
                <li><a href="/activities" tabindex="-1">Мероприятия</a></li>
            </menu>
        </header>
        <div class="header_info">

            <div class="info">
                <div>
                    <h2>Мы преодоставляем лучшее<br>
                        для личного и профессионального развития</h2>
                </div>
                <div>
                    <p><a href="#subscribeForm" tabindex="-1">Подпишитесь на рассылку,</a> и узнавайте первыми о
                        новых<br>
                        возможностях в сфере юридического образования и карьеры </p>
                </div>
            </div>

        </div>
    </div>


</section>

<main>
    <div class="wrapper">
        <div id="formWrapper">

        </div>
        <ul class="partners" id="partners">
            <li><a href="#" tabindex="-1"><img src="/resources/img/1.jpg" alt="1"></a></li>
            <li><a href="#" tabindex="-1"><img src="/resources/img/2.jpg" alt="1"></a></li>
            <li><a href="#" tabindex="-1"><img src="/resources/img/3.jpg" alt="1"></a></li>
            <li><a href="#" tabindex="-1"><img src="/resources/img/4.jpg" alt="1"></a></li>
            <li><a href="#" tabindex="-1"><img src="/resources/img/5.jpg" alt="1"></a></li>
            <li><a href="#" tabindex="-1"><img src="/resources/img/6.jpg" alt="1"></a></li>
            <li><a href="#" tabindex="-1"><img src="/resources/img/7.jpg" alt="1"></a></li>
        </ul>

    </div>
</main>
<footer class="footer">
    <div id="quote-div" class="wrapper">
        <p>Mauris id condimentum justo. Suspendisse cursus finibus neque. Interdum et malesuada fames ac ante ipsum
            primis in faucibus. Mauris porta eu lacus at ultricies. Quisque mattis gravida dolor, sit amet scelerisque
            mauris facilisis non. Maecenas iaculis urna eu diam venenatis, molestie tempus volutpat.</p>
        <span>- Джордж Бернард Шоу</span>
    </div>
</footer>

<script src="/resources/bower/jquery/dist/jquery.min.js"></script>
<script src="/resources/js/clickToggle.js"></script>
<script src="/resources/js/doT.js"></script>
<script src="/resources/js/index.js"></script>
<script src="/resources/js/smooth.js"></script>
<script src="/resources/js/data_delivery_items.js"></script>
<script src="/resources/js/data_quotes.js"></script>
<script src="/resources/js/common.js"></script>
<script type="text/html" id="template_form">
    <form id="subscribeForm" method="get" action="/law2">
        <p>Подписка на рассылку</p>

        <div class="subscr_wrap">
            <div class="row">
                <div class="for_errors"></div>
                {{?it.nameFirst}}<input type="text" name="field_name_first" placeholder="Имя" tabindex="1"
                                        class="validate">{{?}}
            </div>
            <div class="row">
                <div class="for_errors"></div>
                {{?it.nameLast}}<input type="text" name="field_name_last" placeholder="Фамилия" tabindex="2"
                                       class="validate">{{?}}

            </div>

            <div class="row">
                {{?it.nameMid}}<input type="text" name="field_name_mid" placeholder="Отчество" tabindex="3">{{?}}

            </div>

            <div class="row">
                <div class="for_errors"></div>
                {{?it.email}}<input type="email" name="field_email" placeholder="E-mail" tabindex="4" class="validate">{{?}}

            </div>


            {{?it.items}}
        </div>

        <p class="interest_themes">Выберите интересующие вас темы рассылки:</p>

        <div class="themes_wrap clearfix">
            {{~it.items:value:key}}{{=value}}{{~}}
        </div>
        {{?}}
        <button type="submit" name="submit" id="subscribe" class="btn" tabindex="5">Подписаться</button>
    </form>
</script>
<script type="text/html" id="template_delivery_item">
    <div class="theme">
        <div class="theme_header">
            <input type="checkbox" id="{{=it.id}}" name="{{=it.id}}" checked>
            <label for="{{=it.id}}">
                    <span>
                        {{=it.title}}
                    </span>
            </label>
        </div>
        <div class="theme_info">
            <p>
                {{=it.description}}
            </p>
        </div>
    </div>
</script>
</body>
</html>