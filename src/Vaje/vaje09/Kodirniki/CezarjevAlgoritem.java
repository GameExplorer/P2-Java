package vaje09.Kodirniki;

// Cezarjev Algoritem
public class CezarjevAlgoritem implements Kodirniki {
    private final int zamik; // ključ šifriranja

    // Konstruktor
    public CezarjevAlgoritem(int zamik) {
        this.zamik = zamik;
    }

    // Šifriranje
    public int zakodiraj(int vrednost) {
        return vrednost + zamik;
    }

    //Dešifriranje
    public int odKodiraj(int vrednost) {
        return vrednost - zamik;
    }

    public void ponastavi() {}
}
