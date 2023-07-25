package com.createms.learningmicroservices.models.repositories;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

public interface ProductsRepository <T extends Product> extends CrudRepository<T, Long> {

    //interface projection example
//    interface ProductNames {
//        String getName();
//        Long getId();
//
//        default String getData() {
//            return getName() + " " + getId();
//        }
//
//    }

    @Projection(name = "idPlusName", types = {Product.class})
    class ProductNameAndId {
        private final Long id;
        private final String name;

        public ProductNameAndId(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        //For testing purposes
        @Override
        public String toString() {
            return "ProductNameAndId{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    //finding product that contains given string and returning list with id + name objects
    List<ProductNameAndId> findByNameContains(String name);
}
