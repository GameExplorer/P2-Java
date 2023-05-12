package predavanje12;

import java.io.File;
import java.io.FileInputStream;

public class HexDump {
    public static void main(String[] args) {
        try {
            //odprem binarno datoteko
            FileInputStream fis = new FileInputStream(new File("src/predavanje12/medo.png"));
            int s = 0;
            //dokler ima datoteka vsebino...
            while(fis.available() > 0) {
                //berem znak po znaku
                int z = fis.read();
                s++;
                System.out.printf("%02X ", z);

                if(s % 8 == 0) System.out.print("  ");
                if(s % 16 == 0) System.out.println();
            }
            //na koncu obvezno zaprem datoteko
            fis.close();
        }
        catch (Exception e) {
            System.out.println("Napaka : " + e.toString());
        }

    }
}
