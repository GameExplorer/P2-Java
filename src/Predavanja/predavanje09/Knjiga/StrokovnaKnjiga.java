package Predavanja.predavanje09.Knjiga;

/**
 * Iz razreda Knjiga izpeljani razred, ki ima poleg podedovanih atributov
 * in metod daodane lastne atribute (stIdx in indeks) ter metode (dodajIndeks) in implementirano
 * abstraktno metodo getPodrobnosti();
 */
public class StrokovnaKnjiga extends Knjiga {
    private static int maxIndeks = 10; //maksimalno število indeksov
    int stIdx; //stevilo vpisov v tabeli indeks
    String[] indeks;

    public StrokovnaKnjiga() {}


    StrokovnaKnjiga(String avtor, String naslov, int letoIzdaje) {
        super(avtor, naslov, letoIzdaje); //super da ne bi ponovno pisali this.avtor = avtor ...

        indeks = new String[maxIndeks];
        stIdx = 0;
    }

    // Dodajamo indeks
    void dodajIndeks(String indeks) {
        if(stIdx < maxIndeks) {
            this.indeks[this.stIdx++] = indeks;
        }
    }

    // ABSTRAKTNA METODA
    @Override
    String getPodrobnosti() {
        StringBuffer podrobnosti = new StringBuffer();
        podrobnosti.append("INDEKS: \n");

        for(int i = 0; i < this.stIdx; i++) {
            podrobnosti.append(indeks[i] + "\n");
        }
        return podrobnosti.toString();
    }
}
