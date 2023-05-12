package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.tables.Tea;
import org.springframework.data.repository.CrudRepository;

public interface TeaRepository extends CrudRepository<Tea, Long> {
}
