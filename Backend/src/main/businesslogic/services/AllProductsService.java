package main.businesslogic.services;


import main.models.abstraction.classesabstraction.Product;
import main.models.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AllProductsService <T extends Product> {

    private final ProductsRepository<T> productsRepository;

    @Autowired
    public AllProductsService(ProductsRepository<T> productsRepository) {
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
