package Kvizi.Kvizi4;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Kviz8 {
    public static void izracunaj(String imeDatoteke) {
        try(DataInputStream vhod = new DataInputStream(new FileInputStream(imeDatoteke))) {

            if(vhod.readByte() == 0x43 && vhod.readByte() == 0x41 && vhod.readByte() == 0x4C &&
               vhod.readByte() == 0x43) {

                int steviloRacunov = vhod.readInt();

                for(int i = 0; i < steviloRacunov; i++) {
                    int prviOperand = vhod.readInt();
                    byte operacija = vhod.readByte();
                    int drugiOperand = vhod.readInt();

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
                            return;
                    }
                }
            }
            else {
                System.out.printf("Datoteka %s ni v pravem formatu", imeDatoteke);
            }

        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        izracunaj("src/Kvizi/viri/test1.clc");
    }
}
