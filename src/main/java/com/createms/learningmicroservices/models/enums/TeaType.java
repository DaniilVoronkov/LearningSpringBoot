package com.createms.learningmicroservices.models.enums;

import com.createms.learningmicroservices.models.abstraction.enumsabstraction.ProductType;
import com.createms.learningmicroservices.models.tables.Tea;

public enum TeaType implements ProductType {

    //names
    PACKAGED("в пакетиках"), LOOSE("рассыпной");
    //label for tea that is translated version of name
    private final String teaLabel;

    //initializing label in constructor

    TeaType(String label) {
        this.teaLabel = label;
    }

    //getter for the label
    @Override
    public String getLabel() {
        return teaLabel;
    }

    public TeaType getType(String type) {
        for(TeaType type1 : TeaType.values()) {
            if(type1.teaLabel.equals(type)) {
                return type1;
            }
        }
        return null;
    }


}
