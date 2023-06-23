package com.createms.learningmicroservices.models.abstraction.repositories;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;

public interface ProductRepository {
    Product findByName(String name);

    Product deleteByName(String name);

    Product deleteById(Integer id);

}
