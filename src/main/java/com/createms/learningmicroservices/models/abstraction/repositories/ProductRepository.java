package com.createms.learningmicroservices.models.abstraction.repositories;

import com.createms.learningmicroservices.models.tables.Tea;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Tea findByName(String name);

    Tea deleteByName(String name);

    List<Tea> findByNameLike(String pattern);

    Tea deleteById(Integer id);

}
