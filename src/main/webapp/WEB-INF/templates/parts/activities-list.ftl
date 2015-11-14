<#macro activities_list activities>
    <#list activities as event>
    <div class="event<#if event.expired> blocked</#if>">

        <strong class="name">${event.name}</strong>

        <div class="event_info">

            <div class="event_img"><img src="${event.img}" alt="first"></div>
            <div class="event_information">
                <table>
                    <tr>
                        <td>Что:</td>
                        <td>${event.type}</td>
                    </tr>
                    <tr>
                        <td>Где:</td>
                        <td>${event.place}</td>
                    </tr>
                    <tr>
                        <td>Когда:</td>
                        <td>${event.when}</td>
                    </tr>
                    <tr>
                        <td>Для кого:</td>
                        <td>${event.forWhom}</td>
                    </tr>
                    <tr>
                        <td>Стоимость:</td>
                        <td>${event.cost}</td>
                    </tr>
                </table>
            </div>
        </div>


        <a href="/activities/${event.id}/${event.alias}" tabindex="-1">Подробнее</a>
    </div>
    </#list>
</#macro>
