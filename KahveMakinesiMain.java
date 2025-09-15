package KahveMakinesi;

import java.util.Scanner;

public class KahveMakinesiMain{


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KahveIsleyici kahveIsleyici = new KahveIsleyici(scanner);

        KahveTuru kahveTuru = null;
        int secim;
        do {
            System.out.println("Lütfen bir kahve seçiniz (1-9)");
            System.out.println("----------MENU----------");
            System.out.println("1. Americano");
            System.out.println("2. Espresso");
            System.out.println("3. Capuccino");
            System.out.println("4. IceLatte");
            System.out.println("5. Mocha");
            System.out.println("6. Macchiato");
            System.out.println("7. Frappucino");
            System.out.println("8. Coldbrew");
            System.out.println("9. Türk Kahvesi");
            System.out.println("Çıkış için 0 basın");

            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1 -> kahveTuru = KahveTuru.AMERICANO;
                case 2 -> kahveTuru = KahveTuru.ESPRESSO;
                case 3 -> kahveTuru = KahveTuru.CAPPUCINO;
                case 4 -> kahveTuru = KahveTuru.ICELATTE;
                case 5 -> kahveTuru = KahveTuru.MOCHA;
                case 6 -> kahveTuru = KahveTuru.MACCHIATO;
                case 7 -> kahveTuru = KahveTuru.FRAPPUCCINO;
                case 8 -> kahveTuru = KahveTuru.COLDBREW;
                case 9 -> kahveTuru = KahveTuru.TURKKAHVESI;
                case 0 -> System.out.println("Çıkış yapılıyor...");
                default -> System.out.println("Geçersiz Seçim. Lütfen tekrar deneyin");
            }
        } while (secim != 0 && kahveTuru == null);

        if (secim == 0) {
            scanner.close();
            return;
        }
        System.out.println(kahveTuru.getKahveTuru() + " seçtiniz...");

        if (kahveTuru.sogukMu()) {
            System.out.println("Sıcak bir yaz gününde serinlemenin en iyi yolu… Mükemmel karar!");
        }
        System.out.println("Lütfen kahvenizin boyutunu seçiniz: Tall / Grande / Venti / Trenta");
        String boyutSecim = scanner.nextLine().trim().toLowerCase();
        KahveBoyut boyut;
        switch (boyutSecim) {
            case "tall" -> boyut = KahveBoyut.TALL;
            case "grande" -> boyut = KahveBoyut.GRANDE;
            case "venti" -> boyut = KahveBoyut.VENTI;
            case "trenta" -> boyut = KahveBoyut.TRENTA;
            default -> boyut = KahveBoyut.GRANDE;
        };
        System.out.println(boyut.getBoyut() + " " + kahveTuru.getKahveTuru() + " hazırlanıyor...");

        kahveIsleyici.sutEkle();
        kahveIsleyici.sekerOlsunMu();

        System.out.println("--- Sipariş Özeti ---");
        System.out.println(kahveIsleyici.getSekerAdedi() + " şekerli " + boyut.getBoyut() + " " + kahveTuru.getKahveTuru() + " siparişiniz hazırlandı.");

    }

public KahveMakinesiMain(KahveBoyut kahveBoyut, KahveTuru kahveTuru) {
    super();
}
}