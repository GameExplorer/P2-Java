package Kvizi.Kvizi4;

import edu.princeton.cs.algs4.In;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Kviz9 {
    public static void histogram(String vhodnaDatoteka) {
        try(DataInputStream vhod = new DataInputStream(new FileInputStream(vhodnaDatoteka))) {
            if(vhodnaDatoteka.substring(vhodnaDatoteka.lastIndexOf(".")).equals(".p2b")) {
                if(vhod.readByte() == 0x50 && vhod.readByte() == 0x32 && vhod.readByte() == 0x42) {
                    int sirina = vhod.readInt();
                    int visina = vhod.readInt();

                    TreeMap<String, Integer> barve = new TreeMap<>(Comparator.comparingInt(o -> Integer.parseInt(o, 16)));

                    for(int i = 0; i < sirina * visina; i++) {
                        byte r = vhod.readByte();
                        byte g = vhod.readByte();
                        byte b = vhod.readByte();

                        String barva = Integer.toString(Integer.parseInt(String.format("%02x%02x%02x", r,g,b), 16), 16);

                        if(barve.containsKey(barva)) {
                            barve.put(barva, barve.get(barva) + 1);
                        } else {
                            barve.put(barva,1);
                        }
                    }

                    for(Map.Entry<String, Integer> entry : barve.entrySet()) {
                        System.out.printf("%6s %d", entry.getKey(), entry.getValue());
                        System.out.println();
                    }
                } else {
                    System.out.printf("Datoteka %s ni v formatu P2B: napaka pri podpisu slike.", vhodnaDatoteka);
                }
            } else {
                System.out.printf("Datoteka %s ni v formatu P2B: napaka v imenu datoteke", vhodnaDatoteka);
            }
        } catch (Exception e) {
            System.out.println("Napaka: " + e);
        }

    }
    public static void main(String[] args) {
        histogram("src/Kvizi/viri/ikona.p2b");
    }
}
