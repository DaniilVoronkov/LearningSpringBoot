package models.abstraction.repositories;

import models.abstraction.classesabstraction.Product;

public interface ProductRepository {
    Product findByName(String name);

    Product deleteByName(String name);

    Product deleteById(Integer id);

}
