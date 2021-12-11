package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.models.Order;
import ru.pcs.web.models.User;
import ru.pcs.web.services.ProductsService;
import ru.pcs.web.services.UsersService;

import java.util.List;


@Controller
public class CatalogController {

    private final ProductsService productsService;
    private final UsersService usersService;

    @Autowired
    public CatalogController(ProductsService productsService, UsersService usersService) {
        this.productsService = productsService;
        this.usersService = usersService;
    }

    @GetMapping("/catalog")
    public String getProductsPage(ModelMap modelMap) {
        modelMap.put("products", productsService.getAllProducts());
        return "catalog";
    }


    @PostMapping("/products/${product.id}/add-to-order")
    public String addProductsToOrder(@PathVariable("product-id") Integer productId) {
        Order order = new Order();
        order.addProduct(productsService.getProduct(productId));
        return "redirect:/catalog";
    }

}

