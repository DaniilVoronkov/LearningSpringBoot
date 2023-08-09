package models.repositories;

import models.abstraction.repositories.ProductRepository;
import models.tables.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long>, ProductRepository {
}
