package main.models.enums;


import com.fasterxml.jackson.annotation.JsonValue;
import main.models.abstraction.enumsabstraction.ProductType;


public enum CoffeeType implements ProductType {
    //names
    GRINDED, INSTANT, ORIGINAL ;


    @JsonValue
    private final String coffeeLabel;

    //initializing label in constructor
    CoffeeType() {
        coffeeLabel = this.name().toLowerCase();
    }

    CoffeeType(String label) {
        coffeeLabel = label;
    }

    //getter for the label
    @Override
    public String getLabel() {
        return coffeeLabel;
    }



}
