package Predavanja.predavanje10;


import java.awt.Color;
import edu.princeton.cs.algs4.StdDraw;

public class Paint {

    final static int MAX_LIKI = 10;

    public static void main(String[] args) {
        StdDraw.setScale(0, 100);

        Krog k = new Krog(30, 50, 10, Color.red);
        Krog k1 = new Krog(20, 20, 10, Color.blue);
        Pravokotnik p = new Pravokotnik(70,80,25,10, Color.yellow);
        Kvadrat kv = new Kvadrat(70,35,20, Color.black);
        Krog k2 = new Krog(25,80,20, Color.cyan);

        int stLikov = 0;
        Lik[] liki = new Lik[MAX_LIKI];
        liki[stLikov++] = k;
        liki[stLikov++] = k1;
        liki[stLikov++] = p;
        liki[stLikov++] = kv;
        liki[stLikov++] = k2;

        StdDraw.enableDoubleBuffering();
        while(true) {
            StdDraw.clear(Color.white);

            if(StdDraw.hasNextKeyTyped()) {
                char tipka = StdDraw.nextKeyTyped(); //WASD

                switch (tipka) {
                    case 'w':
                        for(int i = 0; i < stLikov; i++) {
                            if(liki[i].isOznacen()) liki[i].premakniSe(0,5);
                        }
                        break;
                    case 's':
                        for(int i = 0; i < stLikov; i++) {
                            if(liki[i].isOznacen()) liki[i].premakniSe(0,-5);
                        }
                        break;
                    case 'a':
                        for(int i = 0; i < stLikov; i++) {
                            if(liki[i].isOznacen()) liki[i].premakniSe(-5,0);
                        }
                        break;
                    case 'd':
                        for(int i = 0; i < stLikov; i++) {
                            if(liki[i].isOznacen()) liki[i].premakniSe(5,0);
                        }
                        break;
                    case '+':
                        for(int i = 0; i < stLikov; i++) {
                            if(liki[i].isOznacen()) liki[i].povecajSe(1.1);
                        }
                        break;
                    case '-':
                        for(int i = 0; i < stLikov; i++) {
                            if(liki[i].isOznacen()) liki[i].povecajSe(0.9);
                        }
                        break;
                }
                if(tipka >= '0' && tipka <= '9') {
                    for(int i = 0; i < stLikov; i++) {
                        liki[i].setOznacen(false);
                    }
                    if(tipka-'0' < stLikov) liki[tipka-'0'].setOznacen(true);
                }
            }

            for(int i = 0; i < stLikov; i++) {
                liki[i].narisiSe();
            }

            StdDraw.show();
            StdDraw.pause(100);
        }
    }
}
