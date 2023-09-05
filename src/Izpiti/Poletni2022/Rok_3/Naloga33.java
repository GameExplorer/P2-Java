package Izpiti.Poletni2022.Rok_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Tocka {
    private int x;
    private int y;

    // KOnstruktor
    public Tocka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //getterji za dostop do elementov
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // izpis
    public String toString() {
        return String.format("Tocka (%3d,%3d) D = %.1f", this.x, this.y, razdaljaOdIzhodisca());
    }

    //izračunam D .. razdaljo od izhodišša Math.sqrt(x²+y²)
    public double razdaljaOdIzhodisca() {
        return Math.sqrt(this.x * this.x  + this.y * this.y);
    }
}

/**
 * Razred omogoča urejanje točk po padajočem vrstnem redu
 */
class PrimerjajTOckaPoOddaljenostiPadajoce implements Comparator<Tocka> {
    public int compare(Tocka t1, Tocka t2) {
        return Double.compare(t2.razdaljaOdIzhodisca(), t1.razdaljaOdIzhodisca());
    }
}
public class Naloga33 {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Tocka> seznam = new ArrayList<>();
        int n = rnd.nextInt(7) + 2; //naključna številka ki ji prišteješ 2
        for(int i = 0; i < n; i++) {
            //koordinati
            int x = rnd.nextInt(199) - 99; //naključna številka od 0 do 199 in jo potem odšteješ
            int y = rnd.nextInt(199) - 99;
            seznam.add(new Tocka(x,y));
        }

        for(Tocka t : seznam) {
            System.out.println(t.toString());
        }

        System.out.println();
        //uredim točke
        Collections.sort(seznam, new PrimerjajTOckaPoOddaljenostiPadajoce());
        System.out.println("Urejene točke: ");
        for(Tocka t : seznam) { //izpis urejenih tock
            System.out.println(t.toString());
        }
    }
}
