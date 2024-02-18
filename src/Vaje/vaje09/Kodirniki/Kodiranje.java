package vaje09.Kodirniki;

public class Kodiranje{
    Kodirniki kodirniki;

    public Kodiranje(Kodirniki kodirniki) {
        this.kodirniki = kodirniki;
    }

    public String zakodiranjeBesedila(String besedilo) {
        kodirniki.ponastavi(); // na začetku ponastaviš kodirnik
        StringBuilder sb = new StringBuilder();
        char c;
        for(int i = 0; i < besedilo.length(); i++) {
            c = (char) kodirniki.zakodiraj(besedilo.charAt(i));
            sb.append(c);
        }
        return sb.toString();
    }

    public String odkodiranjeBesedila(String besedilo) {
        kodirniki.ponastavi();
        StringBuilder sb = new StringBuilder();
        char c;
        for(int i = 0; i < besedilo.length(); i++) {
            c = (char) kodirniki.odKodiraj(besedilo.charAt(i));
            sb.append(c);
        }
        return sb.toString();
    }
}
