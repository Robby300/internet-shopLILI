package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pcs.web.forms.ProductForm;
import ru.pcs.web.models.Product;
import ru.pcs.web.repositories.ProductsRepository;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    @Override
    public void addProduct(ProductForm form) throws IOException {
        Product product = Product.builder()
                .description(form.getDescription())
                .price(form.getPrice())
                .amount(form.getAmount())
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
    public void updateProduct(ProductForm productForm, Integer productId) {
        Product product = productsRepository.getById(productId);
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setAmount(productForm.getAmount());
        productsRepository.save(product);
    }
}
