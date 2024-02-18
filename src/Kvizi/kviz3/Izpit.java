package kviz3;

import java.io.File;
import java.util.*;

public class Izpit {
    public static void main(String[] args) {
        preberiInIzpisi("src/kviz3/assets/i1.txt");
    }

    static void preberiInIzpisi(String oznaka) {
        try {
            Scanner sc = new Scanner(new File(oznaka + "-prijave.txt"));
            TreeMap<String, String[]> podatki = new TreeMap<>();

            while(sc.hasNextLine()) {
                String[] vrstica = sc.nextLine().split(":");
                if(vrstica.length == 2) {
                    podatki.put(vrstica[0], new String[] {vrstica[1], "VP"});
                }
            }
            sc.close();

            for(int i = 1; i <= 4; i++) {
                sc = new Scanner(new File(oznaka + "-n" + i + ".txt"));
                while(sc.hasNextLine()) {
                    String[] vrstica = sc.nextLine().split(":");
                    if(podatki.containsKey(vrstica[0])) {
                        String[] podatek = podatki.get(vrstica[0]);
                        if(podatek[1].equals("VP")) { podatek[1] = "0"; }

                        podatek[1] = String.valueOf(Integer.parseInt(podatek[1]) + Integer.parseInt(vrstica[1]));
                        podatki.replace(vrstica[0], podatek);
                    }
                }
            }
            sc.close();
            SortedSet<java.util.Map.Entry<String, String[]>> sortiraniPodatki = new java.util.TreeSet<>(
                    (e1, e2) -> {
                        int rez = e1.getValue()[0].compareTo(e2.getValue()[0]);
                        return rez != 0 ? rez : 1;
                    }
            );
            sortiraniPodatki.addAll(podatki.entrySet());
            for(Map.Entry<String, String[]> entry : sortiraniPodatki) {
                String id = entry.getKey();
                String[] podatek = entry.getValue();
                System.out.println(id + ":" + podatek[0] + ":" + podatek[1]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
