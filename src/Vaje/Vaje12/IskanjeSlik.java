package Vaje12;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class IskanjeSlik {
    private ArrayList<Slika> slike = new ArrayList<>();

    public void preisci(String pot) {
        File dat = new File(pot);

        if(dat.isFile()) { //podana je datoteka, prever ali ustreza formatu in dodaj sliko na seznam
            if(Slika.jePNG(dat.getPath())) { //če je PNG jo preberi in dodaj na seznam
                slike.add(Slika.preberiPNG(dat.getPath()));
            } else if(Slika.jeJPEG(dat.getPath())) {
                slike.add(new Slika(dat.getPath(), "JPEG")); //je JPEG ustvari sliko neznane velikost in jo dodaj na seznam
            } else if(Slika.jeGIF(dat.getPath())) {
                slike.add(new Slika(dat.getPath(), "GIF")); // je GIF ustvari sliko neznane velikosti in jo dodaj na seznam
            }
        } else if(dat.isDirectory()) { //podan je direktorij preveri vse njegove elemente
            String[] elementi = dat.list();
            for(String el : elementi) {
                preisci(dat.getPath() + File.separator + el);
            }
        }
    }

    public void izpisi() {
        slike.sort(new Comparator<Slika>() {
            public int compare(Slika s1, Slika s2) {
                int primerjava = Integer.compare(s1.getVelikost(), s2.getVelikost());
                if(primerjava == 0) return s1.getPot().compareTo(s2.getPot());
                return primerjava;
            }
        });

        for(Slika s : slike) {
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(Slika.jePNG("src/Vaje12/github.png"));
        System.out.println(Slika.preberiPNG("src/Vaje12/github.png"));
        System.out.println();

        IskanjeSlik iskalnik = new IskanjeSlik();
        iskalnik.preisci("src/");
        iskalnik.izpisi();
    }
}
