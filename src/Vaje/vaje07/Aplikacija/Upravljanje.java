package vaje07.Aplikacija;

import vaje07.Imenik.Imenik;
import vaje07.Imenik.Oseba;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Upravljanje {

    // Izpis navodil za interaktivno uporabo telefonskega imenika.
    private static void izpisiNavodila() {
        System.out.println("Navodila:");
        System.out.println("1: preberi imenik, 2: izpiši imenik, 3: iskanje po imenu, 4: iskanje po telefonski številki, " +
                "5: splošno iskanje, q: izhod, h: pomoč");
    }
    /**
     * Vsebuje main metodo in izpisiNavodila(). V main metodi se izvedejo različne mmetode glede na podani vnos.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Imenik imenik = new Imenik();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        System.out.println("Telefonski imenik");
        System.out.println("h: pomoč, q: izhod");
        char ukaz;
        String vnos;
        do {
            System.out.print(">> ");
            ukaz = sc.next().toLowerCase().charAt(0);
            switch (ukaz) {
                case 'q':
                    System.out.println("Izhod.");
                    break;
                case 'h':
                    izpisiNavodila();
                    break;
                case '1':
                    System.out.print("Preberi imenik.\nVnesi pot do datoteke z imenikom: ");
                    vnos = sc.next();
                    imenik = new Imenik();
                    if (imenik.preberiOsebe(vnos))
                        System.out.print("Imenik uspešno prebran.\n");
                    else
                        System.out.print("Napaka pri branju imenika.\n");
                    break;
                case '2':
                    imenik.izpisiImenik();
                    break;
                case '3':
                    System.out.print("Iskanje osebe po imenu.\nIme: ");
                    vnos = sc.next();
                    Oseba oseba = imenik.vrniOseboPoImenu(vnos);
                    if (oseba != null)
                        System.out.println(oseba);
                    else
                        System.out.printf("Osebe %s ni v imeniku.%n", vnos);
                    break;
                case '4':
                    System.out.print("Iskanje po telefonski številki.\nTelefonska številka: ");
                    vnos = sc.next();
                    imenik.izpisiOsebePoTelefonski(vnos);
                    break;
                case '5':
                    System.out.print("Splošno iskanje.\nPoizvedba (lahko več besed): ");
                    vnos = sc.next();
                    imenik.izpisiIskaneOsebe(vnos);
                    break;
                default:
                    System.out.println("Ukaz ni veljaven. Za navodila izberite h. Za izhod izberite q.");
            }
        } while (ukaz != 'q');
    }
}