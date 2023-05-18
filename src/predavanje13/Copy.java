package predavanje13;

import java.io.*;

public class Copy {
    public static boolean kopiraj(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            while(fis.available() > 0) {
                int z = fis.read(); //preberemo znake
                fos.write(z);
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
    public static boolean kopirajHitreje(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            byte[] buffer = new byte[4096];
            while(fis.available() > 0) {
                int n = fis.read(buffer); //prebere tabelo in vrne št prebranih bajtov
                fos.write(buffer, 0, n);
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
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(output);
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
        if(!kopirajNajHitreje ("src/predavanje13/drzave.txt", "src/predavanje13/kopiranaDat.txt")) {
            System.out.println("Neuspešno kopiranje");
        }
        else {
            System.out.println("Uspešno kopiranje");
        }
    }
}
