package predavanje01;

import java.util.Scanner;
public class Statistika {
    public static void main(String[] args) {
        System.out.print("Vpiši niz: ");
        Scanner sc = new Scanner(System.in);
        String niz = sc.nextLine();

        //prva crka
        System.out.println("Prva črka: " + niz.charAt(0));
        System.out.println("Zadnja črka: " + niz.charAt(niz.length()-1));
        System.out.println("Brez presledkov: " + niz.replace(" ", ""));

        String brezPresledkov =  niz.replace(" ", "");
        int stbesed = niz.length() - brezPresledkov.length() + 1;
        System.out.println("Število besed: " + stbesed);
        System.out.println("Celotna dolžina: " + niz.length());
        System.out.print("Obrnjen niz: ");
        for(int i = niz.length() - 1; i >= 0; i--) {
            System.out.print(niz.charAt(i));
        }
        System.out.println();
    }
}
