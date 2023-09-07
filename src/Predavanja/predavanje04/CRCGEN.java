package Predavanja.predavanje04;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Napiši program, ki za dano vhodno datoteko izračuna kontrolno vsoto (znakov za konec vrstice ne šteje,
 * vsoto računa po modulu 1024); program naj vhodno datoteko prepiše v novo datoteko,
 * tej pa naj na koncu doda izračunano vsoto.
 * Na začetku programa odpremo dve datoteki: eno za branje (uporabimo razred Scanner),
 * drugo za pisanje (razred PrintWriter);
 * datoteko beremo vrstico po vrstico in prebrane vrstice sproti zapisujemo v izhodno datoteko; poleg tega gremo
 * po vsaki vrstici znak po znaku in posamezne znake prištevamo skupni vsoti;
 * na koncu v izhodno datoteko zapišemo izračunano vsoto.
 */
public class CRCGEN {
    static int MAX_VSOTA = 1024; //računamo po modulu 1024

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("src/Predavanja/predavanje04/Vhodna_Zdravljica.txt"));
        PrintWriter pw = new PrintWriter("src/Predavanja/predavanje04/Izhodna_Zdravljica.txt");

        int checkSum = 0;
        //datoteko beremo po vrstici
        while(sc.hasNextLine()) {
            //preberem vrstico
            String vrstica = sc.nextLine();

            //in jo zapiše v izhodno datoteko
            pw.println(vrstica);

            // jo pregledamo znak po znaku
            for(int i = 0; i < vrstica.length(); i++) {
                char znak = vrstica.charAt(i);

                checkSum = (checkSum + (int) znak) % MAX_VSOTA;
            }
        }
        pw.print(checkSum);

        pw.close();
        sc.close();
    }
}