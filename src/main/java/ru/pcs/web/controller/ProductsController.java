package ru.pcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.pcs.web.forms.ProductForm;
import ru.pcs.web.models.Product;
import ru.pcs.web.services.ProductsService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@Controller
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public String getProductsPage(ModelMap modelMap) {
        modelMap.put("products", productsService.getAllProducts());
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(ProductForm form) throws IOException {
    productsService.addProduct(form);
    return "redirect:/products";
    }

    @PostMapping("/products/{product-id}/delete")
    public String deleteProduct(@PathVariable("product-id") Integer productId) {
        productsService.deleteProduct(productId);
        return "redirect:/products";
    }


    @GetMapping("products/{product-id}")
    public String getProductPage(Model model, @PathVariable("product-id") Integer productId) {
        Product product = productsService.getProduct(productId);
        model.addAttribute("product", product);
        return "product";
    }
    @PostMapping("/product-add")
    public String productAdd(ProductForm productForm) throws IOException {
        productsService.addProduct(productForm);
        return "redirect:/product-add";
    }

    @PostMapping("/products/{product-id}/update")
    public String productUpdate(ProductForm productForm, @PathVariable("product-id") Integer productId) {
        productsService.updateProduct(productForm, productId);
        return "redirect:/products";
    }
}
