package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pcs.web.forms.ProductForm;
import ru.pcs.web.models.Product;
import ru.pcs.web.services.ProductsService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String getProductsPage(Model model) {
        List<Product> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "products";
    }


    @PostMapping("/products")
    public String addProduct(ProductForm form) {
        productsService.addProduct(form);
        return "redirect:/product";
    }

    @PostMapping("/products/{id}/delete")
        public String deleteProduct(@PathVariable("id") Integer productId) {
        productsService.deleteProduct(productId);
        return "redirect:/products";
        }


    @GetMapping("/products/{id}")
    public String getProductPage(Model model, @PathVariable("id") Integer productId) {
        Product product = productsService.getProduct(productId);
        model.addAttribute("product", product);
        return "product";

    }


}
