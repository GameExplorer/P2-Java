package kviz4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IzpisBesedila {
    public static void main(String[] args) {
        izpisiBesedilo("src/kviz4/assets/tekst.txt", 10,20);
    }

    public static void izpisiBesedilo(String imeDatoteke, int n, int s) {
        try {
            Scanner sc = new Scanner(new File(imeDatoteke));
            StringBuilder stavek = new StringBuilder();

            while(sc.hasNext()) {
                String beseda = sc.next();
                if(stavek.length() + beseda.length() <= 20) {
                    stavek.append(beseda).append(" ");
                }
                else {
                    int d = s - stavek.length();

                    for(int i = 0; i <= (d %  2 == 1 ? d / 2 : d / 2 - 1); i++) {
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
            sc.close();
        }
        catch (FileNotFoundException fne) {
            fne.printStackTrace();
        }
    }
}
