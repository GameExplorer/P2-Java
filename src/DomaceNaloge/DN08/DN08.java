package DN08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Planet {
    private String ime;
    private int radij;

    public Planet() {}

    public Planet(String ime, int radij) {
        this.ime = ime;
        this.radij = radij;
    }

    public String getIme() {
        return ime;
    }

    public double povrsina() {
        return (4 * Math.PI * radij * radij);
    }
}
public class DN08 {
    public static Planet[] preberiPlanete(String imeDatoteke) throws FileNotFoundException {
        int st = 0;
        Planet[] planeti = new Planet[8];

        Scanner sc = new Scanner(new File(imeDatoteke), "UTF-8");

        while(sc.hasNextLine()) {
            String[] deli = sc.nextLine().split(":");
            if(deli.length == 2) planeti[st++] = new Planet(deli[0], Integer.parseInt(deli[1]));

        }
        sc.close();
        return planeti;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Planet[] planeti = preberiPlanete(args[0]);

        String[] deli = args[1].split("[+]");
        double vsota = 0;

        int p = -1;

        for(int i = 0; i < deli.length; i++) {
            for(int j = 0; j < planeti.length; j++) {
                if(planeti[j].getIme().equalsIgnoreCase(deli[i])) p = j;
            }

            if(p != -1) vsota += planeti[p].povrsina();
        }


        System.out.printf("Povrsina planetov \"%s\" je %.0f milijonov km2\n", args[1], vsota / Math.pow(10,6));
    }
}
