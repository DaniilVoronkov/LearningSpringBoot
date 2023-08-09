package models.repositories;

import models.abstraction.repositories.ProductRepository;
import models.enums.TeaType;
import models.tables.Tea;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeaRepository extends CrudRepository<Tea, Long>, ProductRepository  {

    //update query method
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Transactional
    @Query("UPDATE Tea SET name = :name, price = :price, teaType = :type WHERE id = :id")
    void update(@Param("id") long productId ,@Param("name") String newName, @Param("price") double newPrice, @Param("type")TeaType type);

    @Override
    Tea findByName(String name);

    @Override
    Tea deleteByName(String name);


    List<Tea> findByNameLike(String pattern);

    @Override
    Tea deleteById(Integer id);


}
