package Izpiti.Poletni2023;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class Naloga14 {
    /**
     * Narise en kvadratek na kroznici (0,0,r) velikost kvadratka: 2k * 2k
     * kot je podan v stopinjah
     * @param r ... polmer
     * @param k ... velikost
     * @param kot ... kot
     */
    public static void kvadratek(double r, double k, double kot) {
        double x = r * Math.cos(kot * Math.PI / 180);
        double y = r * Math.sin(kot * Math.PI / 180);
        StdDraw.filledRectangle(x,y,k,k); // Nariše kvadratek
    }

    /**
     * Izris animacije
     * @param r ... krog s polmerom r
     * @param m ... m kvadratki
     */
    public static void kaca(int r, int m) {
        StdDraw.setScale(-100, 100); //velikost risalne površine
        StdDraw.enableDoubleBuffering();

        double k = (double) r / 10; // velikost kvadratka 1/10 premera
        int kot = 0; // začetni kot
        int deltaKot = 15; //za toliko povečam kot pri vsakem odmiku

        while(true) {
            // Pripravim povrsino
            StdDraw.clear(StdDraw.WHITE); //ozadje
            StdDraw.setPenColor(StdDraw.RED); //barva kroga
            StdDraw.setPenRadius(0.01); //debelina kroga

            //Narišem krog
            StdDraw.circle(0,0,r);

            //Narišem vse kvadratke
            for(int i = 0; i < m; i++) {
                kvadratek(r, k, kot+i*deltaKot);
            }

            kot += deltaKot; //povečujem kot

            StdDraw.pause(100);
            StdDraw.show();
        }
    }

    public static void main(String[] args) {
        kaca(40, 10);
    }
}
