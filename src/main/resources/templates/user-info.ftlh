<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>

<a href="/"><h1>BUYSELL</h1></a>
<hr>
<h3>Информация о продавце ${user.name}:</h3>
<b>Номер телефона: </b> ${user.phoneNumber}<br>
<b>Почта: </b> ${user.email}<br>

<h4>Товары пользователя ${user.name}</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>

</body>
</html>