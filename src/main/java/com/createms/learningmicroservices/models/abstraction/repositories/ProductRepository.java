package com.createms.learningmicroservices.models.abstraction.repositories;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import com.createms.learningmicroservices.models.tables.Tea;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product findByName(String name);

    Product deleteByName(String name);

    Product deleteById(Integer id);

}
