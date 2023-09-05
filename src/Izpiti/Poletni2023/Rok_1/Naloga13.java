package Izpiti.Poletni2023.Rok_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Razred Stanje vsebuje privatne atribute, konstruktor,
 * getterje/setterje da lahko dostopamo do podatkov in metodo toString() za formatiran izpis podatkov
 */
class Stanje {
    private String datum;
    private int danes;
    private int letos;

    public Stanje(String datum, int danes, int letos) {
        this.datum = datum;
        this.danes = danes;
        this.letos = letos;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getDanes() {
        return danes;
    }

    public void setDanes(int danes) {
        this.danes = danes;
    }

    public int getLetos() {
        return letos;
    }

    public void setLetos(int letos) {
        this.letos = letos;
    }

    public String toString() {
        return String.format("Dan: %s, Danes: %d, Letos: %d", datum, danes, letos);
    }
}
public class Naloga13 {

    /**
     * Metoda prejme tekstovno datoteko, jo prebere in vrne seznam vseh prebranih stanj objektov tipa Stanje
     * @param vhodnaDatoteka - vhodna datoteka
     * @return - vrne vsa prebrana stanja
     */
    public static ArrayList<Stanje> preberiStanja(String vhodnaDatoteka) {
        ArrayList<Stanje> stanja = new ArrayList<>(); //ustvarimo seznam

        try (Scanner sc = new Scanner(new File(vhodnaDatoteka));) { //odpremo datoteko
            while(sc.hasNextLine()) { //beremo vrstico
                String[] deli = sc.nextLine().split(":"); //razbijemo po ":"
                Stanje s = new Stanje(deli[0], Integer.parseInt(deli[1]), Integer.parseInt(deli[2])); //shranimo podatke
                stanja.add(s); // v stanja
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        return stanja;
    }

    /**
     * Metoda izpiše 10 najboljših dni. Izpis je urejen v naraščajočem vrstnem redu
     */
    public static void izpisiTop10(ArrayList<Stanje> stanja) {
        stanja.sort(new Comparator<Stanje>() { // sortiramo podatke in uporabimo anonimni notranji razred
            @Override
            public int compare(Stanje o1, Stanje o2) {
                if(o2.getDanes() != o1.getDanes()) { //če si št. kolesarjev ni enako
                    return o2.getDanes() - o1.getDanes();
                }
                else {
                    return o2.getDatum().compareTo(o1.getDatum()); //če pa sta enaka primerjaj po datumu in razvrsi po datumu
                }
            }
        });

        //izpis 10 najboljših dni
        for(int i = 9; i >= 0; i--) {
            System.out.println(stanja.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<Stanje> stanja = preberiStanja("src/Izpiti/Poletni2023/Rok_1/kolo-letos.txt");
        izpisiTop10(stanja);
    }
}