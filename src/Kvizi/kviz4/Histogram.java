package kviz4;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Histogram {
    public static void main(String[] args) {
        histogram("src/kviz4/assets/RGB.p2b");
        histogram("src/kviz4/assets/ikona1.p2b");
        histogram("src/kviz4/assets/ikona2.png");
    }

    public static void histogram(String imeDatoteke) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(imeDatoteke));

            if(imeDatoteke.substring(imeDatoteke.lastIndexOf(".")).equals(".p2b")) {
                if(dis.readByte() == 0x50 && dis.readByte() == 0x32 && dis.readByte() == 0x42) {
                    int sirina = dis.readInt();
                    int visina = dis.readInt();

                    TreeMap<String, Integer> barve = new TreeMap<>(
                            Comparator.comparingInt(o -> Integer.parseInt(o, 16))
                    );

                    for(int i = 0; i < sirina * visina; i++) {
                        byte r = dis.readByte();
                        byte g = dis.readByte();
                        byte b = dis.readByte();

                        String barva = Integer.toString(Integer.parseInt(String.format("%02x%02x%02x", r,g,b), 16), 16);

                        if(barve.containsKey(barva)) {
                            barve.put(barva, barve.get(barva) + 1);
                        }
                        else {
                            barve.put(barva, 1);
                        }
                    }
                    for(Map.Entry<String, Integer> entry : barve.entrySet()) {
                        System.out.printf("%6s %d", entry.getKey(), entry.getValue());
                        System.out.println();
                    }
                }
                else {
                    System.out.println("Datoteka ni v formatu P2B: napaka pri podpisu slike.");
                }
            }
            else {
                System.out.println("Datoteka ni v formatu P2B: napaka v imenu datoteke.");
            }
            dis.close();
        }
        catch (FileNotFoundException fne) {
            System.out.println(imeDatoteke + " (No such file or directory)");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
