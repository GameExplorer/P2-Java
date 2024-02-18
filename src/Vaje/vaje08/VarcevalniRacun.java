package vaje08;

public class VarcevalniRacun extends Racun {
    private double obresti; //obrestna mera

    /**
     * Konstruktor: ustvari varčevalni račun s podano številko računa, podano obrestno mero in začetnim stanjem 0 EUR
     * @param stevilka številka računa
     * @param obresti obrestna mera
     */
    VarcevalniRacun(String stevilka, double obresti) {
        super(stevilka);
        this.obresti = obresti;
    }

    /**
     * Vrne opis računa za varčevalni račun
     * @return opis varčevalnega računa
     */
    public String opisRacuna() {
        return String.format("varčevalni, obrestna mera: %.2f%%", this.obresti * 100);
    }

    /**
     * Stanju na računu pripiše obresti. Pripisane obresti so enake stanje * obresti
     */
    void dodajObresti() {
        double trenutnoStanje = this.getStanje();
        this.polog(obresti * trenutnoStanje);
    }
}
