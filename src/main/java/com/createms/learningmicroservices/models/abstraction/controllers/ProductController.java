package com.createms.learningmicroservices.models.abstraction.controllers;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import org.springframework.ui.Model;

//since most of the products will have common functionality, it makes sense to have some methods in the interface as the blueprint
public interface ProductController {
    String getAllProducts(Model model);

    String getAddProductPage(Model model);

    void deleteProductById(Long id);

    String getEditProductPage(Long id, Model model);

    String editProduct(ProductDTO productDTO, Long id);

    void addProduct(ProductDTO productDTO);

}
