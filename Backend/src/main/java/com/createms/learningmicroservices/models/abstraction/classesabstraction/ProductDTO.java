package com.createms.learningmicroservices.models.abstraction.classesabstraction;


import java.util.Objects;

/* This class represents example of DTO (in this case it's only for learning purposes. That way we hide the id from user +
use it for our shopping cart in the future) */

public class ProductDTO {

    protected String name;

    protected Double price;

    protected String type;

    public ProductDTO(String name, Double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public ProductDTO(Product product) {
        this.name = product.name;
        this.price = product.getPrice();
    }

    public ProductDTO() {
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


    public String getType() {
        return type;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type);
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
