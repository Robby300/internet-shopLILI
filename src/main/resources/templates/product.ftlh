<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${product.description}</title>
</head>
<body>
<h3>Описание товара - ${product.description}</h3>
<h3>Цена - ${product.price}</h3>
<h3>Количество - ${product.amount}</h3>
<br>
<form method="post" action="/products/${product.id}/update">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label>
        Описание: <input name="description" value="${product.description}">
    </label>
    <label>
        Цена: <input name="price" value="${product.price}">
    </label>
    <label>
        Количество: <input name="amount" value="${product.amount}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
</body>
</html>
