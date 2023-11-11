<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h1>BUYSELL</h1><hr>
<h4>Подробная информация о товаре</h4>
<#list images as img>
    <img src="/images/${img.id}" height="60px" alt="Ваше объявление"/><br><br>
</#list>

<b>Название товара: </b> ${product.title}<br>
<b>Описание товара: </b> ${product.description}<br>
<b>Город товара: </b> ${product.city}<br>
<b>Автор товара: </b> ${product.author}<br>
<b>Цена товара: </b> ${product.price}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар">
</form>
</body>
</html>