package predavanje12;


import java.io.FileInputStream;

public class HexDump {
    public static void main(String[] args) {
        try {
            //odprem binarno datoteko
            FileInputStream fis = new FileInputStream("src/predavanje12/medo.png");
            int s = 0;
            StringBuilder znaki = new StringBuilder();
            //dokler ima datoteka vsebino...
            while(fis.available() > 0) {
                //berem znak po znaku
                int z = fis.read();
                s++;
                znaki.append((32 <= z && z <= 127) ? (char) z : ".");
                System.out.printf("%02X ", z);

                if(s % 8 == 0) System.out.print("  ");
                if(s % 16 == 0) System.out.println("    |" + znaki + "|");
                znaki = new StringBuilder();
            }
            //na koncu obvezno zaprem datoteko
            fis.close();
        }
        catch (Exception e) {
            System.out.println("Napaka : " + e);
        }
    }
}