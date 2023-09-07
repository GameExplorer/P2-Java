package Predavanja.predavanje13;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * Koda prebere podatke o verzije jave s katero je bila datoteka ustvarjena
 * CAFEBABE izpieš -> s tem potrdim, da gre za class datoteko
 */
public class ClassDump {

    public static void main(String[] args) {
        String ime = "out/production/javaPredavanja/Predavanja.predavanje13/Copy.class";
        try (FileInputStream fis = new FileInputStream(ime);
             DataInputStream dis = new DataInputStream(fis);)
        {
            byte[] magic = new byte[4];
            dis.read(magic);

            for (int i = 0; i < 4; i++) {
                System.out.printf("%X", magic[i]);
            }

            // Podatka o minor in major verziji jave sta z dvema bajtoma (short)
            // zapisana takoj za magično številko
            short minor = dis.readShort();
            short major = dis.readShort();

            System.out.println();
            System.out.println(major + "." + minor);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}