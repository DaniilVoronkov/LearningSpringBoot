package main.models.tables;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import main.models.abstraction.classesabstraction.Product;
import main.models.abstraction.classesabstraction.ProductDTO;
import main.models.enums.TeaType;

import java.util.Objects;

@Table(name="teaproducts")
@Entity
@PrimaryKeyJoinColumn(name = "Id")
public class Tea extends Product {

    @Column(name = "teatype")
    @Enumerated(EnumType.STRING)
    private TeaType teaType;

    public Tea(String name, TeaType teaType, Double teaPrice) {
        super(name, teaPrice);
        this.teaType = teaType;
    }

    public Tea(ProductDTO productDTO) {
        super(productDTO.getName(), productDTO.getPrice());
        this.teaType = TeaType.getType(productDTO.getType());
    }

    public Tea() {
    }

    @JsonProperty(value = "teaType", access = JsonProperty.Access.READ_ONLY)
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
                ", class=" + className +
                '}';
    }
}
