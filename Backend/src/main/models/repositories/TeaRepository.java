package main.models.repositories;

import jakarta.transaction.Transactional;
import main.models.abstraction.repositories.ProductDefaultsMethods;
import main.models.enums.TeaType;
import main.models.tables.Tea;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeaRepository extends CrudRepository<Tea, Long>, ProductDefaultsMethods {

    //update query method
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Transactional
    @Query("UPDATE Tea SET name = :name, price = :price, teaType = :type WHERE id = :id")
    void update(@Param("id") long productId ,@Param("name") String newName, @Param("price") double newPrice, @Param("type") TeaType type);

    @Override
    Tea findByName(String name);

    @Override
    Tea deleteByName(String name);


    List<Tea> findByNameLike(String pattern);

    @Override
    Tea deleteById(Integer id);


}
