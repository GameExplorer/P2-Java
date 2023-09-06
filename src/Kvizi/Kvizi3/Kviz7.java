package Kvizi.Kvizi3;

import java.io.File;
import java.util.Scanner;

class Matrika {
    int[][] matrika;

    Matrika(int[][] matrika) {
        this.matrika = matrika;
    }

    Matrika zmnozi(Matrika b) {
        int[][] produkt = new int[b.matrika.length][b.matrika.length];

        for(int i = 0; i < this.matrika.length; i++) {
            for(int j = 0; i < b.matrika.length; j++) {
                for(int k = 0; k < this.matrika.length; k++) {
                    produkt[i][j] += this.matrika[i][k] * b.matrika[k][j];
                }
            }
        }

        return new Matrika(produkt);
    }

    public void izpis() {
        for(int i = 0; i < this.matrika.length; i++) {
            for(int j = 0; j < this.matrika.length; j++) {
                System.out.printf("%2d", this.matrika[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrika preberiMatriko(String imeDatoteke) {
        try(Scanner sc = new Scanner(new File(imeDatoteke))) {
            int i = 0;
            int velikost  = Integer.parseInt(sc.nextLine());
            int[][] surovaMatrika = new int[velikost][velikost];

            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split(" ");

                for(int j = 0; j < vrstica.length; j++) {
                    surovaMatrika[i][j] = Integer.parseInt(vrstica[j]);
                }
                i++;
            }
            return new Matrika(surovaMatrika);
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
        return null;
    }
}
public class Kviz7 {

    public static void main(String[] args) {
        Matrika a = Matrika.preberiMatriko("src/Kvizi/viri/m1.txt");
        Matrika b = Matrika.preberiMatriko("src/Kvizi/viri/m2.txt");
        Matrika c = b.zmnozi(a);
        c.izpis();
    }
}
