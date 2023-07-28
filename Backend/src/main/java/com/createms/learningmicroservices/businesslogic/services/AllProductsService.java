package com.createms.learningmicroservices.businesslogic.services;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import com.createms.learningmicroservices.models.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  AllProductsService <T extends Product> {

    private final ProductsRepository <T> productsRepository;

    public AllProductsService(ProductsRepository <T> productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<T> getAllPossibleProducts() {
        System.out.println(productsRepository.findAll());
        return (List<T>) productsRepository.findAll();
    }

    public List<ProductsRepository.ProductNames> findAllProductsThatContainsGivenName(String name) {
        return productsRepository.findByNameContainsIgnoreCase(name);
    }
}
