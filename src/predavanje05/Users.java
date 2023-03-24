package predavanje05;

import java.io.File;
import java.util.Scanner;

public class Users {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/predavanje05/passwd.txt"));

        while(sc.hasNextLine()) {
            String vrstica = sc.nextLine();
            String[] deli = vrstica.split(":"); //regularni izraz
            System.out.printf("Ime: %s, uid: %s\n", deli[0], deli[2]);
        }
    }
}
