package com.createms.learningmicroservices.models.enums;

import com.createms.learningmicroservices.models.abstraction.enumsabstraction.ProductType;
import com.fasterxml.jackson.annotation.JsonValue;


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
