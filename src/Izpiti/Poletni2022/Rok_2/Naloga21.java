package Izpiti.Poletni2022.Rok_2;

public class Naloga21 {
    public static void izpisi(String niz) {
        String[] besede = niz.split(" "); //niz razbijemo po presledku

        int b = 0; // največ do 4 besede na vrstico
        for (int i = 0; i < besede.length; i++) { //sprehod po nizu
            String beseda = besede[i]; //i-to besedo pripišem besedi
            String locilo = "";

            // preverimo ali se konča z enim od ločil, če se zmanjšamo dolzino besede
            if (beseda.endsWith(".") || beseda.endsWith(",") || beseda.endsWith(" ")) {
                locilo = beseda.substring(beseda.length() - 1); //shrani locilo
                beseda = beseda.substring(0, beseda.length() - 1); //shrani besedo brez locila
            }

            System.out.printf("%s(%d)%s ", beseda, beseda.length(), locilo);

            //Izpis po največ 4 besede v eni vrsti
            if (++b == 4) {
                System.out.println();
                b = 0;
            }
        }
    }


    public static void main(String[] args) {
        args = new String[]{"Bravo, zelo dobro"};
        String niz = String.join(" ", args[0]);
        izpisi(niz);
    }
}
