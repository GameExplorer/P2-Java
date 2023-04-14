package predavanje09;

/**
 * Podrazred razreda Oseba z redefinirano metodo izpisi()
 */
public class Clovek extends Oseba {
    //@override prepiše metodo
    void izpis() {
        super.izpis(); //kličem metodo iz svojega očeta izpiše ime: ime
        System.out.println("Ime človek: " + ime); //lahko spremenimo izpis razreda človeka
    }
}
