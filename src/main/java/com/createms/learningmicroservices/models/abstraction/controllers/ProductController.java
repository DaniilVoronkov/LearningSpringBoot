package com.createms.learningmicroservices.models.abstraction.controllers;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//since most of the products will have common functionality, it makes sense to have some methods in the interface as the blueprint
public interface ProductController <T extends Product> {
    List<T> getAllProducts();

    T getProduct(@PathVariable Long id);

    ResponseEntity deleteProductById(Long id);

    void editProduct(ProductDTO productDTO, Long id);

    void addProduct(ProductDTO productDTO);

}
