package models.enums;

public enum TeaType {

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
    public String getTeaLabel() {
        return teaLabel;
    }
}
