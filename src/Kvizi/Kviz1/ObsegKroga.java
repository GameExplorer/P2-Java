package Kviz1;

public class ObsegKroga {
    public static void main(String[] args) {
        krog(7.5, 3);
    }
    private static void krog(double r, int d) {
        if(r < 0) {
            System.out.println("Napaka: negativen polmer");
        }
        else if(d < 0) {
            System.out.println("Napaka: negativen d");
        }
        else {
            //Obseg kroga
            double obseg = 2 * Math.PI * r;
            System.out.printf("Obseg kroga s polmerom r=%.2f je %." + d + "f%n", r,obseg);

            //Ploščina kroga
            double ploscina = Math.PI * Math.pow(r, 2);
            System.out.printf("Ploscina kroga s polmerom r=%.2f je %." + d + "f%n", r, ploscina);
        }
    }
}
