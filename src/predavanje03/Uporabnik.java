package predavanje03;

import java.util.Scanner;
public class Uporabnik {
    public static void main(String[] args) {
        System.out.print("Vpiši svoje ime: ");

        Scanner sc = new Scanner(System.in);
        String ime = sc.nextLine();

        if(!ime.contains("0-9")) System.exit(0);
        System.out.print("Vnesi svojo starost: ");
        int starost = sc.nextInt();
        System.out.printf("Pozdavljen %s, ki si star %d%n", ime, starost);
    }
}
