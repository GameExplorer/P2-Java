package Predavanja.predavanje02;

public class Nizi {
    public static void main(String[] args) {
        String niz = "Moja Emona";

        System.out.println("Dolžina niza: " + niz.length());

        for (int i = 0; i < 4; i++) {
            System.out.println(niz.charAt(i));
        }

        System.out.println("Začni niz od n-tega indeksa: "+ niz.substring(2));
        System.out.println("Indeks črke: " + niz.indexOf("E"));
        System.out.println("Zamenjaj vse: " + niz.replaceAll("a", "i"));
    }
}