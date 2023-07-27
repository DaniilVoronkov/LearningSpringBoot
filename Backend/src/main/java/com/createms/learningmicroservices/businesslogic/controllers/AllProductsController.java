package com.createms.learningmicroservices.businesslogic.controllers;

import com.createms.learningmicroservices.businesslogic.services.AllProductsService;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import com.createms.learningmicroservices.models.repositories.ProductsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllProductsController <T extends Product> {
    private final AllProductsService <T> productsService;

    public AllProductsController(AllProductsService<T> productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/AllProducts")
    public List<T> getAllProducts() {
        return productsService.getAllPossibleProducts();
    }

    @GetMapping("/ProductsWithGivenName")
    public List<ProductsRepository.ProductNameAndId> getAllProducts(@RequestBody String name) {
        return productsService.findAllProductsWithGivenName(name);
    }
}
