<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Товары</title>
</head>
<body>
<h1>Добавление товара</h1>
<form method="post" action="/products">
    <label><@spring.message 'products.form.input.description'/>:
        <input name="description" placeholder="<@spring.message 'products.form.input.description'/>">
    </label>
    <label><@spring.message 'products.form.input.price'/>
        <input name="price" placeholder="<@spring.message 'products.form.input.price'/>">
    </label>
    <label><@spring.message 'products.form.input.amount'/>
        <input name="amount" placeholder="<@spring.message 'products.form.input.amount'/>">
    </label>
    <input type="submit" value="<@spring.message 'products.form.input.submit'/>">
</form>
<table>
    <tr>
        <th>ID</th>
        <th><@spring.message 'products.table.header.description'/></th>
        <th><@spring.message 'products.table.header.price'/></th>
        <th><@spring.message 'products.table.header.amount'/></th>
        <th><@spring.message 'products.table.header.action'/></th>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.amount}</td>
            <td>
                <form method="post" action="/products/${product.id}/delete">
                    <input type="submit" value="Удалить">
                </form>
                <a href="/products/${product.id}">Перейти</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
