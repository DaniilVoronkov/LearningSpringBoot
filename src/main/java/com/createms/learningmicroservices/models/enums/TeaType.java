package com.createms.learningmicroservices.models.enums;

import com.createms.learningmicroservices.models.abstraction.ProductType;

public enum TeaType implements ProductType {

    //names
    PACKAGED, LOOSE;
    //label for tea that is translated version of name
    private final String teaLabel;

    //initializing label in constructor
    TeaType() {
        if(this.name().equals("PACKAGED")) {
            this.teaLabel = "в пакетиках";
        } else {
            this.teaLabel = "рассыпной";
        }
    }

    //getter for the label
    @Override
    public String getLabel() {
        return teaLabel;
    }
}
