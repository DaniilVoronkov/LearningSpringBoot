package main.models.abstraction.controllers;


import main.models.abstraction.classesabstraction.Product;
import main.models.abstraction.classesabstraction.ProductDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//since most of the products will have common functionality, it makes sense to have some methods in the interface as the blueprint
public interface ProductController <T extends Product> {
    List<T> getAllProducts();

    T getProduct(@PathVariable Long id);

    void deleteProductById(Long id);

    void editProduct(ProductDTO productDTO, Long id);

    void addProduct(ProductDTO productDTO);

}
