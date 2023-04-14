package predavanje09;

/**
 * Iz razreda Knjiga izpeljani razred, ki ima poleg podedovanih atributov
 * in emtod daodane lastne atribue (stIdx in indeks) ter metode (dodajIndeks) in implementirano
 * abstraktno metodo getPodrobnosti();
 */
public class StrokovnaKnjiga extends Knjiga {
    private static int maxIndeks = 10; //maksimalno število indeksov
    int stIdx; //stevilo vpisov v tabeli indeks
    String[] indeks;

    public StrokovnaKnjiga() {}


    StrokovnaKnjiga(String avtor, String naslov, int letoIzdaje) {
        super(avtor, naslov, letoIzdaje);

        indeks = new String[maxIndeks];
        stIdx = 0;
    }

    void dodajIndeks(String indeks) {
        if(stIdx < maxIndeks) {
            this.indeks[this.stIdx++] = indeks;
        }
    }

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
