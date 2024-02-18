package kviz3;

import java.io.File;
import java.util.Scanner;

public class Matrike {
    public static void main(String[] args) {
        Matrika m1 = Matrika.preberiMatriko("src/kviz3/assets/m1.txt");
        assert m1 != null;
        m1.izpis();
    }
}

class Matrika {
    int[][] matrika;

    Matrika(int[][] matrika) { this.matrika = matrika; }

    Matrika zmnozi(Matrika b) {
        int[][] produkt = new int[b.matrika.length][b.matrika.length];
        for(int i = 0; i < this.matrika.length; i++) {
            for(int j = 0; j < b.matrika.length; j++) {
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
        try {
            int i = 0;
            Scanner sc = new Scanner(new File(imeDatoteke));
            int velikost = Integer.parseInt(sc.nextLine());
            int[][] surovaMatrika = new int[velikost][velikost];

            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split(" ");
                for(int j = 0; j < vrstica.length; j++) {
                    surovaMatrika[i][j] = Integer.parseInt(vrstica[j]);
                }
                i++;
            }
            sc.close();
            return new Matrika(surovaMatrika);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
