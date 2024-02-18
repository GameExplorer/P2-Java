package vaje08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Upravljanje {

    // Iz podane datoteke prebere podatke o računih in ustvari račune v podani banki.
    private static void dodajRacune(Banka banka) throws FileNotFoundException {
        Scanner vhod = new Scanner(new File("src/vaje08/Banka/racuni.txt"));
        while (vhod.hasNextLine()) {
            String[] podatki = vhod.nextLine().split(";");
            if (podatki[0].equalsIgnoreCase("tekoci")) {
                banka.dodajTekociRacun(podatki[1], Double.parseDouble(podatki[2]));
                banka.polog(podatki[1], Double.parseDouble(podatki[3]));
            } else {
                banka.dodajVarcevalniRacun(podatki[1], Double.parseDouble(podatki[2]));
                banka.polog(podatki[1], Double.parseDouble(podatki[3]));
            }
        }
        vhod.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Banka bankaFRI = new Banka();

        // v banki naredimo račune z določenimi stanji, vse podatke preberemo iz datoteke
        dodajRacune(bankaFRI);

        // izpiši vse račune
        bankaFRI.izpisiRacune();
        System.out.println();

        // izpiši vse tekoče račune
        bankaFRI.izpisiRacune(false);
        System.out.println();

        String stevilkaRacuna = "SI56 1234 4321 1234 126"; // tekoči z limitom 100 €
        // stevilkaRacuna = "SI56 7823 4563 8346 123"; // varčevalni z 0,1% obrestmi
        // položi znesek na račun
        if (bankaFRI.polog(stevilkaRacuna, 100))
            System.out.printf("Na račun %s je bil polog uspešno izveden.%n", stevilkaRacuna);
        else
            System.out.printf("Pri pologu na račun %s je prišlo do napake.%n", stevilkaRacuna);
        bankaFRI.izpisiRacune(false);
        System.out.println();

        // dvigni znesek z računa
        if (bankaFRI.dvig(stevilkaRacuna, 300))
            System.out.printf("Z računa %s je bil dvig uspešno izveden.%n", stevilkaRacuna);
        else
            System.out.printf("Pri dvigu z računa %s je prišlo do napake.%n", stevilkaRacuna);
        // dvigni znesek z računa
        if (bankaFRI.dvig(stevilkaRacuna, 50))
            System.out.printf("Z računa %s je bil dvig uspešno izveden.%n", stevilkaRacuna);
        else
            System.out.printf("Pri dvigu z računa %s je prišlo do napake.%n", stevilkaRacuna);
        bankaFRI.izpisiRacune(false);
        System.out.println();

        // izpiši vse varčevalne račune
        bankaFRI.izpisiRacune(true);
        System.out.println();

        // dodaj obresti vsem varčevalnim računom in izpiši nova stanja
        bankaFRI.dodajObresti();
        System.out.println("Na varčevalne račune so dodane obresti.");
        bankaFRI.izpisiRacune(true);
        System.out.println();

        // uredi račune padajoče po stanju in jih izpiši
        bankaFRI.sortirajRacune("stanje", true);
        System.out.println("Urejanje računov (po stanju padajoče):");
        bankaFRI.izpisiRacune();
        System.out.println();

        // uredi račune naraščajoče po številki in jih izpiši
        bankaFRI.sortirajRacune("stevilka", false);
        System.out.println("Urejanje računov (po številki naraščajoče):");
        bankaFRI.izpisiRacune();
    }
}


