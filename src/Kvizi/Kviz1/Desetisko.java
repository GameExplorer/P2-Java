package Kviz1;

public class Desetisko {
    public static void main(String[] args) {
        vDesetisko(120);
    }
    private static void vDesetisko(int n) {
        int originalnoStevilo = n;
        int desetisko = 0;
        int faktor = 1;

        while (n != 0) {
            int stevka = n % 10;
            if (stevka >= 8) {
                System.out.printf("Število %d ni število v osmiškem sistemu (števka %d)", originalnoStevilo, stevka);
                return;
            }
            desetisko += faktor * stevka;
            faktor *= 8;
            n /= 10;
        }

        System.out.printf("%d(8) = %d(10)", originalnoStevilo, desetisko);
    }

}
