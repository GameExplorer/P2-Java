package predavanje09;

/**
 * Razred z atributi avtor, naslov, letoIzdaje
 * ter metodami toString() in izpisi(). Metoda getPodrobnosti v tem razredu je abstraktna -> zato mora biti tudi
 * razred abstrakten.
 */
abstract public class Knjiga { //moramo napisati abstract, ker vsebuje (vsaj) eno abstraktno metodo
    static int stKnjig = 1;
    private String avtor;
    private String naslov;
    private int letoIzdaje;

    int zaporednaStevilka;

    Knjiga() {}

    Knjiga(String avtor, String naslov, int letoIzdaje) {
        this.avtor = avtor;
        this.naslov = naslov;
        this.letoIzdaje = letoIzdaje;

        this.zaporednaStevilka = ++stKnjig;
    }
    public String toString() {
        return "Stevilka knjige: " + this.zaporednaStevilka;
    }

    public String getAvtor() {
        return avtor;
    }

    public void setAvtor(String avtor) {
        this.avtor = avtor;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getLetoIzdaje() {
        return letoIzdaje;
    }

    public void setLetoIzdaje(int letoIzdaje) {
        this.letoIzdaje = letoIzdaje;
    }

    abstract String getPodrobnosti(); //abstrakten razred
    void izpisi() {
        System.out.println("Knjiga številka: " + this.zaporednaStevilka);
        System.out.println("Avtor: " + this.avtor);
        System.out.println("Naslov: " + this.naslov);
        System.out.println("Leto izdaje: " + this.letoIzdaje);
        System.out.println(getPodrobnosti());
        System.out.println();
    }
}
