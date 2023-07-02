package com.createms.learningmicroservices.models.enums;

import com.createms.learningmicroservices.models.abstraction.enumsabstraction.ProductType;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

public enum TeaType implements ProductType {

    //names
    PACKAGED("In packages"), LOOSE("Tea leafs");
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



    //getting the type by name (to connect with DTO)
    public static TeaType getType(String type) {
        for(TeaType type1 : TeaType.values()) {
            if(type1.teaLabel.equals(type)) {
                return type1;
            }
        }
        return null;
    }

    public static boolean containsLabel(String label) {
        for(TeaType type : TeaType.values()) {
            if(type.getLabel().equals(label)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getAllLabels() {
        List<String> labels = new ArrayList<>();
        stream(TeaType.values()).forEach(elem -> labels.add(elem.getLabel()));
        return labels;
    }



}
