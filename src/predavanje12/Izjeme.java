package predavanje12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Izjeme {
    public static void main(String[] args) {
        int a = 5;
        //System.out.println(10/a);
        a = 0;

        try {
            System.out.println(10 / a);
            Scanner sc = new Scanner(new File("a.txt"));
        }
        catch (Exception e) { //Exception sprejme vse napake
            //System.out.println("Prišlo je do napake: " + e);

            if(e instanceof ArithmeticException) {
                System.out.println("Napaka pri deljenju");
            }
            else if(e instanceof FileNotFoundException) {
                System.out.println("Datoteke ne obstaja");
            }

            //Drugo sporočilo
            System.out.println(e.getMessage());
            //rdeče besedilo
            e.printStackTrace();
        }
        // Izpis vsake napake posebej
        /*
        catch (ArithmeticException e) {
            System.out.println(e);
            //System.out.println("Deljenje ni mogoče");
        }
        catch (FileNotFoundException e) {
            System.out.println("Datoteke ne obstaja");
        }*/

        System.out.println("Nadaljevanje programa");
    }
}
