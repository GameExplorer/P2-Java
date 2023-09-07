package Predavanja.predavanje09.Oseba;

public class TestOseba {

    public static void main(String[] args) {
        // uporabi izpis kot je v razredu Oseba
        Oseba o1 = new Oseba();
        o1.ime = "Micka";
        o1.izpis();

        // Uporabi izpis kot je v razredu Clovek
        Clovek c1 = new Clovek();
        c1.ime = "Ana";
        c1.izpis();
    }
}
