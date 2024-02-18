package kviz3;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Tocke {
    public static void main(String[] args){

    }
}

class Tocka{
    int x,y;

    Tocka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double razdalja(Tocka tocka) { return Math.sqrt(Math.pow(tocka.x - this.x, 2) + Math.pow(tocka.y - this.y, 2)); }

    public String toString() { return String.format("Tocka (%d, %d) ", x, y); }

    static Tocka[] preberiTocke(String imeDatoteke) {
        ArrayList<Tocka> tocke = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(imeDatoteke));
            while(sc.hasNextLine()) {
                String[] tocka = sc.nextLine().split(" ");
                if(tocka.length == 2) {
                    tocke.add(new Tocka(Integer.parseInt(tocka[0]), Integer.parseInt(tocka[1])));
                }
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Datoteka ne obstaja");
        }
        return tocke.toArray(new Tocka[0]);
    }

    static void najblizji(Tocka[] t1, Tocka[] t2) {
        if(t1.length == 0) {
            System.out.println("Prva tabela ne vsebuje točk");
        }
        else if(t2.length == 0) {
            System.out.println("Druga tabela ne vsebuje točk");
        }

        Tocka[] najblizjiTocki = new Tocka[2];
        double razdalja = 0;

        for(Tocka tocka1 : t1) {
            for(Tocka tocka2 : t2) {
                double d = tocka1.razdalja(tocka2);
                if(d < razdalja || najblizjiTocki[0] == null) {
                    najblizjiTocki[0] = tocka1;
                    najblizjiTocki[1] = tocka2;
                    razdalja = d;
                }
            }
        }

        System.out.printf("Najbližji točki sta %s in %s, razdalja med njima je %.2f", najblizjiTocki[0], najblizjiTocki[1], razdalja);
    }
}


