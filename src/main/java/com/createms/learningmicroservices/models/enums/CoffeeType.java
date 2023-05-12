package com.createms.learningmicroservices.models.enums;

public enum CoffeeType {
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

    public String getCoffeeLabel() {
        return coffeeLabel;
    }
}
