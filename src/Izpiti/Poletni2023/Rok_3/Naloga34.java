package Izpiti.Poletni2023.Rok_3;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.Color;
import java.util.Random;

public class Naloga34 {
    static Color[] barve = {Color.red, Color.green, Color.blue, Color.yellow, Color.orange};

    static int[] getVrednosti(int n, int a, int b) {
        int[] rezultat = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < rezultat.length; i++) {
            rezultat[i] = a + rnd.nextInt(b-a+1);
        }
        return rezultat;
    }

    static void diagram(int [] vrednosti) {
        double w = 100;
        StdDraw.setScale(0, w);

        int n = vrednosti.length;  // število stolpcev

        double s = w / (1.2*n + 0.2); // širina stoplca
        double p = s * 0.2;           // sirina presledka

        int najvisji = 0;
        for (int i = 1; i < n; i++) {
            if (vrednosti[i] > vrednosti[najvisji]) najvisji = i;
        }

        double faktor = w / vrednosti[najvisji];  // faktor, da dobim pravilno velikost stolpca

        int b=0;
        for (int i = 0; i < vrednosti.length; i++) {
            double visinaTr = vrednosti[i] * faktor * 0.95;
            StdDraw.setPenColor(barve[b++ % barve.length]);
            StdDraw.filledRectangle(i*1.2*s + 0.7*s, 0+0.5*visinaTr, s/2, visinaTr/2);
        }
    }

    public static void main(String[] args) {
        args = new String[]{"7", "1", "15"};

        diagram(getVrednosti(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])));
    }
}