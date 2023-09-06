package Kvizi.Kvizi4;

import java.io.File;
import java.util.Scanner;

public class Kviz7 {
    public static void izpisiBesedilo(String imeDatoteke, int n, int s) {
            try(Scanner vhod = new Scanner(new File(imeDatoteke))) {
                StringBuilder stavek = new StringBuilder();

                while(vhod.hasNext()) {
                    String beseda = vhod.next();

                    if(stavek.length() + beseda.length() <= n) {
                        stavek.append(beseda).append(" ");
                    } else {
                        int d = s - stavek.length();
                        for(int i = 0; i <= (d % 2 == 1 ? d / 2 : d / 2 - 1); i++) {
                            System.out.print(".");
                        }

                        System.out.print(stavek.toString().trim());

                        for(int i = 0; i <= d / 2; i++) {
                            System.out.print(".");
                        }
                        System.out.println();
                        stavek = new StringBuilder(beseda).append(" ");
                    }
                }

                int d = s - stavek.length();

                for(int i = 0; i <= (d % 2 == 1 ? d / 2 : d / 2 - 1); i++) {
                    System.out.print(".");
                }

                System.out.print(stavek.toString().trim());

                for(int i = 0; i <= d / 2; i++) {
                    System.out.print(".");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Napaka: " + e);
            }

    }

    public static void main(String[] args) {
        izpisiBesedilo("src/Kvizi/viri/besedilo3.txt", 20,30);
    }
}
