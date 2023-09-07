package Predavanja.predavanje06.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Razred s pomoznimi metodami za branje in pisanje v tekstovno datoteko
 */
public class BeriPisi {

    /**
     * Metoda prebere vsebino tekstovne datoteke in vrne njeno vsebino kot en niz
     * @param imeDatoteke ime datoteke, ki jo preberemo
     * @return vsebina.toString() vrnemo vsebino
     * @throws Exception ker beremo moramo throwat Exception
     */
    public static String preberiDatoteko(String imeDatoteke) throws Exception {
        Scanner sc = new Scanner(new File(imeDatoteke));
        StringBuilder vsebina = new StringBuilder();

        while(sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            vsebina.append((vsebina.length() == 0) ? "" : "\n").append(vrstica);
        }

        sc.close();
        return vsebina.toString();
    }

    /**
     * One liner isto kot prejšna metoda
     * @param imeDatoteke imeDatoteke ki jo preberemo
     * @return isto kot prej
     * @throws Exception isto kot prej
     */
    public static String preberiDatotekoOL(String imeDatoteke) throws Exception {
        return Files.readString(Path.of(imeDatoteke));
    }

        /**
         * Metoda zapiše podano vsebino v tekstovno datoteko
         * @param imeDatoteke ime datoteke v katero pišemo
         * @param vsebina vsebina, ki se zapiše
         */
    public static void zapisiVDatoteko(String imeDatoteke, String vsebina) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(imeDatoteke);
        pw.println(vsebina);
        pw.close();
    }
}