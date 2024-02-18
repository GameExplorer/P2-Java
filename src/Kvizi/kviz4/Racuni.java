package kviz4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Racuni {
    public static void main(String[] args) {
            izracunaj("src/kviz4/assets/test1.clc");
    }

    public static void izracunaj(String imeDatoteke) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(imeDatoteke));

            if(dis.readByte() == 0x43 && dis.readByte() == 0x41 && dis.readByte() == 0x4c && dis.readByte() == 0x43) {
                int steviloRacunov = dis.readInt();
                for(int i = 0; i < steviloRacunov; i++) {
                    int prviOperand = dis.readInt();
                    byte operacija = dis.readByte();
                    int drugiOperand = dis.readInt();
                    switch (operacija) {
                        case 0x2A:
                            System.out.println(prviOperand * drugiOperand);
                            break;
                        case 0x2B:
                            System.out.println(prviOperand + drugiOperand);
                            break;
                        case 0x2D:
                            System.out.println(prviOperand - drugiOperand);
                            break;
                        case 0x2F:
                            System.out.println(prviOperand / drugiOperand);
                            break;
                        default:
                            System.out.println("Napačen operator");
                            dis.close();
                            return;
                    }
                }
            }
            else {
                System.out.println("Datoteta " + imeDatoteke + " ni v formatu CLC!");
            }
            dis.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
