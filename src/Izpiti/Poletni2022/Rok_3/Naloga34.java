package Izpiti.Poletni2022.Rok_3;

import java.io.File;
import java.util.Scanner;

/**
 * Program prebere tekstovno datoteko ter izpiše njeno vsebino na zaslov v več vrstic
 * tako, da bo vsaka vrstica vsebovala natanko n znakov. Vsaka bseda mora biti v celoti napisana v eni
 * vrstici
 */
public class Naloga34 {
    public static void main(String[] args) {
        args = new String[]{"src/Izpiti/Poletni2022/Rok_3/besedilo.txt", "10"};

        int n = Integer.parseInt(args[1]);

        try (Scanner sc = new Scanner(new File(args[0]))) {
            sc.useDelimiter("\\Z");
            String[] besede = sc.next().split(" +"); //razbijemo po presledku
            int dolzinaTrenutneVrstice = 0;
            String presledek = ""; // presledek pred bsedo

            for(int i = 0; i < besede.length; i++) { //sprehod po besedah
                if(dolzinaTrenutneVrstice + besede[i].length() + presledek.length() > n) { //če je n manjši od dolžine vrstice
                    System.out.println("_".repeat(n - dolzinaTrenutneVrstice)); //izpiešm "_" do n - dolzineTrenutne
                    dolzinaTrenutneVrstice = 0; //ponastavim vrednosti
                    presledek = "";
                }
                System.out.print(presledek + besede[i]); //izpišem besedilo
                dolzinaTrenutneVrstice += besede[i].length() + presledek.length(); //nova dolzina trenutne vrstice
                presledek = " "; // od zdaj naprej pa do nove vrstice je presledek
            }
            System.out.println("_".repeat(n -dolzinaTrenutneVrstice));
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
}