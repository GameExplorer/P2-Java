package Izpiti.Poletni2022.Rok_1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Razred Ocena ima informacije o ocenah
 */
class Ocena {
    String id;
    String ime;
    String predmet;
    int ocena;

    public Ocena(String podatki) {
        String[] deli = podatki.split(":"); //ker beremo podatke iz datoteke jo razbijemo po ":"
        id = deli.length > 0 ? deli[0] : "?"; //pogledamo ali podatki ustrezajo
        predmet = deli.length > 1 ? deli[1] : "?";
        ocena = deli.length > 2 ? Integer.parseInt(deli[2]) : 0;
    }
}

/**
 * Razred Student, hrani informacije o studentu
 */
class Student {
    String id;
    String ime;

    Student(String podatki) {
        String[] deli = podatki.split(":");
        id = deli.length > 0 ? deli[0] : "?";
        ime = deli.length > 1 ? deli[1] : "?";
    }
}

public class Naloga12 {

    public static void main(String[] args) {
        args = new String[]{"src/Izpiti/Poletni2022/Rok_1/studenti.txt", "src/Izpiti/Poletni2022/Rok_1/predmeti.txt",
                "src/Izpiti/Poletni2022/Rok_1/ocene.txt"};

        ArrayList<Student> studenti = new ArrayList<>(); //seznam studentov

        try (Scanner sc = new Scanner(new File(args[0]))) { //odprem studenti.txt
            while(sc.hasNextLine()) {
                studenti.add(new Student(sc.nextLine())); //dodam vsakega studenta v seznam
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        ArrayList<String> predmeti = new ArrayList<>(); //seznam predmetov

        try(Scanner sc = new Scanner(new File(args[1]))) { //odprem predmeti.txt
            while(sc.hasNextLine()) {
                predmeti.add(sc.nextLine()); //dodam vsak predmet v seznam predmetov
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        ArrayList<Ocena> ocene = new ArrayList<>(); //seznam ocen

        try(Scanner sc = new Scanner(new File(args[2]))) { //odprem datoteko ocene.txt
            while(sc.hasNextLine()) {
                ocene.add(new Ocena(sc.nextLine())); //dodam ocene v seznam ocene
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

        for(int i = 0; i < studenti.size(); i++) { //sprehodim po seznamu studentov
            Student s = studenti.get(i); //dobim vsakega studenta in ga izpišem
            System.out.println(s.ime);

            for(int j = 0; j < predmeti.size(); j++) { //sprehodim se po seznamu predmetov
                ArrayList<Integer> o = new ArrayList<>(); //nov seznam ustvarim

                for(int k = 0; k < ocene.size(); k++) { //sprehodim po seznamu ocen
                    // dodam oceno k novemu seznamu
                    if(ocene.get(k).predmet.equals(predmeti.get(j)) && // pogleda ali ocena ustreza predmetu
                        studenti.get(i).id.equals(ocene.get(k).id)) { // pogleda ali je id studenta enak kot id v ocene
                            o.add(ocene.get(k).ocena);
                    }
                }

                Collections.sort(o); //sortiram ocene

                String os = o.toString().replaceAll("[\\[\\]]", ""); //zamenjam vse []
                if(os.isEmpty()) //če ni ocene
                    os = "/";

                System.out.printf("  %5s: %s %n", predmeti.get(j), os); //izpis
            }
        }
    }
}