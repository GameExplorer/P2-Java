package Izpiti.Poletni2023.Rok_3;

import java.io.File;
import java.util.Scanner;

public class Naloga32 {
    public static void main(String[] args) {
        //args = new String[]{"viri/soncendan.txt", "14"};

        if (args.length != 2) {
            System.out.println("Napaka - napačno število argumentov.");
            System.exit(1);
        }

        int n = Integer.parseInt(args[1]);
        String besedilo = "";
        try (Scanner sc = new Scanner(new File(args[0]));)
        {
            sc.useDelimiter("\\Z");
            besedilo = sc.next();
        } catch (Exception e) {
            System.out.println("Napak pri branju datoteke.");
            System.exit(1);
        }
        args = besedilo.split(" ");

        for (int i = 0; i < args.length; i++) {
            if (args[i].length() > n) {
                System.out.println(String.format("Predolga beseda (%s).", i));
                System.exit(1);
            }

        }

        String vrstica = "";
        for (int i=0; i<args.length; i++) {
            String novaVrstica = vrstica + (vrstica.isEmpty() ? "" : " ") + args[i];

            if (novaVrstica.length() > n) {
                int razlika = (n - vrstica.length()) / 2;
                System.out.println("_".repeat(razlika) + vrstica + "_".repeat(n - (vrstica.length() + razlika)));
                vrstica = args[i];
            } else {
                vrstica = novaVrstica;
            }
        }
        int razlika = (n - vrstica.length()) / 2;
        System.out.println("_".repeat(razlika) + vrstica + "_".repeat(n - (vrstica.length() + razlika)));
    }
}