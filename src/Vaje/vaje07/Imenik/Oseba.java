package vaje07.Imenik;

/**
 * Razred Oseba hrani podatke o imenu, priimku, kraju, telefonski številki in ali je telefonska številka
 * mobilna ali ne.
 * Podatke smo skrili in uporabili getterje/setterje da smo lahko dostopali do njih
 * Ustvarili smo konstruktor Oseba, ki nastavi vrednosti vseh atributov
 * toString() metoda je pa za formatiran izpis
 */
public class Oseba {
    private String ime;
    private String priimek;
    private String kraj;
    private String telefonska_stevilka;
    boolean mobilni;

    public  Oseba(String ime, String priimek, String kraj, String telefonska_stevilka, boolean mobilni) {
        this.ime = ime;
        this.priimek = priimek;
        this.kraj = kraj;
        this.telefonska_stevilka = telefonska_stevilka;
        this.mobilni = mobilni;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime1) {
        ime = ime1;
    }

    public String getPriimek() {
        return priimek;
    }

    public void setPriimek(String priimek1) {
        priimek = priimek1;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj1) {
        kraj = kraj1;
    }

    public String getTelefonska() {
        return telefonska_stevilka;
    }

    public void setTelefonska_stevilka(String telefonska_stevilka1) {
        telefonska_stevilka = telefonska_stevilka1;
    }

    public boolean getMobilni() {
        return mobilni;
    }

    public void setMobilni(boolean mobilni1) {
        mobilni = mobilni1;
    }
    public String toString() {
        return String.format("%s %s, %s: %s%s", ime, priimek, kraj, telefonska_stevilka, mobilni ?
                                                                            "(mobilni)" : "");
    }
}