package Predavanja.predavanje02;

public class CeneSrecke {
    public static void main(String[] args) {
        double n = 1.25; //cena sreck

        System.out.println("Število sreck | Cena (EUR)");
        System.out.println("--------------------------");
        for(int i = 0; i < 10; i++) {
            System.out.printf("%5d%9s| %5.2f\n", i, " ", n); //lahko je tudi %6.2f samo zaradi preglednosti je boljše
            n += 1.25;                                       // narediti presledek
        }

    }
}
