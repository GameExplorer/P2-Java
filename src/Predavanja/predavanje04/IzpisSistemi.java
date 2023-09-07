package Predavanja.predavanje04;

public class IzpisSistemi {
    public static void main(String[] args) {
        int st_vrstic = 32;

        if(args.length == 1) {
            st_vrstic = Integer.parseInt(args[0]);
        }

        int i;
        System.out.println("Desetisko | Osmisko | Sestnajstisko\n");
        for(i = 1; i <= st_vrstic; i++) System.out.printf("%7d   | %5o   | %11X\n", i,i,i);
    }
}
