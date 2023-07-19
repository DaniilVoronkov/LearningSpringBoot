package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository <T extends Product> extends CrudRepository<T, Long> {

}
