package ru.pcs.web.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pcs.web.forms.ProductForm;
import ru.pcs.web.models.Product;

import java.util.List;
@Transactional
@Service
public interface ProductsService {
    void addProduct(ProductForm form);
    List<Product> getAllProducts();
    void deleteProduct(Integer productId);

    Product getProduct(Integer productId);

    void updateProduct(ProductForm form);
}
