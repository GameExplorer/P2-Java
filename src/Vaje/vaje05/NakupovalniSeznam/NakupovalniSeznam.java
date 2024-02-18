package vaje05.NakupovalniSeznam;

import java.util.Scanner;

public class NakupovalniSeznam {
    private static void izpisiNavodila() {
        System.out.println("Navodila:");
        System.out.println("1: ustvari seznam\n" +
                "2: dodaj element na konec\n" +
                "3: vrini element na mesto\n" +
                "4: odstrani element na mestu\n" +
                "5: vrni dolžino seznama\n" +
                "6: izpiši seznam\n" +
                "7: izpiši 64-bitno\n" +
                "8: uniči seznam\n" +
                "q: izhod\n" +
                "h: pomoč");
    }

    /**
     * Porgram za pripravo nakupovalnega seznama
     * Omogoča ustvarjanje seznama, dodajanje in brisanje posameznih elementov ter izpis seznama
     *
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Priprava nakupovalnega seznama ....");
            System.out.println("h: pomoč. q: izhod");
            char ukaz; //za switch
            String element; //element
            int mesto, dol; //dol -> dolžina seznama

            do {
                System.out.print(">> ");
                ukaz = sc.next().toLowerCase().charAt(0);
                switch (ukaz) {
                    case 'q':
                        System.out.println("izhod");
                        break;
                    case 'h':
                        izpisiNavodila();
                        break;
                    case '1': //ustvari seznam
                        System.out.println("Ustvari seznam.\n Vnesi dolžino seznama: ");
                        dol = sc.nextInt();
                        if (extracted(dol)) System.out.printf("Seznam dolžine %d je ustvarjen\n", dol);
                        else System.out.printf("NAPAKA: Seznam je že narejen ali podana dolžina ni prava\n");
                        break;
                    case '2': //dodaj element na konec
                        System.out.print("Dodaj element n konec.\n Nov element: ");
                        element = sc.next();
                        if (extracted2(element)) System.out.printf("Element <%s> je dodan na konec seznama\n", element);
                        else System.out.println("NAPAKA: Seznam še ni narejen ali pa je že poln");
                        break;
                    case '3': //Vrini element na mesto
                        System.out.print("Dodaj element na podano mesto.\n Nov element: ");
                        element = sc.next();
                        System.out.print("Mesto vrinjenega elementa (od 1 naprej): ");
                        mesto = sc.nextInt();
                        if (vaje05.Zbirke.Seznam.dodajVSeznam(element, mesto)) {
                            System.out.printf("Element <%s> je dodan v seznam na mesto %d\n", element, mesto);
                        } else
                            System.out.println("NAPAKA: Seznam še ni narejen, je že poln ali pa je podano mesto napačno");
                        break;
                    case '4': //Odstrani element na mestu
                        System.out.print("Odstrani element na podanem mestu\n. Mesto brisanega elementa: ");
                        mesto = sc.nextInt();
                        element = extracted3(mesto);
                        if (element != null) {
                            System.out.printf("Element <%s> je odstranjen iz seznama.\n", element);
                        } else
                            System.out.printf("NAPAKA: Seznam še ni narejen ali el. na mestu %d ne obstaja\n", mesto);
                        break;
                    case '5': //vrne dolžino seznama
                        dol = extracted4();
                        if (dol >= 0) System.out.printf("Dolžina seznama je %d\n", dol);
                        else System.out.println("NAPAKA: Seznam še ni narejen");
                        break;
                    case '6': //izpiši seznam
                        extracted5();
                        break;
                    case '7': //izpiši 64 bitno
                        extracted6();
                        break;
                    case '8': //uniči seznam
                        if (extracted7()) System.out.println("Seznam je uničen");
                        else System.out.println("NAPAKA: Seznam ne obstaja");
                        break;
                    default:
                        System.out.println("Ukaz ni veljaven Za navodila izberite h. Za izhod izberite q");
                }
            }
            while (ukaz != 'q');
        }
    }

    private static boolean extracted7() {
        return vaje05.Zbirke.Seznam.uniciSeznam();
    }

    private static void extracted6() {
        vaje05.Zbirke.Seznam.izpisiSeznam64bit();
    }

    private static void extracted5() {
       vaje05.Zbirke.Seznam.izpisiSeznam();
    }

    private static int extracted4() {
        return vaje05.Zbirke.Seznam.dolzinaSeznama();
    }

    private static String extracted3(int mesto) {
        return vaje05.Zbirke.Seznam.odstraniIzSeznama(mesto);
    }

    private static boolean extracted2(String element) {
        return vaje05.Zbirke.Seznam.dodajNaKonecSeznama(element);
    }

    private static boolean extracted(int dol) {
        return vaje05.Zbirke.Seznam.narediSeznam(dol);
    }
}