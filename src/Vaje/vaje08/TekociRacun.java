package vaje08;

public class TekociRacun extends Racun {

    private double limit; //omejitev zneska na posamezen dvig

    /**
     * Konstruktor ustvari tekoči račun s podano številko računa, podanim limitom pri dvigu in začetnim stanjem 0€
     * @param stevilka - st. računa
     * @param limit - omojitev zneska pri vsakem dvigu
     */
    public TekociRacun(String stevilka, double limit) {
        super(stevilka);
        this.limit = limit;
    }

    /**
     * Dvigne znesek znesek z računa, če znesek ne presega limita
     * @param znesek - dvignjen znesek, pozitivno število
     * @return true, če je dvig uspešno izveden, sicer false (v primeru neg. zneska ali prekoračitve limita)
     */
    public boolean dvig(double znesek) {
        if(znesek > this.limit) return false;
        return super.dvig(znesek);
    }

    /**
     * Vrne opis računa za tekoči račun
     * @return opis tekečoga računa
     */
    public String opisRacuna() {
        return String.format("tekoči, limit: %.2f%%", this.limit);
    }

}
