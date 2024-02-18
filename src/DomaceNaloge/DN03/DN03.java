package DN03;

import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class DN03 {
    public static void main(String[] args) throws Exception {
        args = new String[]{"src/DN03/gesla.txt", "10", "100"}; //testni stavek

        String gesla = args[0]; //gesla
        int seme = Integer.parseInt(args[2]); //seme za random zaporedje
        int dolzina_gesla = Integer.parseInt(args[1]); //dolzina gesla

        String[] besede = preberiBesede(gesla);
        String izpis = ustvaritevGesla(dolzina_gesla, seme, besede);

        System.out.printf("%s", izpis);
    }

    private static String[] preberiBesede(String gesla) throws Exception {
        Scanner sc = new Scanner(new File(gesla)); //preberemo datoteko
        int stBesed = sc.nextInt(); //st besed
        String[] tab_besed = new String[stBesed];
        int i = 0;
        while(i < stBesed) {
            tab_besed[i] = sc.next(); //berem datoteko in zapisujem podatke v tabelo
            i++;
        }

        sc.close(); //obvezno zaprem datoteko

        return tab_besed;
    }

    private static String ustvaritevGesla(int dolzina_gesla, int seme, String[] besede) {
        Random random = new Random(seme);
        StringBuilder geslo = new StringBuilder();
        int i = 0;
        while (i < dolzina_gesla) {
            //tukaj preberem besede in i-ti črko
            int beseda = random.nextInt(besede.length);
            int crka = random.nextInt(besede[beseda].length());

            //skupaj združim v geslo
            geslo.append(String.valueOf(besede[beseda].charAt(crka)));
            i++;
        }

        return geslo.toString();
    }
}

