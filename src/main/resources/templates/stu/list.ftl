<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生</title>
</head>
<body>
嘻嘻嘻嘻嘻<br>
欢迎 ${username}<br>

<#--<#if (age < 18) >-小朋友-->
<#--<#elseif (age > 30) >大叔-->
<#--<#else>帅哥/美女-->
<#--</#if>-->

学生列表<br>
<table border="1">
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>性别</td>
    </tr>
    <#list list?sort_by("id")?reverse as stu>
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.gender}</td>
        </tr>
    </#list>
</table>
</body>
</html>

