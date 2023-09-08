package Predavanja.predavanje13;

import java.io.*;

/**
 * Trije načini kopiranja.
 * bajt-po-bajtu (metoda kopiraj()),
 * blok-po-bloku (metodaKopirajHitreje)
 * in blok-po-bloku z dodanim bufferejm (metodaKopirajNajHitreje)
 */
public class Copy {
    /**
     * Metoda prekopira prvo datoteko v drugo, če pride do napake vrne false sicer true
     * @param input
     * @param output
     * @return
     */
    public static boolean kopiraj(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            //dokler datoteka ima vsebino
            while(fis.available() > 0) {
                int z = fis.read(); //preberemo znake
                fos.write(z);
            }

            //obvezno zapremo!!
            fis.close();
            fos.close();
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean kopirajHitreje(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            byte[] buffer = new byte[4096];
            while(fis.available() > 0) {
                //preberem blok podatkov
                int n = fis.read(buffer); //prebere tabelo in vrne št prebranih bajtov
                fos.write(buffer, 0, n); //zapišem natančno toliko podatkov, kot sem jih prebral
            }

            fis.close();
            fos.close();
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static boolean kopirajNajHitreje(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            // dodam še BufferedInputStream, da dodatno pospešim branje
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(output);
            // dodam še BUfferedOutputStream da dodatno pospešim pisanje
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[4096];
            while(bis.available() > 0) {
                int n = bis.read(buffer); //prebere tabelo in vrne št prebranih bajtov
                bos.write(buffer, 0, n);
            }

            bis.close();
            bos.close();
            return true;
        }
        catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static void main(String[] args) {
        if(!kopirajNajHitreje ("src/Predavanja/predavanje13/drzave.txt", "src/Predavanja/predavanje13/kopiranaDat.txt")) {
            System.out.println("Neuspešno kopiranje");
        }
        else {
            System.out.println("Uspešno kopiranje");
        }
    }
}