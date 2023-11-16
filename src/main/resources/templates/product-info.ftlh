<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>

<a href="/"><h1>BUYSELL</h1></a>
<hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px" alt="Ваше объявление"/><br><br>
</#list>

<b>Название товара: </b> ${product.title}<br>
<b>Описание товара: </b> ${product.description}<br>
<b>Город товара: </b> ${product.city}<br>
<b>Автор товара: </b> ${product.user.name}<br>
<b>Цена товара: </b> ${product.price}<br>
<b>Номер тел: </b> ${product.user.phoneNumber}<br>
<hr>


</body>
</html>