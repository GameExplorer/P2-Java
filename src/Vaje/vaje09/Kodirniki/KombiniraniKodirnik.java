package vaje09.Kodirniki;

import java.util.Random;

/**
 * Implementira več kodirnikov za boljše šifriranje
 */
public class KombiniraniKodirnik implements Kodirniki{
    private Kodirniki[] kodirniki;
    private long seme;
    private Random rnd;

    // Konstruktor
    public KombiniraniKodirnik(Kodirniki[] kodirniki, long seme) {
        this.kodirniki = kodirniki;
        this.seme = seme;
        rnd = new Random(seme);
    }

    // Zakodira zašifrirano besedilo
    public int zakodiraj(int vrednost) {
        int ind = rnd.nextInt(kodirniki.length);
        Kodirniki k = kodirniki[ind];
        return k.zakodiraj(vrednost);
    }

    // Odkodira zašifrirano besedilo
    public int odKodiraj(int vrednost) { return kodirniki[rnd.nextInt(kodirniki.length)].odKodiraj(vrednost); }

    public void ponastavi() {
        //ponastavi generator naključnih števil
        rnd = new Random(seme);
        //ponastavi vse kodirnike
        for(Kodirniki k : kodirniki) {
            k.ponastavi();
        }
    }
}
