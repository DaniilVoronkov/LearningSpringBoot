package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.abstraction.repositories.ProductRepository;
import com.createms.learningmicroservices.models.tables.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long>, ProductRepository {
}
