package com.createms.learningmicroservices.models.abstraction.classesabstraction;

import jakarta.persistence.*;

//since a lot of products have the same attributes, it's a good idea to create an abstract class with all those attributes
@MappedSuperclass
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected Long id;

    @Column(length = 2000, unique = true)
    protected String name;
    @Column
    protected Double price;



    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
