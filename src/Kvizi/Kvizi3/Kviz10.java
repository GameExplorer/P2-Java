package Kvizi.Kvizi3;

import java.io.FileInputStream;

public class Kviz10 {
    public static int bsdChecksum(String filename) {
        try(FileInputStream vhod = new FileInputStream(filename)) {
            int sum = 0;
            while(vhod.available() > 0) {
                int c = vhod.read();
                sum = (sum >> 1) + ((sum & 0X1) << 15);
                sum = (sum +c ) % 65536;
            }
            return sum;
        }
        catch (Exception e) {
            return 0;
        }
    }
    public static void main(String[] args) {
        int rez = bsdChecksum("src/Kvizi/viri/besedilo1.txt");
        System.out.println("BSD je " + rez);
    }
}
