<#import "/spring.ftl" as spring/>
<html>
<head>
    <title></title>
</head>
<body>
<#if average??>
    <h1>Average: ${average}</h1>
<#else>
    <h1>Not found</h1>
</#if>
</body>
</html>
