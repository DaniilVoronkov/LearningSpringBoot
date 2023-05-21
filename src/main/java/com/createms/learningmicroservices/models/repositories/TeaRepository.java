package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.abstraction.repositories.ProductRepository;
import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TeaRepository extends CrudRepository<Tea, Long>, ProductRepository  {
}
