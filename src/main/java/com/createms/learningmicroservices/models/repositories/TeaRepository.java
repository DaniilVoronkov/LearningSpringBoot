package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.abstraction.repositories.ProductRepository;
import com.createms.learningmicroservices.models.enums.TeaType;
import com.createms.learningmicroservices.models.tables.Tea;
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
    @Query("update Tea set name = :name, price = :price, teaType = :type where id = :id")
    void update(@Param("id") long productId ,@Param("name") String newName, @Param("price") double newPrice, @Param("type")TeaType type);

    @Override
    Tea findByName(String name);

    @Override
    Tea deleteByName(String name);


    List<Tea> findByNameLike(String pattern);

    @Override
    Tea deleteById(Integer id);


}
