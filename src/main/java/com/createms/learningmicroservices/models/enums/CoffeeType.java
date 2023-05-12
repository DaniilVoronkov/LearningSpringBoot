package com.createms.learningmicroservices.models.enums;

import com.createms.learningmicroservices.models.abstraction.ProductType;

public enum CoffeeType implements ProductType {
    //names
    GRINDED, INSTANT, ORIGINAL ;
    //label for tea that is translated version of name
    private final String coffeeLabel;

    //initializing label in constructor
    CoffeeType() {
        switch (this.name().toUpperCase()) {
            case "GRINDED":
                coffeeLabel = "Измельченный";
                break;
            case "INSTANT":
                coffeeLabel = "В пакетиках";
                break;
            case "ORIGINAL":
                coffeeLabel = "Зерновой";
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
