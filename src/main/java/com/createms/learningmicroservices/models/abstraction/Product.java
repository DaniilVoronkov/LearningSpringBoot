package com.createms.learningmicroservices.models.abstraction;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 2000)
    public String name;
    @Column
    protected Double price;

    public Product(String name, Double price, Long id) {
        this.name = name;
        this.price = price;
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
