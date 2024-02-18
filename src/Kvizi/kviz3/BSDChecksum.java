package kviz3;

import java.io.IOException;

public class BSDChecksum {
    public static void main(String[] args) throws IOException {
        bsdChecksum("besede.txt");
    }
    public static int bsdChecksum(String filename) throws IOException {
        java.io.FileInputStream file = new java.io.FileInputStream(filename);
        int sum = 0;

        while(file.available() > 0) {
            int c = file.read();
            sum = (sum >> 1) + ((sum & 0X1) << 15);
            sum = (sum + c) % 65536;
        }
        file.close();
        return sum;
    }
}