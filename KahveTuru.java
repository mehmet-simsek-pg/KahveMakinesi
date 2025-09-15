package KahveMakinesi;

public enum KahveTuru {
    AMERICANO("Americano"),
    ESPRESSO("Espresso"),
    CAPPUCINO("Cappucino"),
    ICELATTE("IceLatte"),
    MOCHA("Mocha"),
    MACCHIATO("Macchiato"),
    FRAPPUCCINO("Frappuccino"),
    COLDBREW("Coldbrew"),
    TURKKAHVESI("TurkKahvesi");

    private String kahveTuru;


    KahveTuru(String kahveTuru) {
        this.kahveTuru = kahveTuru;
    }

    public String getKahveTuru() {
        return kahveTuru;
    }


    public boolean sogukMu(){
        return switch (this) {
            case FRAPPUCCINO, ICELATTE, COLDBREW -> true;
            default -> false;
        };
    }

}
