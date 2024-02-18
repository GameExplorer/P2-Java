package vaje11.Izjeme;

/**
 * Zajema preverljive izjeme pri delu z datotekami.
 */
public class IzjemaDatoteka extends Exception {
    public IzjemaDatoteka(String sporocilo) {
        super(sporocilo);
    }
}
