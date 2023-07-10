package com.createms.learningmicroservices.models.enums;

import com.createms.learningmicroservices.models.abstraction.enumsabstraction.ProductType;


public enum CoffeeType implements ProductType {
    //names
    GRINDED, INSTANT, ORIGINAL ;

    //label for tea that is translated version of name
    private final String coffeeLabel;

    //initializing label in constructor
    CoffeeType() {
        switch (this.name().toUpperCase()) {
            case "GRINDED":
                coffeeLabel = "Grinded";
                break;
            case "INSTANT":
                coffeeLabel = "Instant";
                break;
            case "ORIGINAL":
                coffeeLabel = "Original";
                break;
            default:
                coffeeLabel = "";
                break;
        }
    }

    //getter for the label
    @Override
    public String getLabel() {
        return coffeeLabel;
    }



}
