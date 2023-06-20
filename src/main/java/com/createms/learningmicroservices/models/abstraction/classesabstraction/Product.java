package com.createms.learningmicroservices.models.abstraction.classesabstraction;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

//since a lot of products have the same attributes, it's a good idea to create an abstract class with all those attributes
@MappedSuperclass
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = false, nullable = false)
    protected Long id;

    protected String name;

    protected Double price;



    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double coffeePrice) {
        this.price = coffeePrice;
    }

    public Long getId() {
        return id;
    }

    //getting
    public String getClassName() {
       return this.getClass().getSimpleName();
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
