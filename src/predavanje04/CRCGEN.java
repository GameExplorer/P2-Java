package predavanje04;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class CRCGEN {
    static int MAX_VSOTA = 1024; //računamo po modulu 1024

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("src/predavanje04/Vhodna_Zdravljica.txt"));
        PrintWriter pw = new PrintWriter("src/predavanje04/Izhodna_Zdravljica.txt");

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