package predavanje09;

public class TestOseba {

    public static void main(String[] args) {
        Oseba o1 = new Oseba();
        o1.ime = "Micka";

        o1.izpis();

        Clovek c1 = new Clovek();

        c1.ime = "Ana";
        c1.izpis();
    }
}
