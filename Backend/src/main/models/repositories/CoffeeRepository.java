package main.models.repositories;


import main.models.abstraction.repositories.ProductDefaultsMethods;
import main.models.tables.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, Long>, ProductDefaultsMethods {
}
