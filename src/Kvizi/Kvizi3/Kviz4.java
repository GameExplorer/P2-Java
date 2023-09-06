package Kvizi.Kvizi3;

public class Kviz4 {
    public static String najdaljsiPalindrom(String niz, boolean presledki) {
        String palindrom = "";

        for(int i = 1; i < niz.length(); i++) {
            String delNiz = niz.substring(0, i);
            String delNiz2 = niz.substring(i);

            if(delNiz.equals(new StringBuilder(delNiz).reverse().toString())) {
                if(delNiz2.equals(new StringBuilder(delNiz2).reverse().toString())) {
                    palindrom = delNiz;
                }
            }
        }
        return palindrom;
    }
    public static void main(String[] args) {
        String niz = "perica reže raci rep";
        String rez = najdaljsiPalindrom(niz, false);
        System.out.printf("Najdaljši palindrom v nizu '%s' je '%s' %n", niz, rez);
        System.out.printf("Najdaljši palindrom v nizu '%s' je '%s' %n", niz, najdaljsiPalindrom(niz, true));
    }
}
