package com.createms.learningmicroservices.models.abstraction.classesabstraction;


import com.createms.learningmicroservices.models.abstraction.enumsabstraction.ProductType;

import java.util.Objects;

//This class represents example of DTO (in this case it's only for learning purposes. That way we hide the id from user + use it for our shopping cart)
public class ProductDTO {

    public String name;

    protected Double price;

    protected ProductType type;

    public ProductDTO(String name, Double price, ProductType type) {
        this.name = name;
        this.price = price;
        this.type = type;
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


    public ProductType getType() {
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
