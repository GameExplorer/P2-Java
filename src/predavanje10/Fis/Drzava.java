package predavanje10.Fis;

public class Drzava {

    String kratica;
    String glavnoMesto;
    int prebivalci;

    Drzava(String kratica, String glavnoMesto, int prebivalci) {
        this.kratica = kratica;
        this.glavnoMesto = glavnoMesto;
        this.prebivalci = prebivalci;
    }

    public String toString() {
        return String.format("Drzava: " + kratica + ", Glavno mesto: " + glavnoMesto + ", St. Prebivalcev: " + prebivalci);
    }
}
