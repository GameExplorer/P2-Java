package Izpiti.Poletni2023.Rok_3;

public class Naloga31 {
    public static void main(String[] args) {
        //args = new String[] {"pomlad", "poletje", "jesen", "zima"};
        //args = new String[] {"A","B","C","D","E","F","G","H"};


        char[] znak = {'*', '+'};
        int trZ = 0;
        for (int i = 0; i < args.length; i++) {
            System.out.print((znak[trZ]+"").repeat(args[i].length()+4));
            if (i < args.length-1) System.out.print(" ");
            trZ = (trZ + 1)%2;
        }
        System.out.println();

        trZ = 0;
        for (int i = 0; i < args.length; i++) {
            System.out.print(znak[trZ] + " " + args[i] + " " + znak[trZ] + " ");
            trZ = (trZ + 1)%2;
        }
        System.out.println();

        trZ = 0;
        for (int i = 0; i < args.length; i++) {
            System.out.print((znak[trZ]+"").repeat(args[i].length()+4));
            if (i < args.length-1) System.out.print(" ");
            trZ = (trZ + 1)%2;
        }
        System.out.println();
    }
}