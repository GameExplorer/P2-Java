package kviz3;

public class NajdaljsiPalindrom {
    public static void main(String[] args) {
        String niz = "perica reže raci rep";
        System.out.printf("Najdaljši palindrom v nizu '%s' je '%s' ", niz, najdaljsiPalindrom(niz, true));
    }

    public static String najdaljsiPalindrom(String niz, boolean presledki) {
        String palindrom = "";

        for(int i = 1; i < niz.length(); i++) {
            String x = niz.substring(0, i);
            String y = niz.substring(i);

            if(x.contentEquals(new StringBuilder(x).reverse())) {
                if(y.contentEquals(new StringBuilder(y).reverse())) {
                    palindrom = x;
                }
            }
        }
        return palindrom;
    }
}