package ru.pcs.web.services;

import ru.pcs.web.forms.ProductForm;
import ru.pcs.web.models.Product;

import java.io.IOException;
import java.util.List;


public interface ProductsService {
    void addProduct(ProductForm form) throws IOException;
    List<Product> getAllProducts();
    void deleteProduct(Integer productId);

    Product getProduct(Integer productId);

    void updateProduct(ProductForm productForm, Integer id);
}
