package kviz2;

public class PreveriRep {
    public static void main(String[] args) {
        boolean rez = preveriRep("DAN", "Dan na Dan");
        System.out.println(rez);
    }

    public static boolean preveriRep(String a, String b) {
        // pretvorimo nize v mala črka, da ignoriramo razliko v velikosti črk
        String aLower = a.toLowerCase();
        String bLower = b.toLowerCase();

        // preverimo, če je dolžina niza b krajša ali enaka dolžini niza a
        // v tem primeru niza b ne more biti končni podniz niza a
        if (bLower.length() <= aLower.length()) {
            return false;
        }

        // poiščemo indeks začetka zadnjega pojavljanja niza b v nizu a
        // če se niz b ne pojavi v nizu a, metoda lastIndexOf vrne -1
        int startIndex = aLower.lastIndexOf(bLower);

        // preverimo, ali se niz b pojavlja na koncu niza a
        return startIndex == aLower.length() - bLower.length();
    }


}
