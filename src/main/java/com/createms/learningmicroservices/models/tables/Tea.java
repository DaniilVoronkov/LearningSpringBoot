package com.createms.learningmicroservices.models.tables;

import com.createms.learningmicroservices.models.abstraction.Product;
import jakarta.persistence.*;
import com.createms.learningmicroservices.models.enums.TeaType;


import java.util.Objects;

@Entity
public class Tea extends Product {

    @Column
    @Enumerated
    private TeaType teaType;

    public Tea(String name, TeaType teaType, Double teaPrice) {
        this.name = name;
        this.teaType = teaType;
        this.price = teaPrice;
    }

    public Tea() {
    }

    public TeaType getTeaType() {
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
                ", name='" + name + '\'' +
                ", teaType=" + teaType +
                ", teaPrice=" + price +
                '}';
    }
}
