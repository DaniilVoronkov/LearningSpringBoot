package com.createms.learningmicroservices.models.tables;

import com.createms.learningmicroservices.models.abstraction.Product;
import jakarta.persistence.*;
import com.createms.learningmicroservices.models.enums.TeaType;


import java.util.Objects;

@Entity
public class Tea extends Product {



    @Column(length = 2000)
    private String name;

    @Column
    @Enumerated
    private TeaType teaType;

    @Column
    private Double teaPrice;

    public Tea(String name, TeaType teaType, Double teaPrice) {
        this.name = name;
        this.teaType = teaType;
        this.teaPrice = teaPrice;
    }


    public Tea() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    public Double getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(Double teaPrice) {
        this.teaPrice = teaPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tea tea = (Tea) o;
        return  Objects.equals(name, tea.name) && teaType == tea.teaType && Objects.equals(teaPrice, tea.teaPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teaType, teaPrice);
    }

    @Override
    public String toString() {
        return "Tea{" +
                ", name='" + name + '\'' +
                ", teaType=" + teaType +
                ", teaPrice=" + teaPrice +
                '}';
    }
}
