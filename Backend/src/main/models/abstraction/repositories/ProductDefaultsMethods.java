package main.models.abstraction.repositories;


import main.models.abstraction.classesabstraction.Product;

public interface ProductDefaultsMethods {
    Product findByName(String name);

    Product deleteByName(String name);

    Product deleteById(Integer id);

}
