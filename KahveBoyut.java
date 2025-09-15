package KahveMakinesi;

public enum KahveBoyut {
    TALL("Tall"),
    GRANDE("Grande"),
    VENTI("Venti"),
    TRENTA("Trenta");

    private String boyut;


    KahveBoyut(String boyut) {
        this.boyut = boyut;
    }

    public String getBoyut() {
        return boyut;
    }


}
