package main.models.tables;


import jakarta.persistence.*;
import main.models.abstraction.classesabstraction.Product;
import main.models.enums.CoffeeType;

import java.util.Objects;

@Table(name = "coffeeproducts")
@Entity
@PrimaryKeyJoinColumn(name = "Id")
public class Coffee extends Product {

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private CoffeeType coffeeType;

    public Coffee(String name, CoffeeType coffeeType, Double coffeePrice) {
        super(name, coffeePrice);
        this.coffeeType = coffeeType;
    }

    public Coffee() {
        super();
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return coffeeType == coffee.coffeeType && Objects.equals(getPrice(), coffee.getPrice())
                && Objects.equals(this.name, coffee.name) && Objects.equals(this.id, coffee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeType, getPrice(), this.name);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "Id: " + id +
                ", coffeeType=" + coffeeType +
                ", coffeePrice=" + getPrice() +
                ", name='" + name +
                ", class=" + className +
                '}';
    }
}
