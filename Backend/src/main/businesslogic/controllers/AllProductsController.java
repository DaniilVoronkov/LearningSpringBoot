package main.businesslogic.controllers;


import main.businesslogic.services.AllProductsService;
import main.models.abstraction.classesabstraction.Product;
import main.models.repositories.ProductsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllProductsController <T extends Product> {
    private final AllProductsService<T> productsService;

    public AllProductsController(AllProductsService<T> productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/AllProducts")
    public List<T> getAllProducts() {
        return productsService.getAllPossibleProducts();
    }

    @GetMapping("/ProductsWithGivenName")
    public List<ProductsRepository.ProductNames> getAllProductsWithGivenName(@RequestBody String name) {
        return productsService.findAllProductsThatContainsGivenName(name);
    }
}
