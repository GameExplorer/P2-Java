package Kvizi.Kvizi3;

import edu.princeton.cs.algs4.In;

import java.io.File;
import java.util.*;

public class Kviz13 {

    public static void preberiInIzpisi(String oznaka) {
        try(Scanner sc = new Scanner(new File(oznaka + "-prijave.txt"))) {
            TreeMap<String, String[]> podatki = new TreeMap<>();
            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split(":");
                if(vrstica.length == 2) {
                    podatki.put(vrstica[0], new String[] {vrstica[1], "VP"});
                }
            }

            for(int i = 1; i <= 4; i++) {
                try (Scanner vhod = new Scanner(new File(oznaka + "-n" + i + ".txt"))) {
                    while(vhod.hasNextLine()) {
                        String[] vrstica = vhod.nextLine().split(":");
                        if(podatki.containsKey(vrstica[0])) {
                            String[] podatek = podatki.get(vrstica[0]);
                            if(podatek[1].equals("VP")) {
                                podatek[1] = "0";
                            }
                            podatek[1] = String.valueOf(Integer.parseInt(podatek[1]) + Integer.parseInt(vrstica[1]));
                            podatki.replace(vrstica[0], podatek);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Napaka: " + e);
                }
            }

            SortedSet<Map.Entry<String, String[]>> sortiraniPodatki = new TreeSet<>(
                    (e1, e2) -> {
                        int rezultat = e1.getValue()[0].compareTo(e2.getValue()[0]);
                        return rezultat != 0 ? rezultat : 1;
                    }
            );

            sortiraniPodatki.addAll(podatki.entrySet());

            for(Map.Entry<String, String[]> entry : sortiraniPodatki) {
                String id = entry.getKey();
                String[] podatek = entry.getValue();
                System.out.println(id + ":" + podatek[0] + ":" + podatek[1]);
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }
    }
    public static void main(String[] args) {
        preberiInIzpisi("src/Kvizi/viri/i1");
    }
}
