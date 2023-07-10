package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.tables.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
}
