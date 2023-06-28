package com.createms.learningmicroservices.models.abstraction.classesabstraction;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

//since a lot of products have the same attributes, it's a good idea to create an abstract class with all those attributes
@Entity
@Table(name = "Products")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = false, nullable = false)
    protected Long id;

    @Column(name = "name")
    @Size(min = 2, max = 45, message = "Name length must be between 2 and 45")
    @Pattern(regexp = "[a-zA-Z\\s]", message = "Name can only contain letters and spaces")
    @NotNull(message = "Name of the product can't be null!")
    @NotBlank(message = "Name of the product can't be blank!")
    protected String name;


    @Column(name = "price")
    @NotNull(message = "Price of the product can't be null")
    @DecimalMin(value = "1.00", message = "Price can't be less than 1")
    @DecimalMax(value = "9999.00", message = "Price can't be bigger than 9999.0")
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
