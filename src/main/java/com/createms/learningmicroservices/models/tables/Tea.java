package com.createms.learningmicroservices.models.tables;

import com.createms.learningmicroservices.models.abstraction.classesabstraction.Product;
import com.createms.learningmicroservices.models.abstraction.classesabstraction.ProductDTO;
import jakarta.persistence.*;
import com.createms.learningmicroservices.models.enums.TeaType;
import org.hibernate.validator.constraints.Length;


import java.util.Objects;

@Table(name="teaproducts")
@Entity
@AttributeOverride(name = "name", column = @Column(name = "teaname"))
@AttributeOverride(name = "price", column = @Column(name = "teaprice"))
public class Tea extends Product {

    @Column(name = "teatype")
    @Enumerated(EnumType.STRING)
    private TeaType teaType;

    public Tea(String name, TeaType teaType, Double teaPrice) {
        this.name = name;
        this.teaType = teaType;
        this.price = teaPrice;
    }

    public Tea(ProductDTO productDTO) {
        this.name = productDTO.getName();
        this.teaType = TeaType.getType(productDTO.getType());
        this.price = productDTO.getPrice();

    }

    public Tea() {
    }

    public TeaType getType() {
        return teaType;
    }
    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea tea = (Tea) o;
        return  Objects.equals(name, tea.name) && teaType == tea.teaType && Objects.equals(price, tea.price) && Objects.equals(id, tea.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, teaType, price);
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id= " + id +
                " name='" + name + '\'' +
                ", teaType=" + teaType +
                ", teaPrice=" + price +
                '}';
    }
}
