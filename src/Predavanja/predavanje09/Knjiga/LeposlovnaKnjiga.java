package Predavanja.predavanje09.Knjiga;

/**
 * Iz razreda Knjiga izpeljani razred, ki ima poleg podedovanih atributov in metod
 * dodane lastne atribute (stMnenj in mnjena) ter metode (dodajMnenje) in implementirano
 * abstraktno metodo getPodrobnosti().
 */
public class LeposlovnaKnjiga extends Knjiga {
    private static int maxMnenj = 10; //maksimalno število mnenj
    int stMnenj; //stevilo mnenj v tabeli index
    String[] mnenjeBralcev;

    public LeposlovnaKnjiga() {}

    LeposlovnaKnjiga(String avtor, String naslov, int letoIzdaje) {
        super(avtor, naslov, letoIzdaje); // pokličemo super, ker bomo uporabili iste podatke

        mnenjeBralcev = new String[maxMnenj];
        stMnenj = 0;
    }

    void dodajMnenje(String mnenje) {
        if(stMnenj < maxMnenj) {
            this.mnenjeBralcev[this.stMnenj++] = mnenje;
        }
    }

    @Override
    String getPodrobnosti() {
        StringBuffer podrobnosti = new StringBuffer();
        podrobnosti.append("Mnenja bralcev: \n");

        for(int i = 0; i < this.stMnenj; i++) {
            podrobnosti.append(mnenjeBralcev[i] + "\n");
        }

        return podrobnosti.toString();
    }

}
