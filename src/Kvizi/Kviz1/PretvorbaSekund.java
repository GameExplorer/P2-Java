package Kviz1;

public class PretvorbaSekund {
    public static void main(String[] args) {
        pretvoriSekunde(6009);
    }
    private static String pretvoriSekunde(int sekunde) {
        if(sekunde < 0) {
            return "Število sekund ne more biti negativno";
        }

        else {
            int min = 0;
            int ure = sekunde / 3600;
            int sek = sekunde % 3600;
            if(sek > 60) {
                min = sek / 60;
            }
            sek = sek % 60;
            return System.out.printf("%02d:%02d:%02d", ure, min, sek).toString();
        }
    }
}