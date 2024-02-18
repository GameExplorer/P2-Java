package kviz4;

public class Besedilo {
    public static void izpisi(String besedilo) {
        String[] besede = besedilo.split("\\s+"); // Razdeli besedilo na besede (ločilo je presledek)

        for (int i = 0; i < besede.length; i++) {
            String beseda = besede[i];
            String opremljenaBeseda = beseda;

            // Odstrani ločila na začetku in koncu besede
            opremljenaBeseda = opremljenaBeseda.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

            int dolzina = opremljenaBeseda.length();

            System.out.print(opremljenaBeseda + "(" + dolzina + ")");

            // Dodaj ločila na koncu besede, če so prisotna
            String lozilo = beseda.substring(opremljenaBeseda.length());
            System.out.print(lozilo + " ");
        }
    }

    public static void main(String[] args) {
        String besedilo = "Java je super";
        izpisi(besedilo);
        System.out.println();

        besedilo = "Bravo, zelo dobro.";
        izpisi(besedilo);
        System.out.println();

        besedilo = "Prva, druga, tretja, cetrta, peta, sesta.";
        izpisi(besedilo);
        System.out.println();

        besedilo = "Danes je Torek!";
        izpisi(besedilo);
        System.out.println();
    }
}
