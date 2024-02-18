package Vaje12;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 *
 */
public class Slika {
    private static final int[] PNG = new int[]{0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};
    private static final int[] JPEG = new int[]{0xFF, 0xD8, 0xFF};
    private static final int[] GIF = new int[]{0x47, 0x49, 0x46, 0x38};

    private String pot;
    private String tip;
    private int sirina;
    private int visina;

    public Slika(String pot, String tip, int sirina, int visina) {
        this.pot = pot;
        this.tip = tip;
        this.sirina = sirina;
        this.visina = visina;
    }

    public Slika(String pot, String tip) {
        this(pot, tip,0,0);
    }

    public String getPot() {
        return pot;
    }

    public int getVelikost() {
        return this.sirina * this.visina;
    }

    public String toString() {
        String velikost = this.sirina != 0 && this.visina != 0 ? String.format(" (%d x %d)", this.sirina, this.visina) : "";

        return String.format("%s: Slika %s%s", this.pot, this.tip, velikost);
    }

    /**
     * Preveri če datoteka ustreza podpisu (tabeli bajtov)
     */

    private static boolean preveriPodpis(String vhodnaDatoteka, int[] podpis) {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(vhodnaDatoteka))) {
            for(int i = 0; i < podpis.length; i++) {
                int bajt = dis.readUnsignedByte();
                if(bajt != podpis[i]) return false;
            }
            return true;
        } catch (Exception e) {
            System.out.printf("Napaka pri branju datoteke %s %n", vhodnaDatoteka);
        }
        return false;
    }

    public static boolean jePNG(String vhodnaDatoteka) {
        return preveriPodpis(vhodnaDatoteka, Slika.PNG);
    }

    public static boolean jeJPEG(String vhodnaDatoteka) {
        return preveriPodpis(vhodnaDatoteka, Slika.JPEG);
    }

    public static boolean jeGIF(String vhodnaDatoteka) {
        return preveriPodpis(vhodnaDatoteka, Slika.GIF);
    }

    public static Slika preberiPNG(String vhodnaDatoteka) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(vhodnaDatoteka))) {
            //preskočimo dolžino in podpis
            dis.skipBytes(8+4+4);
            //readINt() prebere 4 bajte podatkov in jih intepretira kot int
            int sirina = dis.readInt();
            int visina = dis.readInt();
            return new Slika(vhodnaDatoteka, "PNG", sirina, visina);
        } catch (Exception e) {
            System.out.printf("Napaka pri branju datoteke %s %n", vhodnaDatoteka);
        }

        return null;
    }
}
