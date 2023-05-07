package predavanje11.Fis;

/**
 * Razred s tremi privatnimi atributi (kratica, glavnoMesto in št. prebivalci),
 * z getterji/setterji in primernim konstruktorjem
 */
public class Drzava {

    private String kratica;
    private String glavnoMesto;
    private int prebivalci;

    Drzava(String kratica, String glavnoMesto, int prebivalci) {
        this.kratica = kratica;
        this.glavnoMesto = glavnoMesto;
        this.prebivalci = prebivalci;
    }

    public String getKratica() {
        return kratica;
    }
    public void setKratica(String kratica) {
        this.kratica = kratica;
    }

    public String getGlavnoMesto() {
        return glavnoMesto;
    }
    public void setGlavnoMesto(String glavnoMesto) {
        this.glavnoMesto = glavnoMesto;
    }

    public int getPrebivalc() {
        return prebivalci;
    }

    public void setPrebivalci(int prebivalci) {
        this.prebivalci = prebivalci;
    }
    public String toString() {
        return String.format("Drzava: " + kratica + ", Glavno mesto: " + glavnoMesto + ", St. Prebivalcev: " + prebivalci);
    }
}
