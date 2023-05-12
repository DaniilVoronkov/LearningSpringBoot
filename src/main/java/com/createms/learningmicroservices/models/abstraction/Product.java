package com.createms.learningmicroservices.models.abstraction;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Product {

    @Id
    @Column(length = 2000)
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
}
