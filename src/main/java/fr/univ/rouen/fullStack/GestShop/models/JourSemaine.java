package fr.univ.rouen.fullStack.GestShop.models;

public enum JourSemaine {

    LUNDI(1, "Lundi"),
    MARDI(2, "Mardi"),
    MERCREDI(3, "Mercredi"),
    JEUDI(4, "Jeudi"),
    VENDREDI(5, "Vendredi"),
    SAMEDI(6 ,"Samedi"),
    DIMANCHE(7 ,"Dimanche");

    private int dayValue;
    private String dayName;

    JourSemaine() {
    }

    JourSemaine(int dayValue, String dayName) {
        this.dayName = dayName;
        this.dayValue = dayValue;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getDayValue() {
        return dayValue;
    }

    public void setDayValue(int dayValue) {
        this.dayValue = dayValue;
    }
}
