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
    };

    @PostMapping("/product")
    public String addProduct(ProductForm form) {
        productsService.addProduct(form);
        return "redirect:/products";
    };

    @PostMapping("/products/{product-id}/delete")
        public String deleteProduct(@PathVariable("product-id") Integer productId) {
        productsService.deleteProduct(productId);
        return "redirect:/products";
        };


//    @GetMapping("/products/{product-id}")
//    public String getProductPage(Model model, @PathVariable("product-id") Integer productId) {
//        Product product = productService.getProduct(productId);
//        model.addAttribute("product", product);
//        return "product";

//    };
//    @PostMapping("/products/{product-id}/update")
//    public String updateProduct(ProductForm form, @PathVariable("product-id") String parameter) {
//        productService.updateProduct(form);
//        return "redirect:/products";
//    };


}
