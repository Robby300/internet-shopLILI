package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.pcs.web.forms.ProductForm;
import ru.pcs.web.models.Product;
import ru.pcs.web.repositories.ProductsRepository;

import java.util.List;
@RequiredArgsConstructor
@Component
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    public void addProduct(ProductForm form) {
        Product product = Product.builder()
                .description(form.getDescription())
                .price(form.getPrice())
                .build();
        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productsRepository.deleteById(productId);
    }

    @Override
    public Product getProduct(Integer productId) {
        return productsRepository.getById(productId);
    }

    @Override
    public void updateProduct(ProductForm form) {
        Product product = Product.builder()
                .description(form.getDescription())
                .price(form.getPrice())
                .amount(form.getAmount())
                .build();
        productsRepository.save(product);
    }
}
