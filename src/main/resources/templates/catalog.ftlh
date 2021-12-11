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
<table>
    <tr>
        <th><@spring.message 'products.table.header.description'/></th>
        <th><@spring.message 'products.table.header.price'/></th>
        <th><@spring.message 'products.table.header.action'/></th>
    </tr>
    <#list products as product>
        <tr>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>
                <form method="post" action="/products/${product.id}/add-to-order">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
