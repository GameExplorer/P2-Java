package predavanje01;

public class Obresti {
    public static void main(String[] args) {
        izracunObresti();
    }
    private static void izracunObresti() {
        int n = 10; //leta
        double glavnica = 1000;
        double obrestna_mera = 5;

        System.out.printf("Glavnica: %.1f \n", glavnica);
        System.out.printf("Število let: %d \n", n);
        System.out.printf("Obrestna mera:  %.1f\n", obrestna_mera);

        double znesek =glavnica * Math.pow((1 + obrestna_mera / 100),n);
        System.out.printf("Končni znesek: %.3f", znesek);
    }
}
