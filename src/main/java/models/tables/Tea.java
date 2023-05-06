package models.tables;

import jakarta.persistence.*;
import models.enums.TeaType;


import java.util.Objects;

@Entity
public class Tea {

    @Id
    @GeneratedValue
    private Long teaId;

    @Column(length = 2000)
    private String name;

    @Column
    @Enumerated
    private TeaType teaType;

    @Column
    private Double teaPrice;

    public Tea(Long teaId, String name, TeaType teaType, Double teaPrice) {
        this.teaId = teaId;
        this.name = name;
        this.teaType = teaType;
        this.teaPrice = teaPrice;
    }


    public Tea() {

    }

    public Long getId() {
        return teaId;
    }

    public void setId(Long id) {
        this.teaId = id;
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
        return Objects.equals(teaId, tea.teaId) && Objects.equals(name, tea.name) && teaType == tea.teaType && Objects.equals(teaPrice, tea.teaPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teaId, name, teaType, teaPrice);
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id=" + teaId +
                ", name='" + name + '\'' +
                ", teaType=" + teaType +
                ", teaPrice=" + teaPrice +
                '}';
    }
}
