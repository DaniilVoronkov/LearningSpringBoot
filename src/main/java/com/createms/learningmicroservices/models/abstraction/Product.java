package com.createms.learningmicroservices.models.abstraction;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(length = 2000, unique = true)
    public String name;
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

    public Long getId() {        return id;
    }
}
