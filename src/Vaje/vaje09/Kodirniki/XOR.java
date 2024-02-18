package vaje09.Kodirniki;

public class XOR implements Kodirniki{

    private String geslo; //geslo s katerim kodiramo
    private int index; // stanje kodirnika (kateri znak uporabimo za XOR)

    public XOR(String geslo) {
        this.geslo = geslo;
        this.index = 0; //začetno stanje kodirnika je 0 (kodiranje začnemo s prvim stanjem)
    }

    public int zakodiraj(int vrednost) {
        int rezultat = vrednost ^ geslo.charAt(index);
        index = (index + 1) % geslo.length(); //spremeni stanje kodirnika naslednji znak gesla
        return rezultat;
    }

    public int odKodiraj(int vrednost) {
        return zakodiraj(vrednost);
    }

    public void ponastavi() { this.index = 0; } //kodirnik nastavi na začetno stanje
}
